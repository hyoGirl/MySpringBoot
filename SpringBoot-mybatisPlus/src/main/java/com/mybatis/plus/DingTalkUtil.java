package com.mybatis.plus;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author chengchen
 * @title: DingTalkUtil
 * @projectName tk_monitor_manage
 * @description: TODO
 * @date 2020/5/14 14:36
 */
public class DingTalkUtil {

    private static final Logger logger = LoggerFactory.getLogger(DingTalkUtil.class);

    private static final int timeout = 10000;

    public static String postJson(String url, String reqStr) {
        String body = null;
        try {
            body = HttpRequest.post(url).body(reqStr).timeout(timeout).execute().body();
        } catch (Exception e) {
            logger.error("DingTalkUtil--postJson", e);
        }
        return body;
    }

    /**
     * 组装请求报文
     *
     * @param content
     * @return
     */
    private static String buildReqStr(String content, boolean isAtAll, List<String> mobileList) {
        //消息内容
        Map<String, String> contentMap = Maps.newHashMap();
        contentMap.put("content", content);

        //通知人
        Map<String, Object> atMap = Maps.newHashMap();

        //1.是否通知所有人
        atMap.put("isAtAll", isAtAll);
        //2.通知具体人的手机号码列表
        atMap.put("atMobiles", mobileList);

        Map<String, Object> reqMap = Maps.newHashMap();
        reqMap.put("msgtype", "text");
        reqMap.put("text", contentMap);
        reqMap.put("at", atMap);

        return JSON.toJSONString(reqMap);
    }

    /**
     * 推送
     * @Author chengchen
     * @Date 2020/5/14 15:05
     * @param isAtAll :     是否通知所有人
     * @param dingUrl :     机器人地址
     * @param content :     内容
     * @param mobileList :  手机号列表（@单独的人）
     * @return void
     **/
    public static void pushMessage(Boolean isAtAll, String dingUrl, String content, List<String> mobileList) {

        try {
            //组装请求内容
            String reqStr = buildReqStr(content, isAtAll, mobileList);
            //推送消息（http请求）
            String result = postJson(dingUrl, reqStr);
            logger.info("DingTalkUtil-pushMessage-result:" + result);
        } catch (Exception e) {
            logger.error("DingTalkUtil-pushMessage", e);
        }
    }
}
