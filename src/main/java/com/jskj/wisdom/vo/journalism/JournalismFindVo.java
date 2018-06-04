package com.jskj.wisdom.vo.journalism;

import com.alibaba.fastjson.JSON;
import com.jskj.wisdom.model.wisdom.SJournalism;
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
@ApiModel(value = "新闻查询对象", description = "用于报修查询接口")
public class JournalismFindVo extends BaseVo {
    @ApiModelProperty(value = "新闻详情描述", name = "depict")
    private String depict;

    @ApiModelProperty(value = "新闻状态", name = "status")
    private String status;

    @ApiModelProperty(value = "新闻标题", name = "title")
    private String title;

    @ApiModelProperty(value = "新闻链接", name = "journalismUrl")
    private String journalismUrl;

    public static SJournalism voToDao(final JournalismFindVo recordVo) {
        return JSON.parseObject(JSON.toJSONString(recordVo), SJournalism.class);
    }

    public static List<SJournalism> voToDao(final List<JournalismFindVo> recordVos) {
        List<SJournalism> records = new LinkedList<>();
        for (JournalismFindVo recordVo : recordVos) {
            records.add(JSON.parseObject(JSON.toJSONString(recordVo), SJournalism.class));
        }
        return records;
    }

    public static JournalismFindVo daoToVo(final SJournalism record) {
        return JSON.parseObject(JSON.toJSONString(record), JournalismFindVo.class);
    }

    public static List<JournalismFindVo> daoToVo(final List<SJournalism> records) {
        List<JournalismFindVo> recordVos = new LinkedList<>();
        for (SJournalism record : records) {
            recordVos.add(JSON.parseObject(JSON.toJSONString(record), JournalismFindVo.class));
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

    public String getJournalismUrl() {
        return journalismUrl;
    }

    public void setJournalismUrl(String journalismUrl) {
        this.journalismUrl = journalismUrl;
    }
}
