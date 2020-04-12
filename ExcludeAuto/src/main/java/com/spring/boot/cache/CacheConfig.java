package com.spring.boot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author XULEI
 * @ClassName CacheConfig
 * @description TODO
 * @Date 2020/4/11 18:57
 * @Version 1.0
 */
@Configuration
public class CacheConfig {

    @Value("${cache.local: true}")
    private Boolean cacheFlag;

    @Autowired
    RedisTemplate redisTemplate;


    @Bean
    public CacheService config() {
        CacheService cacheService =null;
        if(cacheFlag){
            cacheService =new LocalCacheService();
            System.out.println("使用本地缓存模式");
        }else{
            cacheService =new RemoteCacheService(redisTemplate);
            System.out.println("使用Redis缓存模式");
        }
        return cacheService;
    }
}
