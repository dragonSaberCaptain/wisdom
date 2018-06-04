package com.jskj.wisdom.vo.repair;

import com.alibaba.fastjson.JSON;
import com.jskj.wisdom.model.wisdom.SRepair;
import com.jskj.wisdom.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.vo.repair
 * //TODO
 * @date 2018-06-06 10:59 星期三
 */
@ApiModel(value = "报修更新对象", description = "用于报修更新接口")
public class RepairUpdateVo extends BaseVo {

    @ApiModelProperty(value = "主键id", name = "id", required = true)
    private Long id;

    @ApiModelProperty(value = "预约时间", name = "appointmentTime")
    private String appointmentTime;

    @ApiModelProperty(value = "描述", name = "depict")
    private String depict;

    @ApiModelProperty(value = "地点", name = "place")
    private String place;

    @ApiModelProperty(value = "状态", name = "status")
    private String status;

    @ApiModelProperty(value = "报修标题", name = "title")
    private String title;

    @ApiModelProperty(value = "用户id", name = "userId")
    private Long userId;

    public SRepair voToDao(final RepairUpdateVo repairVo) {
        SRepair sRepair = JSON.parseObject(JSON.toJSONString(repairVo), SRepair.class);
        sRepair.setUpdateTime(new Date());
        return sRepair;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
