package com.xulei.rabbitmq.code.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/14 22:40
 * @Version 1.0
 */
@Data
@TableName("good")
public class Good extends Model<Good> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int goodId;
    private int status;
    private Date create_time;


    @Override
    protected Serializable pkVal() {
        return id;
    }
}
