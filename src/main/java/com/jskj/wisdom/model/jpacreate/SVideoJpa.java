package com.jskj.wisdom.model.jpacreate;

import com.jskj.wisdom.model.jpacreate.system.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model
 * @description
 * @date 2018-05-10 9:36 星期四
 */
@Entity
@Table(name = "s_video")
public class SVideoJpa extends BaseModel {

    @Column(columnDefinition = "bigint(20) COMMENT '对应小区id'")
    private Long pid;

    @Column(columnDefinition = "varchar(255) COMMENT '视频地址'")
    private String videoPathUrl;

    @Column(columnDefinition = "varchar(255) COMMENT '图片地址'")
    private String videoPicUrl;

    @Column(columnDefinition = "varchar(32) COMMENT '视频类型:0 直播 1点播'")
    private String videoType;

    @Column(columnDefinition = "varchar(32) COMMENT '视频名称'")
    private String videoName;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getVideoPathUrl() {
        return videoPathUrl;
    }

    public void setVideoPathUrl(String videoPathUrl) {
        this.videoPathUrl = videoPathUrl;
    }

    public String getVideoPicUrl() {
        return videoPicUrl;
    }

    public void setVideoPicUrl(String videoPicUrl) {
        this.videoPicUrl = videoPicUrl;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
}
