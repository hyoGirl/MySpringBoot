package com.mybatis.plus.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2020/1/16 22:58
 * @Version 1.0
 */
@Data
public class MsgClientDto implements Serializable{

    private String id;
    // 电话号码(主键)
    @Excel(name = "电话号码")
    private String           clientPhone = null;
    // 客户姓名
    @Excel(name = "姓名")
    private String           clientName  = null;
    // 所属分组
    @Excel(name = "分组")
    private String   group       = null;
    // 备注
    @Excel(name = "备注")
    private String           remark      = null;
    // 生日
    @Excel(name = "出生日期", format = "yyyy-MM-dd", width = 20)
    private Date birthday    = null;
}
