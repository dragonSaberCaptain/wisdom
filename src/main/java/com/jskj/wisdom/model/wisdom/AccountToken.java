/* https://github.com/orange1438 */
package com.jskj.wisdom.model.wisdom;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LastChaosCaptain
 */
public class AccountToken implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 4355102407137766372L;

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

    // 第三方名称
    private String thirdName;

    // 第三方账户id
    private String thirdPartyId;

    // 第三方账户名称
    private String thirdPartyName;

    // 第三方账户密码
    private String thirdPartyPassword;

    // 第三方账户图片链接
    private String thirdPartyPicUrl;

    // 第三方账户Token
    private String thirdPartyToken;

    // 第三方账户类型
    private String thirdPartyType;

    // 第三方Url
    private String thirdPartyUrl;

    // 用户id
    private Long userId;

    /**
     * 获取 主键id account_token.id
     *
     * @return 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键id account_token.id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建者 account_token.create_id
     *
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置 创建者 account_token.create_id
     *
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取 创建时间 account_token.create_time
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 account_token.create_time
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 是否删除：0否 1是  默认：0 account_token.is_delete
     *
     * @return 是否删除：0否 1是  默认：0
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 是否删除：0否 1是  默认：0 account_token.is_delete
     *
     * @param isDelete 是否删除：0否 1是  默认：0
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 获取 备注 account_token.remark
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 account_token.remark
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 更新者 account_token.update_id
     *
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置 更新者 account_token.update_id
     *
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取 更新时间 account_token.update_time
     *
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 account_token.update_time
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 第三方名称 account_token.third_name
     *
     * @return 第三方名称
     */
    public String getThirdName() {
        return thirdName;
    }

    /**
     * 设置 第三方名称 account_token.third_name
     *
     * @param thirdName 第三方名称
     */
    public void setThirdName(String thirdName) {
        this.thirdName = thirdName == null ? null : thirdName.trim();
    }

    /**
     * 获取 第三方账户id account_token.third_party_id
     *
     * @return 第三方账户id
     */
    public String getThirdPartyId() {
        return thirdPartyId;
    }

    /**
     * 设置 第三方账户id account_token.third_party_id
     *
     * @param thirdPartyId 第三方账户id
     */
    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId == null ? null : thirdPartyId.trim();
    }

    /**
     * 获取 第三方账户名称 account_token.third_party_name
     *
     * @return 第三方账户名称
     */
    public String getThirdPartyName() {
        return thirdPartyName;
    }

    /**
     * 设置 第三方账户名称 account_token.third_party_name
     *
     * @param thirdPartyName 第三方账户名称
     */
    public void setThirdPartyName(String thirdPartyName) {
        this.thirdPartyName = thirdPartyName == null ? null : thirdPartyName.trim();
    }

    /**
     * 获取 第三方账户密码 account_token.third_party_password
     *
     * @return 第三方账户密码
     */
    public String getThirdPartyPassword() {
        return thirdPartyPassword;
    }

    /**
     * 设置 第三方账户密码 account_token.third_party_password
     *
     * @param thirdPartyPassword 第三方账户密码
     */
    public void setThirdPartyPassword(String thirdPartyPassword) {
        this.thirdPartyPassword = thirdPartyPassword == null ? null : thirdPartyPassword.trim();
    }

    /**
     * 获取 第三方账户图片链接 account_token.third_party_pic_url
     *
     * @return 第三方账户图片链接
     */
    public String getThirdPartyPicUrl() {
        return thirdPartyPicUrl;
    }

    /**
     * 设置 第三方账户图片链接 account_token.third_party_pic_url
     *
     * @param thirdPartyPicUrl 第三方账户图片链接
     */
    public void setThirdPartyPicUrl(String thirdPartyPicUrl) {
        this.thirdPartyPicUrl = thirdPartyPicUrl == null ? null : thirdPartyPicUrl.trim();
    }

    /**
     * 获取 第三方账户Token account_token.third_party_token
     *
     * @return 第三方账户Token
     */
    public String getThirdPartyToken() {
        return thirdPartyToken;
    }

    /**
     * 设置 第三方账户Token account_token.third_party_token
     *
     * @param thirdPartyToken 第三方账户Token
     */
    public void setThirdPartyToken(String thirdPartyToken) {
        this.thirdPartyToken = thirdPartyToken == null ? null : thirdPartyToken.trim();
    }

    /**
     * 获取 第三方账户类型 account_token.third_party_type
     *
     * @return 第三方账户类型
     */
    public String getThirdPartyType() {
        return thirdPartyType;
    }

    /**
     * 设置 第三方账户类型 account_token.third_party_type
     *
     * @param thirdPartyType 第三方账户类型
     */
    public void setThirdPartyType(String thirdPartyType) {
        this.thirdPartyType = thirdPartyType == null ? null : thirdPartyType.trim();
    }

    /**
     * 获取 第三方Url account_token.third_party_url
     *
     * @return 第三方Url
     */
    public String getThirdPartyUrl() {
        return thirdPartyUrl;
    }

    /**
     * 设置 第三方Url account_token.third_party_url
     *
     * @param thirdPartyUrl 第三方Url
     */
    public void setThirdPartyUrl(String thirdPartyUrl) {
        this.thirdPartyUrl = thirdPartyUrl == null ? null : thirdPartyUrl.trim();
    }

    /**
     * 获取 用户id account_token.user_id
     *
     * @return 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 用户id account_token.user_id
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
        sb.append(", thirdName=").append(thirdName);
        sb.append(", thirdPartyId=").append(thirdPartyId);
        sb.append(", thirdPartyName=").append(thirdPartyName);
        sb.append(", thirdPartyPassword=").append(thirdPartyPassword);
        sb.append(", thirdPartyPicUrl=").append(thirdPartyPicUrl);
        sb.append(", thirdPartyToken=").append(thirdPartyToken);
        sb.append(", thirdPartyType=").append(thirdPartyType);
        sb.append(", thirdPartyUrl=").append(thirdPartyUrl);
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
        AccountToken other = (AccountToken) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getThirdName() == null ? other.getThirdName() == null : this.getThirdName().equals(other.getThirdName()))
                && (this.getThirdPartyId() == null ? other.getThirdPartyId() == null : this.getThirdPartyId().equals(other.getThirdPartyId()))
                && (this.getThirdPartyName() == null ? other.getThirdPartyName() == null : this.getThirdPartyName().equals(other.getThirdPartyName()))
                && (this.getThirdPartyPassword() == null ? other.getThirdPartyPassword() == null : this.getThirdPartyPassword().equals(other.getThirdPartyPassword()))
                && (this.getThirdPartyPicUrl() == null ? other.getThirdPartyPicUrl() == null : this.getThirdPartyPicUrl().equals(other.getThirdPartyPicUrl()))
                && (this.getThirdPartyToken() == null ? other.getThirdPartyToken() == null : this.getThirdPartyToken().equals(other.getThirdPartyToken()))
                && (this.getThirdPartyType() == null ? other.getThirdPartyType() == null : this.getThirdPartyType().equals(other.getThirdPartyType()))
                && (this.getThirdPartyUrl() == null ? other.getThirdPartyUrl() == null : this.getThirdPartyUrl().equals(other.getThirdPartyUrl()))
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
        result = prime * result + ((getThirdName() == null) ? 0 : getThirdName().hashCode());
        result = prime * result + ((getThirdPartyId() == null) ? 0 : getThirdPartyId().hashCode());
        result = prime * result + ((getThirdPartyName() == null) ? 0 : getThirdPartyName().hashCode());
        result = prime * result + ((getThirdPartyPassword() == null) ? 0 : getThirdPartyPassword().hashCode());
        result = prime * result + ((getThirdPartyPicUrl() == null) ? 0 : getThirdPartyPicUrl().hashCode());
        result = prime * result + ((getThirdPartyToken() == null) ? 0 : getThirdPartyToken().hashCode());
        result = prime * result + ((getThirdPartyType() == null) ? 0 : getThirdPartyType().hashCode());
        result = prime * result + ((getThirdPartyUrl() == null) ? 0 : getThirdPartyUrl().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }
}