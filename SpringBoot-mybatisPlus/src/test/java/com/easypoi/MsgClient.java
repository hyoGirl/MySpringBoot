package com.easypoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
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
public class MsgClient implements Serializable{

    private java.lang.String id;
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
    // 创建人
    private String           createBy    = null;
}
