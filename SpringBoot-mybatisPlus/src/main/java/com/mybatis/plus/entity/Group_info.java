package com.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/12/23 22:26
 * @Version 1.0
 */
@Data
@TableName("group_info")
public class Group_info extends Model<Group_info> implements Serializable {

    private int id;
    private String userName;

    private Date createtime;

//    private Integer state;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
