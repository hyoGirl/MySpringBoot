package com.mybatis.plus.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2020/1/2 20:40
 * @Version 1.0
 */
@Data
public class PlusDto {

    @TableId(value="id", type= IdType.AUTO)
    private int id;

    @TableField("Name")
    @Excel(name="用户名",orderNum = "1")
    private String name;

    @TableField("Age")
    @Excel(name="年龄",orderNum = "1")
    private int age;

    @TableField("Address")
    @Excel(name="地址",orderNum = "1")
    private String address;

    @TableField("Pwd")
    @Excel(name="密码",orderNum = "1")
    private String pwd;

}
