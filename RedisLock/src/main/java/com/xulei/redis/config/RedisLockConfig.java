package com.xulei.redis.config;

import com.xulei.redis.common.RedisDistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/24 20:51
 * @Version 1.0
 */
@Configuration
public class RedisLockConfig {

    @Autowired
    RedisTemplate redisTemplate;

    @Bean
    public RedisDistributedLock redisDistributedLock(){
        RedisDistributedLock redisDistributedLock = new RedisDistributedLock(redisTemplate);
        return redisDistributedLock;
    }
}
