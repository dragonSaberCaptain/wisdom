/* https://github.com/orange1438 */
package com.jskj.wisdom.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @author LastChaosCaptain
 */
public class SysRolePermission implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 7183148012100785507L;

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

    // 权限表id
    private Long permissionid;

    private Long roleId;

    /** 
     * 获取 主键id sys_role_permission.id
     * @return 主键id
     */
    public Long getId() {
        return id;
    }

    /** 
     * 设置 主键id sys_role_permission.id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * 获取 创建者 sys_role_permission.create_id
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /** 
     * 设置 创建者 sys_role_permission.create_id
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /** 
     * 获取 创建时间 sys_role_permission.create_time
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 sys_role_permission.create_time
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 是否删除：0否 1是  默认：0 sys_role_permission.is_delete
     * @return 是否删除：0否 1是  默认：0
     */
    public String getIsDelete() {
        return isDelete;
    }

    /** 
     * 设置 是否删除：0否 1是  默认：0 sys_role_permission.is_delete
     * @param isDelete 是否删除：0否 1是  默认：0
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /** 
     * 获取 备注 sys_role_permission.remark
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /** 
     * 设置 备注 sys_role_permission.remark
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /** 
     * 获取 更新者 sys_role_permission.update_id
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /** 
     * 设置 更新者 sys_role_permission.update_id
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /** 
     * 获取 更新时间 sys_role_permission.update_time
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /** 
     * 设置 更新时间 sys_role_permission.update_time
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * 获取 权限表id sys_role_permission.permissionid
     * @return 权限表id
     */
    public Long getPermissionid() {
        return permissionid;
    }

    /** 
     * 设置 权限表id sys_role_permission.permissionid
     * @param permissionid 权限表id
     */
    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
    }

    /** 
     * 获取 sys_role_permission.role_id
     * @return sys_role_permission.role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /** 
     * 设置 sys_role_permission.role_id
     * @param roleId sys_role_permission.role_id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
        sb.append(", permissionid=").append(permissionid);
        sb.append(", roleId=").append(roleId);
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
        SysRolePermission other = (SysRolePermission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPermissionid() == null ? other.getPermissionid() == null : this.getPermissionid().equals(other.getPermissionid()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()));
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
        result = prime * result + ((getPermissionid() == null) ? 0 : getPermissionid().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        return result;
    }
}