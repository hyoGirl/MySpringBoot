package com.redis.cache.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

public class RedisCacheUtil {
	
	private static Logger logger = LoggerFactory.getLogger(RedisCacheUtil.class);
    private static CacheManager cacheManager = SpringUtil.getBean(CacheManager.class);
    //是否开启缓存
    private static boolean enableCache = true;
 
    /**
     * 获取缓存
     *
     * @param cacheName
     * @param key
     * @return
     */
    public static Object get(String cacheName, String key) {
        if (!enableCache) {
            return null;
        }
        ValueWrapper valueWrapper = getCache(cacheName).get(key);
        if (valueWrapper == null) {
            return null;
        }
        return getCache(cacheName).get(key).get();
    }
 
    /**
     * 获取缓存
     *
     * @param cacheName
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object get(String cacheName, String key, Object defaultValue) {
        if (!enableCache) {
            return defaultValue;
        }
        Object value = get(cacheName, key);
        return value != null ? value : defaultValue;
    }
 
    /**
     * 写入缓存
     *
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value) {
        if (!enableCache) {
            return;
        }
        getCache(cacheName).put(key, value);
    }
 
    /**
     * 从缓存中移除
     *
     * @param cacheName
     * @param key
     */
    public static void remove(String cacheName, String key) {
        if (!enableCache) {
            return;
        }
        getCache(cacheName).evict(key);
    }
 
    /**
     * 从缓存中移除所有
     *
     * @param cacheName
     */
    public static void removeAll(String cacheName) {
        if (!enableCache) {
            return;
        }
        getCache(cacheName).clear();
        logger.info("清理缓存： {} => {}", cacheName);
    }
 
    /**
     * 获得一个Cache，没有则显示日志。
     *
     * @param cacheName
     * @return
     */
    private static Cache getCache(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            throw new RuntimeException("当前系统中没有定义“" + cacheName + "”这个缓存。");
        }
        return cache;
    }
}
