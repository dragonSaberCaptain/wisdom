/* https://github.com/orange1438 */
package com.jskj.wisdom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author LastChaosCaptain
 */
@ApiModel(value = "小区对象", description = "用于接受小区相关信息")
public class TPcell implements Serializable {
    private static final long serialVersionUID = -2528295386571753467L;

    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;

    @ApiModelProperty(value = "创建时间", name = "createTime", hidden = true)
    private Date createTime;

    @JsonIgnore
    @ApiModelProperty(value = "创建者", name = "createId", hidden = true)
    private Long createId;

    @ApiModelProperty(value = "更新时间", name = "updateTime", hidden = true)
    private Date updateTime;

    @JsonIgnore
    @ApiModelProperty(value = "更新者", name = "updateId", hidden = true)
    private Long updateId;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @ApiModelProperty(value = "是否删除：0否 1是  默认：0", name = "isDelete")
    private String isDelete;

    @ApiModelProperty(value = "用户id", name = "uid")
    private Long uid;

    @ApiModelProperty(value = "小区名称", name = "pcellName")
    private String pcellName;

    @ApiModelProperty(value = "小区编号", name = "pcellNumber")
    private String pcellNumber;

    @ApiModelProperty(hidden = true)
    private List<TRoom> tRooms;


    public List<TRoom> gettRooms() {
        return tRooms;
    }

    public void settRooms(List<TRoom> tRooms) {
        this.tRooms = tRooms;
    }

    /**
     * 获取 t_pcell.id
     *
     * @return t_pcell.id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 t_pcell.id
     *
     * @param id t_pcell.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 用户id t_pcell.uid
     *
     * @return 用户id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置 用户id t_pcell.uid
     *
     * @param uid 用户id
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取 小区名称 t_pcell.pcell_name
     *
     * @return 小区名称
     */
    public String getPcellName() {
        return pcellName;
    }

    /**
     * 设置 小区名称 t_pcell.pcell_name
     *
     * @param pcellName 小区名称
     */
    public void setPcellName(String pcellName) {
        this.pcellName = pcellName == null ? null : pcellName.trim();
    }

    /**
     * 获取 小区编号 t_pcell.pcell_number
     *
     * @return 小区编号
     */
    public String getPcellNumber() {
        return pcellNumber;
    }

    /**
     * 设置 小区编号 t_pcell.pcell_number
     *
     * @param pcellNumber 小区编号
     */
    public void setPcellNumber(String pcellNumber) {
        this.pcellNumber = pcellNumber == null ? null : pcellNumber.trim();
    }

    /**
     * 获取 创建时间 t_pcell.create_time
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 t_pcell.create_time
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建者 t_pcell.create_id
     *
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置 创建者 t_pcell.create_id
     *
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取 更新时间 t_pcell.update_time
     *
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 t_pcell.update_time
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 更新者 t_pcell.update_id
     *
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置 更新者 t_pcell.update_id
     *
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取 备注 t_pcell.remark
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 t_pcell.remark
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 是否删除:0否 1是 t_pcell.Is_delete
     *
     * @return 是否删除:0否 1是
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 是否删除:0否 1是 t_pcell.Is_delete
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
        sb.append(", uid=").append(uid);
        sb.append(", pcellName=").append(pcellName);
        sb.append(", pcellNumber=").append(pcellNumber);
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
        TPcell other = (TPcell) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getPcellName() == null ? other.getPcellName() == null : this.getPcellName().equals(other.getPcellName()))
                && (this.getPcellNumber() == null ? other.getPcellNumber() == null : this.getPcellNumber().equals(other.getPcellNumber()))
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
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getPcellName() == null) ? 0 : getPcellName().hashCode());
        result = prime * result + ((getPcellNumber() == null) ? 0 : getPcellNumber().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}