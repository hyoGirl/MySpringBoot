package com.xulei.spring.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("jd_model")
public class JdModel extends Model<JdModel> implements Serializable {


    private static final long serialVersionUID = -9081259429719031051L;


    private String bookId;
    private String bookName;
    private String bookPrice;


}
