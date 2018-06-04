/* https://github.com/orange1438 */
package com.jskj.wisdom.model.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author LastChaosCaptain
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 2527778473212252048L;

    // 主键id
    private Long id;

    // 创建者
    private Long createId;

    // 创建时间
    private Date createTime;

    // 是否删除：0否 1是  默认：0
    private String isDelete;

    // 备注
    private String remark;

    // 更新者
    private Long updateId;

    // 更新时间
    private Date updateTime;

    // 邮箱
    private String email;

    // 登录标志: 0否 1是 默认：0
    private String loginFlag;

    // 登录账号
    private String loginName;

    // 手机号
    private String mobile;

    // 昵称
    private String nickName;

    // 登录密码
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private String password;

    // 工号
    private String workNumber;

    // 座机
    private String phone;

    // 用户类型
    private String userType;

    @ApiModelProperty(hidden = true)
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    /**
     * 获取 主键id sys_user.id
     *
     * @return 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键id sys_user.id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 创建者 sys_user.create_id
     *
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置 创建者 sys_user.create_id
     *
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取 创建时间 sys_user.create_time
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 sys_user.create_time
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 是否删除：0否 1是  默认：0 sys_user.is_delete
     *
     * @return 是否删除：0否 1是  默认：0
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 是否删除：0否 1是  默认：0 sys_user.is_delete
     *
     * @param isDelete 是否删除：0否 1是  默认：0
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 获取 备注 sys_user.remark
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 sys_user.remark
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 更新者 sys_user.update_id
     *
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置 更新者 sys_user.update_id
     *
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取 更新时间 sys_user.update_time
     *
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 sys_user.update_time
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 邮箱 sys_user.email
     *
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 邮箱 sys_user.email
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取 登录标志 sys_user.login_flag
     *
     * @return 登录标志
     */
    public String getLoginFlag() {
        return loginFlag;
    }

    /**
     * 设置 登录标志 sys_user.login_flag
     *
     * @param loginFlag 登录标志
     */
    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag == null ? null : loginFlag.trim();
    }

    /**
     * 获取 登录账号 sys_user.login_name
     *
     * @return 登录账号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置 登录账号 sys_user.login_name
     *
     * @param loginName 登录账号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取 手机号 sys_user.mobile
     *
     * @return 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置 手机号 sys_user.mobile
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取 昵称 sys_user.nick_name
     *
     * @return 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置 昵称 sys_user.nick_name
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取 登录密码 sys_user.password
     *
     * @return 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 登录密码 sys_user.password
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取 工号 sys_user.work_number
     *
     * @return 工号
     */
    public String getWorkNumber() {
        return workNumber;
    }

    /**
     * 设置 工号 sys_user.work_number
     *
     * @param workNumber 工号
     */
    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber == null ? null : workNumber.trim();
    }

    /**
     * 获取 座机 sys_user.phone
     *
     * @return 座机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 座机 sys_user.phone
     *
     * @param phone 座机
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取 用户类型 sys_user.user_type
     *
     * @return 用户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置 用户类型 sys_user.user_type
     *
     * @param userType 用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
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
        sb.append(", email=").append(email);
        sb.append(", loginFlag=").append(loginFlag);
        sb.append(", loginName=").append(loginName);
        sb.append(", mobile=").append(mobile);
        sb.append(", nickName=").append(nickName);
        sb.append(", password=").append(password);
        sb.append(", workNumber=").append(workNumber);
        sb.append(", phone=").append(phone);
        sb.append(", userType=").append(userType);
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
        SysUser other = (SysUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getLoginFlag() == null ? other.getLoginFlag() == null : this.getLoginFlag().equals(other.getLoginFlag()))
                && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
                && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
                && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getWorkNumber() == null ? other.getWorkNumber() == null : this.getWorkNumber().equals(other.getWorkNumber()))
                && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
                && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()));
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
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getLoginFlag() == null) ? 0 : getLoginFlag().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getWorkNumber() == null) ? 0 : getWorkNumber().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        return result;
    }
}