package com.yd.tk.csv;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * author:徐磊
 * Date:2020/1/16
 * Time:19:33
 */
@Data
@ExcelTarget("readDto")
public class ReadDto {

    @Excel(name = "日期")
    private String collectDt;
    @Excel(name = "省份")
    private String prov;
//    private String city;
//    private String brch_cd;
//    private String prescription;
//    private String count;
//    private String collected_cnt;
//    private String nomal_collect_cnt;
//    private String abn_collect_cnt;
//    private String no_collect_cnt;
//    private String collect_rate;
//    private String reach_cnt;
//    private String no_reach_cnt;
//    private String reach_rate;
//    private String before_send_ring;
//    private String ring_rate;
}
