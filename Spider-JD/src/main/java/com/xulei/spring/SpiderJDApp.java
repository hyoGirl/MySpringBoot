package com.xulei.spring;

import com.xulei.spring.db.MYSQLControl;
import com.xulei.spring.model.JdModel;
import com.xulei.spring.util.URLFecter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

/**
 * @author XULEI
 * @ClassName SpiderJDApp
 * @description TODO
 * @Date 2020/4/19 18:53
 * @Version 1.0
 */
@SpringBootApplication
@Slf4j
public class SpiderJDApp {

    public static void main(String[] args) {

        SpringApplication.run(SpiderJDApp.class,args);
        spider();
    }


    public static void spider() {

        HttpClient httpClient = HttpClients.createDefault();

        List<JdModel> bookdatas = null;
        String url = "http://search.jd.com/Search?keyword=Python&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb";

        try {
            bookdatas = URLFecter.URLParser(httpClient, url);
            for (JdModel bookdata : bookdatas) {
                log.info(bookdata.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        MYSQLControl.executeInsert(bookdatas);
    }
}
