package com.jskj.wisdom.vo.repair;

import com.alibaba.fastjson.JSON;
import com.jskj.wisdom.model.wisdom.SRepair;
import com.jskj.wisdom.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.vo
 * //TODO
 * @date 2018-06-05 17:03 星期二
 */
@ApiModel(value = "报修新增对象", description = "用于报修新增接口")
public class RepairAddVo extends BaseVo {

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

    public SRepair voToDao(final RepairAddVo repairAddVo) {
        SRepair sRepair = JSON.parseObject(JSON.toJSONString(repairAddVo), SRepair.class);
        sRepair.setCreateTime(new Date());
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof RepairAddVo)) {
            return false;
        }

        RepairAddVo that = (RepairAddVo) o;

        return new EqualsBuilder()
                .append(getAppointmentTime(), that.getAppointmentTime())
                .append(getDepict(), that.getDepict())
                .append(getPlace(), that.getPlace())
                .append(getStatus(), that.getStatus())
                .append(getTitle(), that.getTitle())
                .append(getUserId(), that.getUserId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getAppointmentTime())
                .append(getDepict())
                .append(getPlace())
                .append(getStatus())
                .append(getTitle())
                .append(getUserId())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("appointmentTime", appointmentTime)
                .append("depict", depict)
                .append("place", place)
                .append("status", status)
                .append("title", title)
                .append("userId", userId)
                .toString();
    }
}
