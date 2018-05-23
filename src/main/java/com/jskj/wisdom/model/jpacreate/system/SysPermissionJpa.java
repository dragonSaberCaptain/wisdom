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
 * @date 2018-05-23 14:41 Wed
 */
@Entity
@Table(name = "sys_permission")
public class SysPermissionJpa extends BaseModel {
    @Column(columnDefinition = "varchar(64) comment '权限名称'")
    private String name;
    @Column(columnDefinition = "varchar(255) comment '权限url'")
    private String permissionUrl;
    @Column(columnDefinition = "varchar(64) comment '权限方法'")
    private String method;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("permissionUrl", permissionUrl)
                .append("method", method)
                .toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
