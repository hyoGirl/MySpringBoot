package com.xulei.spring.db;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDataSource {

    public static DataSource getDataSource()throws Exception{

        String DB_URL="jdbc:mysql://127.0.0.1/chunjieboot?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=true";

        String USER="root";
        String PASS="root";
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setPassword("root");
        druidDataSource.setUsername("root");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1/chunjieboot?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=true");
        try {
            druidDataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;


        Connection connection =  DriverManager.getConnection(DB_URL,USER,PASS);

        Statement statement = connection.createStatement();




    }
}
