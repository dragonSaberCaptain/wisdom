package com.jskj.wisdom.model.jpacreate.system;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.jpacreate.system
 * @description
 * @date 2018-05-23 14:36 Wed
 */
@Entity
@Table(name = "sys_user_role")
public class SysUserRoleJpa extends BaseModel {
    @Column(columnDefinition = "bigint(20) comment '用户表id'")
    private Long userId;
    @Column(columnDefinition = "bigint(20) comment '角色表id'")
    private Long roleId;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("roleId", roleId)
                .toString();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
