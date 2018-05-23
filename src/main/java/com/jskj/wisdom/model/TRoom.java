/* https://github.com/orange1438 */
package com.jskj.wisdom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LastChaosCaptain
 */
@ApiModel(value = "房间对象", description = "用于接受房间相关信息")
public class TRoom implements Serializable {
    private static final long serialVersionUID = 3794353190144951919L;

    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;

    @JsonIgnore
    @ApiModelProperty(value = "创建者", name = "createId", hidden = true)
    private Long createId;

    @ApiModelProperty(value = "更新时间", name = "updateTime")
    private Date updateTime;

    @JsonIgnore
    @ApiModelProperty(value = "更新者", name = "updateId", hidden = true)
    private Long updateId;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "是否删除：0否 1是  默认：0", name = "isDelete")
    private String isDelete;

    @ApiModelProperty(value = "小区id", name = "pcellId")
    private Long pcellId;

    @ApiModelProperty(value = "房间名称", name = "roomName")
    private String roomName;

    @ApiModelProperty(value = "房间编号", name = "roomNumber")
    private String roomNumber;

    @ApiModelProperty(value = "租赁类别", name = "roomLeaseCategory")
    private String roomLeaseCategory;

    @ApiModelProperty(value = "楼号", name = "roomTower")
    private String roomTower;

    @ApiModelProperty(value = "门禁卡号", name = "roomRke")
    private String roomRke;

    @ApiModelProperty(value = "单元号", name = "roomUnit")
    private String roomUnit;

    /**
     * 获取 t_room.id
     *
     * @return t_room.id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 t_room.id
     *
     * @param id t_room.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 小区id t_room.pcell_id
     *
     * @return 小区id
     */
    public Long getPcellId() {
        return pcellId;
    }

    /**
     * 设置 小区id t_room.pcell_id
     *
     * @param pcellId 小区id
     */
    public void setPcellId(Long pcellId) {
        this.pcellId = pcellId;
    }

    /**
     * 获取 房间名称 t_room.room_name
     *
     * @return 房间名称
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * 设置 房间名称 t_room.room_name
     *
     * @param roomName 房间名称
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    /**
     * 获取 房间编号 t_room.room_number
     *
     * @return 房间编号
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * 设置 房间编号 t_room.room_number
     *
     * @param roomNumber 房间编号
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    /**
     * 获取 租赁类别 t_room.room_lease_category
     *
     * @return 租赁类别
     */
    public String getRoomLeaseCategory() {
        return roomLeaseCategory;
    }

    /**
     * 设置 租赁类别 t_room.room_lease_category
     *
     * @param roomLeaseCategory 租赁类别
     */
    public void setRoomLeaseCategory(String roomLeaseCategory) {
        this.roomLeaseCategory = roomLeaseCategory == null ? null : roomLeaseCategory.trim();
    }

    /**
     * 获取 楼号 t_room.room_tower
     *
     * @return 楼号
     */
    public String getRoomTower() {
        return roomTower;
    }

    /**
     * 设置 楼号 t_room.room_tower
     *
     * @param roomTower 楼号
     */
    public void setRoomTower(String roomTower) {
        this.roomTower = roomTower == null ? null : roomTower.trim();
    }

    /**
     * 获取 门禁卡号 t_room.room_rke
     *
     * @return 门禁卡号
     */
    public String getRoomRke() {
        return roomRke;
    }

    /**
     * 设置 门禁卡号 t_room.room_rke
     *
     * @param roomRke 门禁卡号
     */
    public void setRoomRke(String roomRke) {
        this.roomRke = roomRke == null ? null : roomRke.trim();
    }

    /**
     * 获取 单元号 t_room.room_unit
     *
     * @return 单元号
     */
    public String getRoomUnit() {
        return roomUnit;
    }

    /**
     * 设置 单元号 t_room.room_unit
     *
     * @param roomUnit 单元号
     */
    public void setRoomUnit(String roomUnit) {
        this.roomUnit = roomUnit == null ? null : roomUnit.trim();
    }

    /**
     * 获取 创建时间 t_room.create_time
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 t_room.create_time
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建者 t_room.create_id
     *
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置 创建者 t_room.create_id
     *
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取 更新时间 t_room.update_time
     *
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 t_room.update_time
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 更新者 t_room.update_id
     *
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置 更新者 t_room.update_id
     *
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取 备注 t_room.remark
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 t_room.remark
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 是否删除:0否 1是 t_room.Is_delete
     *
     * @return 是否删除:0否 1是
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 是否删除:0否 1是 t_room.Is_delete
     *
     * @param isDelete 是否删除:0否 1是
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pcellId=").append(pcellId);
        sb.append(", roomName=").append(roomName);
        sb.append(", roomNumber=").append(roomNumber);
        sb.append(", roomLeaseCategory=").append(roomLeaseCategory);
        sb.append(", roomTower=").append(roomTower);
        sb.append(", roomRke=").append(roomRke);
        sb.append(", roomUnit=").append(roomUnit);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", remark=").append(remark);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TRoom other = (TRoom) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPcellId() == null ? other.getPcellId() == null : this.getPcellId().equals(other.getPcellId()))
                && (this.getRoomName() == null ? other.getRoomName() == null : this.getRoomName().equals(other.getRoomName()))
                && (this.getRoomNumber() == null ? other.getRoomNumber() == null : this.getRoomNumber().equals(other.getRoomNumber()))
                && (this.getRoomLeaseCategory() == null ? other.getRoomLeaseCategory() == null : this.getRoomLeaseCategory().equals(other.getRoomLeaseCategory()))
                && (this.getRoomTower() == null ? other.getRoomTower() == null : this.getRoomTower().equals(other.getRoomTower()))
                && (this.getRoomRke() == null ? other.getRoomRke() == null : this.getRoomRke().equals(other.getRoomRke()))
                && (this.getRoomUnit() == null ? other.getRoomUnit() == null : this.getRoomUnit().equals(other.getRoomUnit()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime  = 31;
        int       result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPcellId() == null) ? 0 : getPcellId().hashCode());
        result = prime * result + ((getRoomName() == null) ? 0 : getRoomName().hashCode());
        result = prime * result + ((getRoomNumber() == null) ? 0 : getRoomNumber().hashCode());
        result = prime * result + ((getRoomLeaseCategory() == null) ? 0 : getRoomLeaseCategory().hashCode());
        result = prime * result + ((getRoomTower() == null) ? 0 : getRoomTower().hashCode());
        result = prime * result + ((getRoomRke() == null) ? 0 : getRoomRke().hashCode());
        result = prime * result + ((getRoomUnit() == null) ? 0 : getRoomUnit().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}