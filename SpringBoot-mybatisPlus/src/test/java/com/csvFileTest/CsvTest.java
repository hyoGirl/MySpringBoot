package com.csvFileTest;

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
public class CsvTest implements Serializable {

    // 电话号码(主键)
    @Excel(name = "电话号码")
    private String   clientPhone;

}
