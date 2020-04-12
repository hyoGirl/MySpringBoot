package com.spring.boot.cache;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author XULEI
 * @ClassName RemoteCacheService
 * @description TODO
 * @Date 2020/4/11 18:53
 * @Version 1.0
 */
public class RemoteCacheService implements CacheService {

    private RedisTemplate redisTemplate;


    public RemoteCacheService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        Object obj = redisTemplate.opsForValue().get(key);

        System.out.println("从redis缓存中获取的数据为： "+obj);
        if(null!=obj){
            return  obj.toString();
        }
        return null;
    }
}
