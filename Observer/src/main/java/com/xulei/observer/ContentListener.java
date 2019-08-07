package com.xulei.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/7 22:26
 * @Version 1.0
 */
@Component
public class ContentListener implements ApplicationListener<ContentEvent>{

    @Override
    @Async
    public void onApplicationEvent(ContentEvent orderObservable) {

        System.out.println(Thread.currentThread() + "用户下单成功！手机收到邮件!内容为{}"+ orderObservable.getContent());
    }
}
