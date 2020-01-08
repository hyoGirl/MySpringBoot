package com.mybatis.plus.entity;

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
public class GroupDto implements Serializable {

    private int id;
    private String userName;

    private Date createtime;

//    private Integer state;

}
