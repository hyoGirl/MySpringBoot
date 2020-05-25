package com.xulei.spring.controller;

import com.alibaba.fastjson.JSON;
import com.xulei.spring.db.MYSQLControl;
import com.xulei.spring.model.JdModel;
import com.xulei.spring.model.MovieListModel;
import com.xulei.spring.processor.HtmlParse;
import com.xulei.spring.processor.MovieParse;
import com.xulei.spring.service.JdService;
import com.xulei.spring.service.MovieListService;
import com.xulei.spring.util.URLFecter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @Classname JdController
 * @Description TODO
 * @Date 2020/4/20 9:25
 * @Created by xulei
 */
@RestController
@Slf4j
public class SpiderController {

    @Autowired
    JdService jdService;

    @Autowired
    MovieListService movieListService;


    /**
     * 方法不可以使用了，京东现在需要登录了
     */
    @GetMapping("/jd")
    public void jd(){

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
//        MYSQLControl.executeInsert(bookdatas);

        jdService.insertData(bookdatas);

    }

    String prefix="https://www.dytt8.net";

    /**
     * 获取影片列表数据
     */
    @GetMapping("/movie")
    public void movieList() throws  Exception{

        HttpClient httpClient = HttpClients.createDefault();

        String url = prefix+"/html/gndy/dyzz/list_23_1.html";
        String html = new URLFecter().parseURL(httpClient, url);
        List<MovieListModel> data = new MovieParse().getData(html);
//        movieListService.saveBatch(data);

        movieListService.downDetail(httpClient,prefix,data);




    }
//    https://www.dytt8.net/html/gndy/dyzz/20200413/59933.html





}
