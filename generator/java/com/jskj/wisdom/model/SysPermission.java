/* https://github.com/orange1438 */
package com.jskj.wisdom.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @author LastChaosCaptain
 */
public class SysPermission implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 1001643856390511464L;

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

    // 权限方法
    private String method;

    // 权限名称
    private String name;

    // 排序
    private String sort;

    // 权限url
    private String permissionUrl;

    /** 
     * 获取 主键id sys_permission.id
     * @return 主键id
     */
    public Long getId() {
        return id;
    }

    /** 
     * 设置 主键id sys_permission.id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * 获取 创建者 sys_permission.create_id
     * @return 创建者
     */
    public Long getCreateId() {
        return createId;
    }

    /** 
     * 设置 创建者 sys_permission.create_id
     * @param createId 创建者
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /** 
     * 获取 创建时间 sys_permission.create_time
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 sys_permission.create_time
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 是否删除：0否 1是  默认：0 sys_permission.is_delete
     * @return 是否删除：0否 1是  默认：0
     */
    public String getIsDelete() {
        return isDelete;
    }

    /** 
     * 设置 是否删除：0否 1是  默认：0 sys_permission.is_delete
     * @param isDelete 是否删除：0否 1是  默认：0
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /** 
     * 获取 备注 sys_permission.remark
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /** 
     * 设置 备注 sys_permission.remark
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /** 
     * 获取 更新者 sys_permission.update_id
     * @return 更新者
     */
    public Long getUpdateId() {
        return updateId;
    }

    /** 
     * 设置 更新者 sys_permission.update_id
     * @param updateId 更新者
     */
    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    /** 
     * 获取 更新时间 sys_permission.update_time
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /** 
     * 设置 更新时间 sys_permission.update_time
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * 获取 权限方法 sys_permission.method
     * @return 权限方法
     */
    public String getMethod() {
        return method;
    }

    /** 
     * 设置 权限方法 sys_permission.method
     * @param method 权限方法
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /** 
     * 获取 权限名称 sys_permission.name
     * @return 权限名称
     */
    public String getName() {
        return name;
    }

    /** 
     * 设置 权限名称 sys_permission.name
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /** 
     * 获取 排序 sys_permission.sort
     * @return 排序
     */
    public String getSort() {
        return sort;
    }

    /** 
     * 设置 排序 sys_permission.sort
     * @param sort 排序
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /** 
     * 获取 权限url sys_permission.permission_url
     * @return 权限url
     */
    public String getPermissionUrl() {
        return permissionUrl;
    }

    /** 
     * 设置 权限url sys_permission.permission_url
     * @param permissionUrl 权限url
     */
    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
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
        sb.append(", method=").append(method);
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append(", permissionUrl=").append(permissionUrl);
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
        SysPermission other = (SysPermission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getPermissionUrl() == null ? other.getPermissionUrl() == null : this.getPermissionUrl().equals(other.getPermissionUrl()));
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
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getPermissionUrl() == null) ? 0 : getPermissionUrl().hashCode());
        return result;
    }
}