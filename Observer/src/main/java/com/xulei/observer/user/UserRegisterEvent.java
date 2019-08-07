package com.xulei.observer.user;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/7 23:05
 * @Version 1.0
 */
@Data
public class UserRegisterEvent extends ApplicationEvent{

    //注册用户对象
    private UserBean user;

    /**
     * 重写构造函数
     * @param source 发生事件的对象
     * @param user 注册用户对象
     */
    public UserRegisterEvent(Object source,UserBean user) {
        super(source);
        this.user = user;
    }
}
