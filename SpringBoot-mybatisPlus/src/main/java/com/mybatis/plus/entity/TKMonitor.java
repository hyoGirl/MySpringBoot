package com.mybatis.plus.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "ods_tk_ship_tbl")
@EqualsAndHashCode(callSuper = true)
public class TKMonitor extends Model<TKMonitor> {

    @TableId(type = IdType.AUTO)
    @Excel(name = "ID", width = 20)
    private Integer id;
    // 客户ID
    @Excel(name = "客户名称", width = 20)
    private String custCd;


    private Integer custSrc;
    //单号
    @Excel(name = "运单号",  width = 25)
    private Long  shipId;
    // 路线选择
    @Excel(name = "路线选择",  width = 20)
    private Integer shipType;
    // 时效签收
    @Excel(name = "时效签收",  width = 20)
    private String prescription;
    // 下单时间
    @Excel(name = "下单时间",  width = 35,format = "yyyy-MM-dd HH:mm:ss")
    private Date entrShipTm;
    // 始发大区
    @Excel(name = "始发大区",  width = 20)
    private Integer grtrDistCd1;
    // 始发省
    @Excel(name = "始发省",  width = 20)
    private Integer sndProv;
    // 始发城市
    @Excel(name = "始发城市",  width = 20)
    private Integer sndCity;
    // 始发区县
    @Excel(name = "始发区县",  width = 20)
    private Integer sndCnty;
    // 始发网点
    @Excel(name = "始发网点",  width = 20)
    private Integer strtBrchCd;
    // 揽件时间
    @Excel(name = "揽件时间",  width = 20)
    private Date pickTm;
    // 揽件延误标志
    @Excel(name = "揽件延误标志",  width = 20)
    private String pickDelayFlag;
    // 最早中转公司
    @Excel(name = "最早中转公司",  width = 20)
    private Integer fstDbct;
    // 最早中转时间
    @Excel(name = "最早中转时间",  width = 20)
    private Date fstTransTm;
    // 交始发中转延误标志
    @Excel(name = "交始发中转延误标志",  width = 20)
    private String fstTransDelayFlag;
    // 揽件耗时
    @Excel(name = "揽件耗时",  width = 20)
    private BigDecimal fstTransCost;
    // 最晚中转公司
    @Excel(name = "最晚中转公司",  width = 20)
    private Integer  lstDbct;
    // 最晚中转时间
    @Excel(name = "最晚中转时间",  width = 20)
    private Date lstTransTm;
    // 中转发出时间
    @Excel(name = "中转发出时间",  width = 20)
    private Date transTm;
    // 分拨中转耗时
    @Excel(name = "分拨中转耗时",  width = 20)
    private BigDecimal transCost;
    private String dbctTransDelayFlag;
    // 目的大区
    @Excel(name = "目的大区",  width = 20)
    private Integer grtrDistCd2;
    // 目的省
    @Excel(name = "目的省",  width = 20)
    private Integer rcvProv;
    // 目的城市
    @Excel(name = "目的城市",  width = 20)
    private Integer rcvCity;
    // 目的区县
    @Excel(name = "目的区县",  width = 20)
    private Integer rcvCnty;
    // 目的分拨
    @Excel(name = "目的分拨",  width = 20)
    private Integer destDbctCd;
    // 目的网点
    @Excel(name = "目的网点",  width = 20)
    private Integer destBrchCd;
    // 分发业务员时间
    @Excel(name = "分发业务员时间",  width = 20)
    private Date fstDistTm;
    // 派送业务员
    @Excel(name = "派送业务员",  width = 20)
    private String delvEmp;
    // 网点派件耗时
    @Excel(name = "网点派件耗时",  width = 20)
    private BigDecimal siteTransCost;
    private String dbctBrchDelayFlg;
    // 签收时间
    @Excel(name = "签收时间",  width = 20)
    private Date actDelvTm;
    // 签收状态
    @Excel(name = "签收状态",  width = 20)
    private Integer delvStatus;
    // 签收耗时
    @Excel(name = "签收耗时",  width = 20)
    private BigDecimal delvHr;
    // 全链路时长
    @Excel(name = "全链路时长",  width = 20)
    private BigDecimal totDelvHr;
    //业务员是否及时签收标志
    @Excel(name = "及时签收",  width = 20)
    private String empDelvFlag;
    // 线路标志
    @Excel(name = "线路标志",  width = 20)
    private String prescriptionFlg;
    // 振铃时长
    @Excel(name = "振铃时长",  width = 20)
    private String ringtime;
    // 通话时长
    @Excel(name = "通话时长",  width = 20)
    private String answertime;
    // 通话时间
    @Excel(name = "通话时间",  width = 20)
    private String sndtime;
    // 结算重量
    @Excel(name = "结算重量",  width = 20)
    private String chargeWgt;
    // 入库时间
    private Date insDbTm;
    // 统计日期
    private String statDt;
    // 清场频次
    private String fldFrqcCd;
    // 应签收频次
    private String frqcCd;
    private String tlnsCd;
    // 频次应签收时间
    private Date fldFrqcDelvTm;
    // 频次签收
    private String frqcDelvFlag;

    // 签收站点
    private String delvSite;
    // 接单时间
    private Date accTm;
    // 预测网点
    private Integer frtBrch;

    // 当前状态
    private String currStatus;

    // 分发网点
    private Integer lstDistSite;

    // 分发业务员
    private String distEmp;


    @Override
    protected Serializable pkVal() {
        return shipId;
    }
}
