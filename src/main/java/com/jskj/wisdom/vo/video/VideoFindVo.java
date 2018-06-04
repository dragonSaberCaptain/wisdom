package com.jskj.wisdom.vo.video;

import com.alibaba.fastjson.JSON;
import com.jskj.wisdom.model.wisdom.SVideo;
import com.jskj.wisdom.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.vo.repair
 * //查询对象
 * @date 2018-06-06 15:32 星期三
 */
@ApiModel(value = "视频查询对象", description = "用于查询接口")
public class VideoFindVo extends BaseVo {

    @ApiModelProperty(value = "对应小区id", name = "pid")
    private Long pid;

    @ApiModelProperty(value = "视频地址", name = "videoPathUrl")
    private String videoPathUrl;

    //
    @ApiModelProperty(value = "视频类型:0 直播 1点播", name = "videoType")
    private String videoType;

    @ApiModelProperty(value = "视频名称", name = "videoName")
    private String videoName;

    public static SVideo voToDao(final VideoFindVo recordVo) {
        return JSON.parseObject(JSON.toJSONString(recordVo), SVideo.class);
    }

    public static List<SVideo> voToDao(final List<VideoFindVo> recordVos) {
        List<SVideo> records = new LinkedList<>();
        for (VideoFindVo recordVo : recordVos) {
            records.add(JSON.parseObject(JSON.toJSONString(recordVo), SVideo.class));
        }
        return records;
    }

    public static VideoFindVo daoToVo(final SVideo record) {
        return JSON.parseObject(JSON.toJSONString(record), VideoFindVo.class);
    }

    public static List<VideoFindVo> daoToVo(final List<SVideo> records) {
        List<VideoFindVo> recordVos = new LinkedList<>();
        for (SVideo record : records) {
            recordVos.add(JSON.parseObject(JSON.toJSONString(record), VideoFindVo.class));
        }
        return recordVos;
    }

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
