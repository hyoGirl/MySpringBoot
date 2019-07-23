package com.spring.boot;

import lombok.Data;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/22 22:33
 * @Version 1.0
 */
public class Hello {

    private String msg;
    private String code;




    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String sayHello() {
        return "hello " + msg+"-->"+code;
    }

}
