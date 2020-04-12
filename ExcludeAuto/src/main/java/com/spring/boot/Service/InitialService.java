package com.spring.boot.Service;

import com.spring.boot.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author XULEI
 * @ClassName InitialService
 * @description TODO
 * @Date 2020/4/12 10:26
 * @Version 1.0
 */
@Service
public class InitialService {

    @Autowired
    CacheService cacheService;

    @PostConstruct
    public void setData(){

        cacheService.set("name","银行");
    }
}
