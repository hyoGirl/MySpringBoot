package com.xulei.lock.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/26 21:08
 * @Version 1.0
 */
@Data
@TableName("price_version")
public class PriceVersion {


    @TableId(type= IdType.AUTO)
    private Integer id;

    private BigDecimal total;
    private BigDecimal front;
    private BigDecimal end;
    private Integer version;

}
