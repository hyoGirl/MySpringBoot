package com.xulei.test;

import com.xulei.lock.LockApp;
import com.xulei.lock.dao.PriceVersionMapper;
import com.xulei.lock.entity.PriceVersion;
import com.xulei.lock.service.PriceVersionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/26 21:14
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LockApp.class)
public class TestPriceVersion {

    private static final Logger logger = LoggerFactory.getLogger(TestPriceVersion.class);

    @Autowired
    PriceVersionService priceVersionService;

    @Autowired
    PriceVersionMapper priceVersionMapper;


    @Test
    public  void testVersion()throws Exception{


        final CountDownLatch countDownLatch=new CountDownLatch(3);


        for (int i = 0; i < 3; i++) {

            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
//                    countDownLatch.countDown();

                    PriceVersion priceVersion = priceVersionMapper.selectById(1);
                    int corn=new Random().nextInt(20);
                    logger.info("本次消费金额为："+corn);

                    priceVersion.setFront(priceVersion.getFront().subtract(new BigDecimal(corn)));
                    priceVersion.setEnd(priceVersion.getEnd().add(new BigDecimal(corn)));
                    priceVersion.setTotal(priceVersion.getFront().add(priceVersion.getFront()));
                    int count= priceVersionService.updateByVersion(priceVersion);
                    if (count == 0){
                        logger.info("更新失败");
                    }else {
                        logger.info("更新成功");
                    }
                }
            });

            thread.start();
        }

//        countDownLatch.await();

        Thread.sleep(2000);
        System.out.println("所有测试任务全部完成");

    }



}
