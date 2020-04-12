package com.mybatis.plus.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MonitorDto {


    //单号
    @Excel(name = "运单号",  width = 25)
    private String ship_id;

    // 客户ID
    @Excel(name = "客户名称", width = 20)
    private String cust_cd;
    // 路线选择
    @Excel(name = "路线选择",  width = 20)
    private String ship_type;

    // 下单时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "下单时间",  width = 35,format = "yyyy-MM-dd HH:mm:ss")
    private Date entr_ship_tm;

    // 接单时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "接单时间",  width = 30,format = "yyyy-MM-dd HH:mm:ss")
    private Date acc_tm;

    // 揽件时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "揽件时间", width = 35,format = "yyyy-MM-dd HH:mm:ss")
    private Date pick_tm;


    // 结算重量
    @Excel(name = "结算重量", width = 25)
    private String charge_wgt;


    // 签收状态
    @Excel(name = "签收状态",  width = 25)
    private String delv_status;

    // 物流状态不导出
    private String curr_status;

    // 预测签收网点
    @Excel(name = "预测网点",  width = 30)
    private String frt_brch;

    // 延误类型
//    @Excel(name = "延误类型",  width = 100)
    private String delay_flag;


    // 时效指标
    @Excel(name = "时效指标", width = 25)
    private String rcv_flg;

//    @Excel(name = "时效签收",  width = 25)
//    private String prescription_flg;


    // 清场频次
    @Excel(name = "清场频次", width = 30)
    private String fld_frqc_cd;

    // 应签收频次
    @Excel(name = "应签收频次",  width = 25)
    private String frqc_cd;


    // 频次应签收时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "频次应签收时间",  width = 30,format = "yyyy-MM-dd HH:mm:ss")
    private Date fld_frqc_delv_tm;


    // 频次签收
    @Excel(name = "频次签收", width = 20)
    private String frqc_delv_flag;


    // 派前电联
    @Excel(name = "派前电联", width = 20)
    private String iscall;

    @Excel(name = "通话时间",  width = 25)
    private String sndtime;

    // 通话时长
    @Excel(name = "通话时长(秒)",  width = 25)
    private String answertime;

    @Excel(name = "振铃时长(秒)",  width = 25)
    private String ringtime;

    // 呼叫状态
    @Excel(name = "呼叫状态",  width = 25)
    private  String call_status;


    // 业务员签收延迟
    @Excel(name = "业务员签收延迟",  width = 25)
    private String emp_delv_flag;


    // 总耗时
//    @Excel(name = "总耗时",  width = 20)
    private String tot_delv_hr;

    // 揽件耗时
//    @Excel(name = "揽件耗时",  width = 20)
    private String fst_trans_cost;


    // 分拨中转耗时
//    @Excel(name = "分拨中转耗时", width = 30)
    private String trans_cost;


    // 网点派件耗时
//    @Excel(name = "网点派件耗时",  width = 25)
    private String site_trans_cost;

    // 签收耗时
//    @Excel(name = "签收耗时", width = 25)
    private String delv_hr;

    // 始发大区
    @Excel(name = "始发大区", width = 25)
    private String grtr_dist_cd1;

    // 始发省份
    @Excel(name = "始发省份", width = 25)
    private String snd_prov;

    // 始发城市
    @Excel(name = "始发城市", width = 25)
    private String snd_city;

    // 始发区县
    @Excel(name = "始发区县",  width = 25)
    private String snd_cnty;

    // 始发网点
    @Excel(name = "始发网点", width = 60)
    private String strt_brch_cd;



    // 目的大区
    @Excel(name = "目的大区",  width = 25)
    private String grtr_dist_cd2;
    // 目的省份
    @Excel(name = "目的省份",  width = 25)
    private String rcv_prov;
    // 目的城市
    @Excel(name = "目的城市", width = 25)
    private String rcv_city;
    // 目的区县
    @Excel(name = "目的区县",  width = 25)
    private String rcv_cnty;

    // 目的网点
    @Excel(name = "目的网点", width = 60)
    private String dest_brch_cd;


    // 最早中转公司
    @Excel(name = "最早中转公司",  width = 25)
    private String fst_dbct;

    // 最早中转时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "最早中转时间",  width = 30,format = "yyyy-MM-dd HH:mm:ss")
    private Date fst_trans_tm;

    // 最晚中转公司
    @Excel(name = "最晚中转公司",  width = 25)
    private String lst_dbct;

    // 最晚中转时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "最晚中转时间",  width = 30,format = "yyyy-MM-dd HH:mm:ss")
    private Date lst_trans_tm;

    // 中转发出时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "中转发出时间",  width = 30,format = "yyyy-MM-dd HH:mm:ss")
    private Date trans_tm;


    // 分发网点
    @Excel(name = "分发网点",  width = 60)
    private String lst_dist_site;

    // 分发业务员
    @Excel(name = "分发业务员", width = 25)
    private String dist_emp;

    // 分发业务员时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "分发业务员时间",  width = 30,format = "yyyy-MM-dd HH:mm:ss")
    private Date fst_dist_tm;

    // 签收站点
    @Excel(name = "签收站点",  width = 60)
    private String delv_site;

    // 派送业务员
    @Excel(name = "签收业务员", width = 25)
    private String delv_emp;


    // 签收时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Excel(name = "签收时间",  width = 30,format = "yyyy-MM-dd HH:mm:ss")
    private Date act_delv_tm;


    // 时效
    private String prescription;
    // 目的分拨
    private String dest_dbct_cd;

    // 入库时间
    private Date ins_db_tm;

    // 统计日期
    private String stat_dt;
    private String tlns_cd;






}
