package com.xulei.spring.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xulei.spring.model.MovieListModel;
import org.apache.http.client.HttpClient;

import java.util.List;

/**
 * @Classname MovieListService
 * @Description TODO
 * @Date 2020/4/20 16:41
 * @Created by xulei
 */
public interface MovieListService extends IService<MovieListModel> {
    void downDetail(HttpClient httpClient,String prefix,List<MovieListModel> data);
}
