package com.xulei.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description 基于Redis中的分布式锁代码
 * @Date 2019/8/15 22:22
 * @Version 1.0
 */
@SpringBootApplication
public class RedisLockApp {

    public static void main(String[] args) {
        SpringApplication.run(RedisLockApp.class,args);

    }
}
