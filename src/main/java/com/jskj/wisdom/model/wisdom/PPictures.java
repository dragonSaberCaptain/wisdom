/* https://github.com/orange1438 */
package com.jskj.wisdom.model.wisdom;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LastChaosCaptain
 */
public class PPictures implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -7349099886719259893L;

    // 主键id
    private Long id;

    // 创建者
    private Long createId;

    // 创建时间
    private Date createTime;

    // 是否删除：0否 1是  默认：0  默认：0
    private String isDelete;

    // 备注
    private String remark;

    // 更新者
    private Long updateId;

    // 更新时间
    private Date updateTime;

    // 图片地址
    private String picPath;

    // 图片类型
    private String picType;

    // 图片类型对应id
    private Long picTypeId;

    // 用户id
    private Long userId;

    // 图片ip地址
    private String picHost;

    // 文件hash值
    private String fileHash;

    // 图片端口
    private String picPort;

    // 接口前缀
    private String interfacePrefix;

    /**
     * 获取 主键id p_pictures.id
     *
     * @return 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键id p_pictures.id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建者 p_pictures.create_id
     *
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置 创建者 p_pictures.create_id
     *
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取 创建时间 p_pictures.create_time
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 p_pictures.create_time
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 是否删除：0否 1是  默认：0 p_pictures.is_delete
     *
     * @return 是否删除：0否 1是  默认：0
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 是否删除：0否 1是  默认：0 p_pictures.is_delete
     *
     * @param isDelete 是否删除：0否 1是  默认：0
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 获取 备注 p_pictures.remark
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 p_pictures.remark
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 更新者 p_pictures.update_id
     *
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置 更新者 p_pictures.update_id
     *
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取 更新时间 p_pictures.update_time
     *
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 p_pictures.update_time
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 图片地址 p_pictures.pic_path
     *
     * @return 图片地址
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * 设置 图片地址 p_pictures.pic_path
     *
     * @param picPath 图片地址
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    /**
     * 获取 图片类型 p_pictures.pic_type
     *
     * @return 图片类型
     */
    public String getPicType() {
        return picType;
    }

    /**
     * 设置 图片类型 p_pictures.pic_type
     *
     * @param picType 图片类型
     */
    public void setPicType(String picType) {
        this.picType = picType == null ? null : picType.trim();
    }

    /**
     * 获取 图片类型对应id p_pictures.pic_type_id
     *
     * @return 图片类型对应id
     */
    public Long getPicTypeId() {
        return picTypeId;
    }

    /**
     * 设置 图片类型对应id p_pictures.pic_type_id
     *
     * @param picTypeId 图片类型对应id
     */
    public void setPicTypeId(Long picTypeId) {
        this.picTypeId = picTypeId;
    }

    /**
     * 获取 用户id p_pictures.user_id
     *
     * @return 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 用户id p_pictures.user_id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 图片ip地址 p_pictures.pic_host
     *
     * @return 图片ip地址
     */
    public String getPicHost() {
        return picHost;
    }

    /**
     * 设置 图片ip地址 p_pictures.pic_host
     *
     * @param picHost 图片ip地址
     */
    public void setPicHost(String picHost) {
        this.picHost = picHost == null ? null : picHost.trim();
    }

    /**
     * 获取 文件hash值 p_pictures.file_hash
     *
     * @return 文件hash值
     */
    public String getFileHash() {
        return fileHash;
    }

    /**
     * 设置 文件hash值 p_pictures.file_hash
     *
     * @param fileHash 文件hash值
     */
    public void setFileHash(String fileHash) {
        this.fileHash = fileHash == null ? null : fileHash.trim();
    }

    /**
     * 获取 图片端口 p_pictures.pic_port
     *
     * @return 图片端口
     */
    public String getPicPort() {
        return picPort;
    }

    /**
     * 设置 图片端口 p_pictures.pic_port
     *
     * @param picPort 图片端口
     */
    public void setPicPort(String picPort) {
        this.picPort = picPort == null ? null : picPort.trim();
    }

    /**
     * 获取 接口前缀 p_pictures.Interface_prefix
     *
     * @return 接口前缀
     */
    public String getInterfacePrefix() {
        return interfacePrefix;
    }

    /**
     * 设置 接口前缀 p_pictures.Interface_prefix
     *
     * @param interfacePrefix 接口前缀
     */
    public void setInterfacePrefix(String interfacePrefix) {
        this.interfacePrefix = interfacePrefix == null ? null : interfacePrefix.trim();
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
        sb.append(", picPath=").append(picPath);
        sb.append(", picType=").append(picType);
        sb.append(", picTypeId=").append(picTypeId);
        sb.append(", userId=").append(userId);
        sb.append(", picHost=").append(picHost);
        sb.append(", fileHash=").append(fileHash);
        sb.append(", picPort=").append(picPort);
        sb.append(", interfacePrefix=").append(interfacePrefix);
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
        PPictures other = (PPictures) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getPicPath() == null ? other.getPicPath() == null : this.getPicPath().equals(other.getPicPath()))
                && (this.getPicType() == null ? other.getPicType() == null : this.getPicType().equals(other.getPicType()))
                && (this.getPicTypeId() == null ? other.getPicTypeId() == null : this.getPicTypeId().equals(other.getPicTypeId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getPicHost() == null ? other.getPicHost() == null : this.getPicHost().equals(other.getPicHost()))
                && (this.getFileHash() == null ? other.getFileHash() == null : this.getFileHash().equals(other.getFileHash()))
                && (this.getPicPort() == null ? other.getPicPort() == null : this.getPicPort().equals(other.getPicPort()))
                && (this.getInterfacePrefix() == null ? other.getInterfacePrefix() == null : this.getInterfacePrefix().equals(other.getInterfacePrefix()));
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
        result = prime * result + ((getPicPath() == null) ? 0 : getPicPath().hashCode());
        result = prime * result + ((getPicType() == null) ? 0 : getPicType().hashCode());
        result = prime * result + ((getPicTypeId() == null) ? 0 : getPicTypeId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPicHost() == null) ? 0 : getPicHost().hashCode());
        result = prime * result + ((getFileHash() == null) ? 0 : getFileHash().hashCode());
        result = prime * result + ((getPicPort() == null) ? 0 : getPicPort().hashCode());
        result = prime * result + ((getInterfacePrefix() == null) ? 0 : getInterfacePrefix().hashCode());
        return result;
    }
}