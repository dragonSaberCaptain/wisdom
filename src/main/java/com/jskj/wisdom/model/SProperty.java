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
@ApiModel(value = "公告对象", description = "公告相关的字段")
public class SProperty implements Serializable {
    private static final long serialVersionUID = -5908144861682051693L;

    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;

    @JsonIgnore
    @ApiModelProperty(value = "创建者", name = "createId", hidden = true)
    private Long createId;

    @ApiModelProperty(value = "创建时间", name = "createTime", hidden = true)
    private Date createTime;

    @ApiModelProperty(value = "是否删除：0否 1是  默认：0  默认：0", name = "isDelete")
    private String isDelete;

    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;

    @JsonIgnore
    @ApiModelProperty(value = "更新者", name = "updateId", hidden = true)
    private Long updateId;

    @ApiModelProperty(value = "更新时间", name = "updateTime", hidden = true)
    private Date updateTime;

    @ApiModelProperty(value = "描述", name = "depict")
    private String depict;

    @ApiModelProperty(value = "图片地址", name = "picPath")
    private String picPath;

    @ApiModelProperty(value = "状态", name = "status")
    private String status;

    @ApiModelProperty(value = "用户id", name = "userId")
    private Long userId;

    /**
     * 获取 主键id s_property.id
     * @return 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键id s_property.id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建者 s_property.create_id
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置 创建者 s_property.create_id
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取 创建时间 s_property.create_time
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 s_property.create_time
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 是否删除：0否 1是  默认：0 s_property.is_delete
     * @return 是否删除：0否 1是  默认：0
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 是否删除：0否 1是  默认：0 s_property.is_delete
     * @param isDelete 是否删除：0否 1是  默认：0
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 获取 备注 s_property.remark
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 s_property.remark
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 更新者 s_property.update_id
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置 更新者 s_property.update_id
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取 更新时间 s_property.update_time
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 s_property.update_time
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 描述 s_property.depict
     *
     * @return 描述
     */
    public String getDepict() {
        return depict;
    }

    /**
     * 设置 描述 s_property.depict
     *
     * @param depict 描述
     */
    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
    }

    /**
     * 获取 图片地址 s_property.pic_path
     *
     * @return 图片地址
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * 设置 图片地址 s_property.pic_path
     *
     * @param picPath 图片地址
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    /**
     * 获取 状态 s_property.status
     *
     * @return 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态 s_property.status
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取 用户id s_property.user_id
     *
     * @return 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 用户id s_property.user_id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", remark=").append(remark);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", depict=").append(depict);
        sb.append(", picPath=").append(picPath);
        sb.append(", status=").append(status);
        sb.append(", userId=").append(userId);
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
        SProperty other = (SProperty) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getDepict() == null ? other.getDepict() == null : this.getDepict().equals(other.getDepict()))
                && (this.getPicPath() == null ? other.getPicPath() == null : this.getPicPath().equals(other.getPicPath()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime  = 31;
        int       result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDepict() == null) ? 0 : getDepict().hashCode());
        result = prime * result + ((getPicPath() == null) ? 0 : getPicPath().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }
}