package com.jskj.wisdom.model.jpacreate;

import com.jskj.wisdom.model.jpacreate.system.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.jpacreate
 * //TODO
 * @date 2018-05-28 09:03 星期一
 */
@Entity
@Table(name = "s_notice")
public class NoticeJpa extends BaseModel {

    @Column(columnDefinition = "varchar(255) COMMENT '公告图片地址'")
    private String noticePath;

    @Column(columnDefinition = "varchar(255) COMMENT '公告详情描述'")
    private String depict;

    @Column(columnDefinition = "varchar(32) COMMENT '公告状态'")
    private String status;

    public String getNoticePath() {
        return noticePath;
    }

    public void setNoticePath(String noticePath) {
        this.noticePath = noticePath;
    }


    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
