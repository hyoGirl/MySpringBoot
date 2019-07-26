package com.xulei.lock.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/25 23:05
 * @Version 1.0
 */
@Data
public class Price {

    /**
     * 自增主键为integer类型，对应数据库列类型为int，如果不加这个配置的话，默认将跟随全局，
     * 如果你的数据库是int类型且自增的话，那么mybatis-plus会默认插入Long类型的自增id，导致报错，
     * 当然你可以考虑在数据库里把id设置成bigint类型，实体类里用Long来作为主键id，一样可以规避掉这个错误，就不用加额外的配置了
     */
    @TableId(type = IdType.AUTO) //根据数据库类型设置自增
    private Integer id;

    private BigDecimal total;

    private BigDecimal front;

    private BigDecimal end;

}
