package com.spring.boot.aop;

import com.alibaba.fastjson.JSON;
import com.spring.boot.util.LocalUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import sun.util.locale.LocaleUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;

@Aspect
@Component
public class RequestAspect {

    Logger logger = LoggerFactory.getLogger(RequestAspect.class);


//    @Pointcut("@within(org.springframework.stereotype.Controller) || @within(org.springframework.web.bind.annotation.RestController)")

    @Pointcut(value = "@within(org.springframework.web.bind.annotation.RestController)")
    public void pointCut() {

    }




    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {

        try {
            LocalUtil.put("mdc_key", UUID.randomUUID().toString());
//            MDC.put("mdc_key", UUID.randomUUID().toString());
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String requestURI = request.getRequestURI();
            long startTime = System.currentTimeMillis();
            String data = preHandler(proceedingJoinPoint, request);


            logger.info("请求的URI:" + requestURI + " 请求的参数：" + data + "   请求的链路ID:" + LocalUtil.get("mdc_key"));
//            logger.info("请求的URI:" + requestURI + " 请求的参数：" + data + "   请求的链路ID:" + MDC.get("mdc_key"));

            Object result = proceedingJoinPoint.proceed();
            long time = System.currentTimeMillis() - startTime;
            String respParam = postHandle(result);
            logger.info("响应的结果为：" + respParam + "   请求耗时为：" + time+ "   请求的链路ID:" + LocalUtil.get("mdc_key"));
            return result+"   请求的链路ID:" + LocalUtil.get("mdc_key");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
//            MDC.clear();
            LocalUtil.clear();
        }
        return null;

    }

    private String postHandle(Object result) {

        if (StringUtils.isEmpty(result)) {
            return result.toString();
        } else {
            return JSON.toJSONString(result);
        }
    }

    private String preHandler(ProceedingJoinPoint proceedingJoinPoint, HttpServletRequest request) {

        String requestParam = "";
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();

//        String name = method.getName();

        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            boolean equals = annotation.annotationType().equals(RequestMapping.class);
            if (equals) {
                //针对requestParam这样的请求参数，但是如果是流，JSON体就有问题
                Map<String, String[]> parameterMap = request.getParameterMap();
                requestParam = JSON.toJSONString(parameterMap);
                break;
            }
        }
        return requestParam;
    }
}
