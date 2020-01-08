package com.xulei.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SysPermission implements Serializable {
    @Id@GeneratedValue
    private Integer id;//主键.
    private String name;//名称.
    @Column(columnDefinition="enums('menu','button')")
    private String resourceType;//资源类型，[menu|button]
    private String url;//资源路径.
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    private Long parentId; //父编号
    private String parentIds; //父编号列表
    private Boolean available = Boolean.FALSE;
    
    @ManyToMany  //这个多对多，不是这个SysPermission和中间表，是SysPermission和role表是多对多
    //JoinTable里面的name是中间表的名称
    //@JoinColumn  指的是中间表和这个表之间的外键关系。
    //这个实体类SysPermission的id所对应的外键是这个中间表SysRolePermission中的permissionId
    //inverseJoinColumns  中的@JoinColumn 是指第二张表和中间表的外键关系，就是说中间表的roleId是role表id对应的外键
    @JoinTable(name="SysRolePermission", 
    			//定义表中名为permissionId的外键，该外键列参照当前实体对应表的主键列
    
    			//
    			joinColumns={@JoinColumn(name="permissionId")},
    			//	定义连接表中名为roleId的外键列
    			inverseJoinColumns={@JoinColumn(name="roleId")})
    
    private List<SysRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}