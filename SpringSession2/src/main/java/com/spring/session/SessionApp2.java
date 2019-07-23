package com.spring.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Auther: xulei
 * @Date: 2019/7/18 0018 15:42
 * @Description:
 */
@EnableRedisHttpSession
@SpringBootApplication
public class SessionApp2 {

    public static void main(String[] args) {

        SpringApplication.run(SessionApp2.class, args);
    }
}
