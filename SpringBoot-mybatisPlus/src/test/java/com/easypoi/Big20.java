package com.easypoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2020/1/16 23:21
 * @Version 1.0
 */
@Data
public class Big20 implements Serializable {

    private java.lang.String id;
    // 电话号码(主键)
    @Excel(name = "电话号码",fixedIndex = 0)
    private String           clientPhone = null;
    // 客户姓名
    @Excel(name = "姓名",fixedIndex = 1)
    private String           clientName  = null;
    // 所属分组
    @Excel(name = "分组",fixedIndex = 2)
    private String   group       = null;
    // 备注
    @Excel(name = "备注",fixedIndex = 3)
    private String           remark      = null;
    // 生日
    @Excel(name = "出生日期", format = "yyyy-MM-dd", width = 20,fixedIndex = 4)
    private Date birthday    = null;
    // 创建人
    private String           createBy    = null;
}
