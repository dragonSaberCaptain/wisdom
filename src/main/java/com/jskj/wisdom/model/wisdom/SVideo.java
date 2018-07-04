/* https://github.com/orange1438 */
package com.jskj.wisdom.model.wisdom;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LastChaosCaptain
 */
public class SVideo implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -8422597664512278818L;

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

    // 对应小区id
    private Long pid;

    // 视频地址
    private String videoPathUrl;

    // 视频类型:0 直播 1点播
    private String videoType;

    // 视频名称
    private String videoName;

    /**
     * 获取 主键id s_video.id
     * @return 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键id s_video.id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建者 s_video.create_id
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置 创建者 s_video.create_id
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取 创建时间 s_video.create_time
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 s_video.create_time
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 是否删除：0否 1是  默认：0 s_video.is_delete
     * @return 是否删除：0否 1是  默认：0
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 是否删除：0否 1是  默认：0 s_video.is_delete
     * @param isDelete 是否删除：0否 1是  默认：0
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 获取 备注 s_video.remark
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 s_video.remark
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 更新者 s_video.update_id
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置 更新者 s_video.update_id
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取 更新时间 s_video.update_time
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 s_video.update_time
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 对应小区id s_video.pid
     *
     * @return 对应小区id
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置 对应小区id s_video.pid
     *
     * @param pid 对应小区id
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取 视频地址 s_video.video_path_url
     *
     * @return 视频地址
     */
    public String getVideoPathUrl() {
        return videoPathUrl;
    }

    /**
     * 设置 视频地址 s_video.video_path_url
     *
     * @param videoPathUrl 视频地址
     */
    public void setVideoPathUrl(String videoPathUrl) {
        this.videoPathUrl = videoPathUrl == null ? null : videoPathUrl.trim();
    }

    /**
     * 获取 视频类型:0 直播 1点播 s_video.video_type
     * @return 视频类型:0 直播 1点播
     */
    public String getVideoType() {
        return videoType;
    }

    /**
     * 设置 视频类型:0 直播 1点播 s_video.video_type
     * @param videoType 视频类型:0 直播 1点播
     */
    public void setVideoType(String videoType) {
        this.videoType = videoType == null ? null : videoType.trim();
    }

    /**
     * 获取 视频名称 s_video.video_name
     * @return 视频名称
     */
    public String getVideoName() {
        return videoName;
    }

    /**
     * 设置 视频名称 s_video.video_name
     * @param videoName 视频名称
     */
    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
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
        sb.append(", pid=").append(pid);
        sb.append(", videoPathUrl=").append(videoPathUrl);
        sb.append(", videoType=").append(videoType);
        sb.append(", videoName=").append(videoName);
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
        SVideo other = (SVideo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
                && (this.getVideoPathUrl() == null ? other.getVideoPathUrl() == null : this.getVideoPathUrl().equals(other.getVideoPathUrl()))
                && (this.getVideoType() == null ? other.getVideoType() == null : this.getVideoType().equals(other.getVideoType()))
                && (this.getVideoName() == null ? other.getVideoName() == null : this.getVideoName().equals(other.getVideoName()));
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
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getVideoPathUrl() == null) ? 0 : getVideoPathUrl().hashCode());
        result = prime * result + ((getVideoType() == null) ? 0 : getVideoType().hashCode());
        result = prime * result + ((getVideoName() == null) ? 0 : getVideoName().hashCode());
        return result;
    }
}