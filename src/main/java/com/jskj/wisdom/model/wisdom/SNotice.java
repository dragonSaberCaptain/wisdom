/* https://github.com/orange1438 */
package com.jskj.wisdom.model.wisdom;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LastChaosCaptain
 */
public class SNotice implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -2759725630301655468L;

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

    // 公告详情描述
    private String depict;

    // 公告状态
    private String status;

    // 公告标题
    private String title;

    // 公告url
    private String noticeUrl;

    /**
     * 获取 主键id s_notice.id
     * @return 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键id s_notice.id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建者 s_notice.create_id
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置 创建者 s_notice.create_id
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取 创建时间 s_notice.create_time
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 s_notice.create_time
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 是否删除：0否 1是  默认：0 s_notice.is_delete
     * @return 是否删除：0否 1是  默认：0
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 是否删除：0否 1是  默认：0 s_notice.is_delete
     * @param isDelete 是否删除：0否 1是  默认：0
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 获取 备注 s_notice.remark
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 s_notice.remark
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 更新者 s_notice.update_id
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置 更新者 s_notice.update_id
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取 更新时间 s_notice.update_time
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 s_notice.update_time
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 公告详情描述 s_notice.depict
     * @return 公告详情描述
     */
    public String getDepict() {
        return depict;
    }

    /**
     * 设置 公告详情描述 s_notice.depict
     * @param depict 公告详情描述
     */
    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
    }

    /**
     * 获取 公告状态 s_notice.status
     * @return 公告状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 公告状态 s_notice.status
     * @param status 公告状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取 公告标题 s_notice.title
     *
     * @return 公告标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 公告标题 s_notice.title
     *
     * @param title 公告标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 公告url s_notice.notice_url
     *
     * @return 公告url
     */
    public String getNoticeUrl() {
        return noticeUrl;
    }

    /**
     * 设置 公告url s_notice.notice_url
     *
     * @param noticeUrl 公告url
     */
    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl == null ? null : noticeUrl.trim();
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
        sb.append(", status=").append(status);
        sb.append(", title=").append(title);
        sb.append(", noticeUrl=").append(noticeUrl);
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
        SNotice other = (SNotice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getDepict() == null ? other.getDepict() == null : this.getDepict().equals(other.getDepict()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getNoticeUrl() == null ? other.getNoticeUrl() == null : this.getNoticeUrl().equals(other.getNoticeUrl()));
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
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getNoticeUrl() == null) ? 0 : getNoticeUrl().hashCode());
        return result;
    }
}