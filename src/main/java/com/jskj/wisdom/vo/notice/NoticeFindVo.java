package com.jskj.wisdom.vo.notice;

import com.alibaba.fastjson.JSON;
import com.jskj.wisdom.model.wisdom.SNotice;
import com.jskj.wisdom.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.vo.journalism
 * //TODO
 * @date 2018-06-13 15:58 星期三
 */
@ApiModel(value = "公告查询对象", description = "用于报修查询接口")
public class NoticeFindVo extends BaseVo {

    @ApiModelProperty(value = "公告详情描述", name = "depict")
    private String depict;

    @ApiModelProperty(value = "公告状态", name = "status")
    private String status;

    @ApiModelProperty(value = "公告标题", name = "title")
    private String title;

    @ApiModelProperty(value = "公告url", name = "noticeUrl")
    private String noticeUrl;

    public static SNotice voToDao(final NoticeFindVo recordVo) {
        return JSON.parseObject(JSON.toJSONString(recordVo), SNotice.class);
    }

    public static List<SNotice> voToDao(final List<NoticeFindVo> recordVos) {
        List<SNotice> records = new LinkedList<>();
        for (NoticeFindVo recordVo : recordVos) {
            records.add(JSON.parseObject(JSON.toJSONString(recordVo), SNotice.class));
        }
        return records;
    }

    public static NoticeFindVo daoToVo(final SNotice record) {
        return JSON.parseObject(JSON.toJSONString(record), NoticeFindVo.class);
    }

    public static List<NoticeFindVo> daoToVo(final List<SNotice> records) {
        List<NoticeFindVo> recordVos = new LinkedList<>();
        for (SNotice record : records) {
            recordVos.add(JSON.parseObject(JSON.toJSONString(record), NoticeFindVo.class));
        }
        return recordVos;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoticeUrl() {
        return noticeUrl;
    }

    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl;
    }
}
