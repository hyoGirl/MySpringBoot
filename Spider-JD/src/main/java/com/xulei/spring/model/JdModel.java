package com.xulei.spring.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xulei
 */
@Data
@TableName("jd_model")
public class JdModel extends Model<JdModel> implements Serializable {


    private static final long serialVersionUID = -9081259429719031051L;

    @TableId(type = IdType.AUTO)
    private  Integer id;

    private String bookId;
    private String bookName;
    private String bookPrice;


}
