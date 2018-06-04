package com.jskj.wisdom.vo.repair;

import com.alibaba.fastjson.JSON;
import com.jskj.wisdom.model.wisdom.SRepair;
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
@ApiModel(value = "报修查询对象", description = "用于报修查询接口")
public class RepairFindVo extends BaseVo {

    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;

    @ApiModelProperty(value = "创建者", name = "createId")
    private Long createId;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

    @ApiModelProperty(value = "是否删除：0否 1是 默认：0", name = "isDelete")
    private String isDelete;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "更新者", name = "updateId")
    private Long updateId;

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

    public static SRepair voToDao(final RepairFindVo recordVo) {
        return JSON.parseObject(JSON.toJSONString(recordVo), SRepair.class);
    }

    public static List<SRepair> voToDao(final List<RepairFindVo> recordVos) {
        List<SRepair> records = new LinkedList<>();
        for (RepairFindVo recordVo : recordVos) {
            records.add(JSON.parseObject(JSON.toJSONString(recordVo), SRepair.class));
        }
        return records;
    }

    public static RepairFindVo daoToVo(final SRepair record) {
        return JSON.parseObject(JSON.toJSONString(record), RepairFindVo.class);
    }

    public static List<RepairFindVo> daoToVo(final List<SRepair> records) {
        List<RepairFindVo> recordVos = new LinkedList<>();
        for (SRepair record : records) {
            recordVos.add(JSON.parseObject(JSON.toJSONString(record), RepairFindVo.class));
        }
        return recordVos;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getCreateId() {
        return createId;
    }

    @Override
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    @Override
    public String getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getIsDelete() {
        return isDelete;
    }

    @Override
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public Long getUpdateId() {
        return updateId;
    }

    @Override
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
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
