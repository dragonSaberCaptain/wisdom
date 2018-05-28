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
@ApiModel(value = "用户对象", description = "用于接受用户相关信息")
public class TUser implements Serializable {
    private static final long serialVersionUID = -2705422611141150706L;

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

    @ApiModelProperty(value = "是否注册：0否 1是  默认：0", name = "isRegister")
    private String isRegister;

    @ApiModelProperty(value = "用户名", name = "username")
    private String username;

    @JsonIgnore
    @ApiModelProperty(value = "密码", name = "password", hidden = true)
    private String password;

    @ApiModelProperty(value = "昵称", name = "nickname")
    private String nickname;

    @ApiModelProperty(value = "移动电话", name = "mobile")
    private String mobile;

    @ApiModelProperty(value = "身份证号", name = "idNumber")
    private String idNumber;

    @ApiModelProperty(hidden = true)
    private List<TPcell> tPcells;

    public List<TPcell> gettPcells() {
        return tPcells;
    }

    public void settPcells(List<TPcell> tPcells) {
        this.tPcells = tPcells;
    }

    /**
     * 获取 t_user.id
     *
     * @return t_user.id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 t_user.id
     *
     * @param id t_user.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 用户名 t_user.username
     *
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名 t_user.username
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取 密码 t_user.password
     *
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 密码 t_user.password
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取 昵称 t_user.nickname
     *
     * @return 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置 昵称 t_user.nickname
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取 移动电话 t_user.mobile
     *
     * @return 移动电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置 移动电话 t_user.mobile
     *
     * @param mobile 移动电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取 身份证号 t_user.id_number
     *
     * @return 身份证号
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置 身份证号 t_user.id_number
     *
     * @param idNumber 身份证号
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    /**
     * 获取 创建时间 t_user.create_time
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 t_user.create_time
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建者 t_user.create_id
     *
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * 设置 创建者 t_user.create_id
     *
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * 获取 更新时间 t_user.update_time
     *
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 t_user.update_time
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 更新者 t_user.update_id
     *
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置 更新者 t_user.update_id
     *
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取 备注 t_user.remark
     *
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注 t_user.remark
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 是否删除：0否 1是 t_user.is_delete
     *
     * @return 是否删除：0否 1是
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置 是否删除：0否 1是 t_user.is_delete
     *
     * @param isDelete 是否删除：0否 1是
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * 获取 是否注册：0否 1是 t_user.is_register
     *
     * @return 是否注册：0否 1是
     */
    public String getIsRegister() {
        return isRegister;
    }

    /**
     * 设置 是否注册：0否 1是 t_user.is_register
     *
     * @param isRegister 是否注册：0否 1是
     */
    public void setIsRegister(String isRegister) {
        this.isRegister = isRegister == null ? null : isRegister.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", mobile=").append(mobile);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", remark=").append(remark);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isRegister=").append(isRegister);
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
        TUser other = (TUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
                && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
                && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
                && (this.getIsRegister() == null ? other.getIsRegister() == null : this.getIsRegister().equals(other.getIsRegister()));
    }

    @Override
    public int hashCode() {
        final int prime  = 31;
        int       result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getIsRegister() == null) ? 0 : getIsRegister().hashCode());
        return result;
    }
}