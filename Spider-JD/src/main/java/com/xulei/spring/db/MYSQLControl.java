package com.xulei.spring.db;


import com.xulei.spring.model.JdModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class MYSQLControl {



     static DataSource dataSource = MyDataSource.getDataSource();

    static QueryRunner qr = new QueryRunner(dataSource);

    public static void executeInsert(List<JdModel> jingdongdata) {


        //使用二维数组来创建数据.第一个是图书容量，第二个是单独的数组
       Object[][] params=new Object[jingdongdata.size()][3];
       for(int i=0;i<params.length;i++){
           params[i][0]=jingdongdata.get(i).getBookId();
           params[i][1]=jingdongdata.get(i).getBookName();
           params[i][2]=jingdongdata.get(i).getBookPrice();
       }

       String sql="insert into JDModel(bookID,bookName,bookPrice) values(?,?,?)";

        try {
            qr.batch(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("数据库插入成功条数为："+jingdongdata.size());

    }
}
