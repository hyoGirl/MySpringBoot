package com.xulei.spring.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @Classname MovieListModel
 * @Description 电影列表
 * @Date 2020/4/20 13:50
 * @Created by xulei
 */
@Data
@TableName("sp_movie")
public class MovieListModel extends Model<MovieListModel> implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;

    private String href;
    private String text;
}
