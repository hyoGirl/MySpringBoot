package com.xulei.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xulei.spring.dao.JdMapper;
import com.xulei.spring.model.JdModel;
import com.xulei.spring.service.JdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName JdServiceImpl
 * @description TODO
 * @author XULEI
 * @Date 2020/4/19 23:10 
 * @Version 1.0
 */
@Service
@Slf4j
public class JdServiceImpl extends ServiceImpl<JdMapper,JdModel> implements JdService {


    @Override
    public void insertData(List<JdModel> bookdatas) {

        //使用二维数组来创建数据.第一个是图书容量，第二个是单独的数组
        Object[][] params=new Object[bookdatas.size()][3];
        for(int i=0;i<params.length;i++){
            params[i][0]=bookdatas.get(i).getBookId();
            params[i][1]=bookdatas.get(i).getBookName();
            params[i][2]=bookdatas.get(i).getBookPrice();
        }

        System.out.println(Arrays.toString(params));


//        String sql="insert into JDModel(bookID,bookName,bookPrice) values(?,?,?)";
//
//        try {
//            qr.batch(sql,params);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        log.info("数据库插入成功条数为："+jingdongdata.size());

    }
}
