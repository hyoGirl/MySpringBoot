package com.xulei.observer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/7 23:03
 * @Version 1.0
 */
@Component
public class UserService {

    @Autowired
    ApplicationContext applicationContext;

    public void register(UserBean user)
    {
        //../省略其他逻辑

        //发布UserRegisterEvent事件
//        applicationContext.publishEvent(new UserRegisterEvent(this,user));
        applicationContext.publishEvent(new UserRegisterEvent(this,user));
    }
}
