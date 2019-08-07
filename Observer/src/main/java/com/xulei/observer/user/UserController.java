package com.xulei.observer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/7 23:04
 * @Version 1.0
 */
@RestController
public class UserController {

    //用户业务逻辑实现
    @Autowired
    private UserService userService;

    /**
     * 注册控制方法
     *
     * @return
     */
    @RequestMapping(value = "/test2")
    public String register() {

        UserBean user =new UserBean();
        user.setName("AAA");
        user.setPassword("123456");
        //调用注册业务逻辑
        userService.register(user);
        return "注册成功.";
    }
}
