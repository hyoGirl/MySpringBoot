package com.mybatis.plus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author zlt
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
public class SysMenu extends Model<Plus> implements Serializable {
	private static final long serialVersionUID = 749360940290141180L;
	@TableId
	private Long id;
	private Long parentId;
	private String name;
	private String css;
	private String url;
	private String path;
	private Integer sort;
	private Integer type;
	private Boolean hidden;
	/**
	 * 请求的类型
	 */
	private String pathMethod;

	@TableField(exist = false)
	private List<SysMenu> subMenus;
	@TableField(exist = false)
	private Long roleId;
	@TableField(exist = false)
	private Set<Long> menuIds;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
