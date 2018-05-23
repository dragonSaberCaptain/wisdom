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
 * @date 2018-05-23 14:54 Wed
 */
@Entity
@Table(name = "sys_role_permission")
public class SysRolePermissionJpa extends BaseModel {
    @Column(columnDefinition = "bigint(20)")
    private Long roleId;
    @Column(columnDefinition = "bigint(20) comment '权限表id'")
    private Long permissionId;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("roleId", roleId)
                .append("permissionId", permissionId)
                .toString();
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
