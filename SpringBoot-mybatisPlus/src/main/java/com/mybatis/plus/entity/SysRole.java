package com.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author zlt
 * 角色
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRole extends Model<Plus> implements Serializable {
    private static final long serialVersionUID = 4497149010220586111L;

    @TableId
    private Long id;
    private String code;
    private String name;
    private Long userId;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
