package com.spring.boot.cache;

public interface CacheService {

    void set(String key,String value);

    String get(String key);
}
