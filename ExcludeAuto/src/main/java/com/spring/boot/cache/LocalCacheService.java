package com.spring.boot.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XULEI
 * @ClassName LocalCacheService
 * @description TODO
 * @Date 2020/4/11 18:53
 * @Version 1.0
 */
public class LocalCacheService implements  CacheService {

    private Map<String, String> commonCache = new HashMap<String, String>();

    @Override
    public void set(String key, String value) {
        commonCache.put(key,value);

    }

    @Override
    public String get(String key) {
        return commonCache.get(key);
    }
}
