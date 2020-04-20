package com.xulei.spring.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xulei.spring.model.MovieListModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname MovieListMapper
 * @Description TODO
 * @Date 2020/4/20 16:43
 * @Created by xulei
 */
@Mapper
public interface MovieListMapper extends BaseMapper<MovieListModel> {
}
