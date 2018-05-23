package com.jskj.wisdom.model.jpacreate.system;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.jpacreate.shiro
 * @description
 * @date 2018-05-23 14:02 Wed
 */
@Entity
@Table(name = "sys_role")
public class SysRoleJpa extends BaseModel {

    @Column(columnDefinition = "varchar(64) COMMENT '角色名称'")
    private String name;
    @Column(columnDefinition = "varchar(64) COMMENT '角色级别'")
    private String roleLevet;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("roleLevet", roleLevet)
                .toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleLevet() {
        return roleLevet;
    }

    public void setRoleLevet(String roleLevet) {
        this.roleLevet = roleLevet;
    }
}
