package com.xulei.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xulei.spring.dao.MovieListMapper;
import com.xulei.spring.executor.SpiderExecutors;
import com.xulei.spring.model.MovieListModel;
import com.xulei.spring.processor.MovieParse;
import com.xulei.spring.service.MovieListService;
import com.xulei.spring.util.URLFecter;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Classname MovieListServiceImpl
 * @Description TODO
 * @Date 2020/4/20 16:41
 * @Created by xulei
 */
@Service
public class MovieListServiceImpl extends ServiceImpl<MovieListMapper,MovieListModel> implements MovieListService {


    @Autowired
    Executor spiderExecutors;

    /**
     * 下载详情
     * @param data
     */
    @Override
    public void downDetail(HttpClient httpClient, String prefix, List<MovieListModel> data) {


        int size = data.size();
        for (int i = 0; i < size; i++) {
            MovieListModel movieListModel = data.get(i);
            spiderExecutors.execute(new Runnable() {
                @Override
                public void run() {
                    String href = movieListModel.getHref();
                    href=prefix+href;
                    try {
                        String html = new URLFecter().parseURL(httpClient, href);
                        List<MovieListModel> data = new MovieParse().getData(html);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            });
        }
    }
}
