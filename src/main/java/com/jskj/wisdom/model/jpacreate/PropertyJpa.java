package com.jskj.wisdom.model.jpacreate;

import com.jskj.wisdom.model.jpacreate.system.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.jpaCerateModel
 * @description
 * @date 2018-05-10 15:33 星期四
 */
@Entity
@Table(name = "s_property")
public class PropertyJpa extends BaseModel {

    @Column(columnDefinition = "bigint(20) COMMENT '用户id'")
    private Long userId;

    @Column(columnDefinition = "varchar(255) COMMENT '描述'")
    private String depict;

    @Column(columnDefinition = "varchar(255) COMMENT '图片地址'")
    private String picPath;

    @Column(columnDefinition = "varchar(255) COMMENT '状态'")
    private String status;

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
