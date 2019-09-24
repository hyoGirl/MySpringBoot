package com.xulei.redis.controller;

import com.xulei.redis.common.RedisDistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/24 21:32
 * @Version 1.0
 */
@RequestMapping("/test")
@RestController
public class RedisController {

    @Autowired
    RedisDistributedLock redisDistributedLock;


    @GetMapping("/redis")
    public void redis(){
        try {
            redisDistributedLock.lock("lock002",1000*8,5,500);
//            redisDistributedLock.lockByTimeOut("lock001",1000*8,1000*10,500);
            // 模拟业务操作5秒
            Thread.sleep(1000*5);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            redisDistributedLock.releaseLock("lock002");
//            redisDistributedLock.releaseLock("lock001");
        }

    }
}
