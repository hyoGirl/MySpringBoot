package com.mybatis.plus.cache;

public interface CacheService {

    void set(String key, String value);

    String get(String key);
}
