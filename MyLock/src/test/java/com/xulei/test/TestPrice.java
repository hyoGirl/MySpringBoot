package com.xulei.test;

import com.xulei.lock.LockApp;
import com.xulei.lock.dao.PriceMapper;
import com.xulei.lock.entity.Price;
import com.xulei.lock.service.PriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/25 23:17
 * @Version 1.0
 */
@SpringBootTest(classes = LockApp.class)
@RunWith(SpringRunner.class)
public class TestPrice {


    @Autowired
    PriceService priceService;

    @Autowired
    PriceMapper priceMapper;


    @Test
    public void test01(){


        for (int i = 0; i < 10; i++) {
            /**
             * 每次都是获取第一条记录，依次去更改第一条记录。把更改的流水记录保存下去
             */
            Price price = priceService.selectById(1);
            int cron=10;
            //就一个主线程，循环10次，每次把front的值减去10，再写入一次流水记录，正常情况是写入的每条记录都会每次减去10。
            price.setFront(price.getFront().subtract(new BigDecimal(cron)));

            price.setEnd(price.getEnd().add(new BigDecimal(cron)));

            price.setTotal(price.getEnd().add(price.getFront()));

            priceService.updateById(price);

            price.setId(null);



            priceMapper.insert(price);


        }


    }
}
