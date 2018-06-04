/* https://github.com/orange1438 */
package com.jskj.wisdom.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @author LastChaosCaptain
 */
public class SysRole implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -7490223771135833552L;

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

    // 角色名称
    private String name;

    // 角色级别
    private String roleLevet;

    /** 
     * 获取 主键id sys_role.id
     * @return 主键id
     */
    public Long getId() {
        return id;
    }

    /** 
     * 设置 主键id sys_role.id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * 获取 创建者 sys_role.create_id
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /** 
     * 设置 创建者 sys_role.create_id
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /** 
     * 获取 创建时间 sys_role.create_time
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 sys_role.create_time
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 是否删除：0否 1是  默认：0 sys_role.is_delete
     * @return 是否删除：0否 1是  默认：0
     */
    public String getIsDelete() {
        return isDelete;
    }

    /** 
     * 设置 是否删除：0否 1是  默认：0 sys_role.is_delete
     * @param isDelete 是否删除：0否 1是  默认：0
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /** 
     * 获取 备注 sys_role.remark
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /** 
     * 设置 备注 sys_role.remark
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /** 
     * 获取 更新者 sys_role.update_id
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /** 
     * 设置 更新者 sys_role.update_id
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /** 
     * 获取 更新时间 sys_role.update_time
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /** 
     * 设置 更新时间 sys_role.update_time
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * 获取 角色名称 sys_role.name
     * @return 角色名称
     */
    public String getName() {
        return name;
    }

    /** 
     * 设置 角色名称 sys_role.name
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /** 
     * 获取 角色级别 sys_role.role_levet
     * @return 角色级别
     */
    public String getRoleLevet() {
        return roleLevet;
    }

    /** 
     * 设置 角色级别 sys_role.role_levet
     * @param roleLevet 角色级别
     */
    public void setRoleLevet(String roleLevet) {
        this.roleLevet = roleLevet == null ? null : roleLevet.trim();
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
        sb.append(", name=").append(name);
        sb.append(", roleLevet=").append(roleLevet);
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
        SysRole other = (SysRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRoleLevet() == null ? other.getRoleLevet() == null : this.getRoleLevet().equals(other.getRoleLevet()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRoleLevet() == null) ? 0 : getRoleLevet().hashCode());
        return result;
    }
}