/* https://github.com/orange1438 */
package com.jskj.wisdom.dao.system;

import com.jskj.wisdom.model.system.SysUser;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 *
 * @author LastChaosCaptain
 */
public interface SysUserDAO {
    /**
     * 根据ID删除
     *
     * @param id 主键ID
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加对象所有字段
     *
     * @param record 插入字段对象(必须含ID）
     */
    int insert(SysUser record);

    /**
     * 添加对象对应字段
     *
     * @param record 插入字段对象(必须含ID）
     */
    int insertSelective(SysUser record);

    /**
     * 根据ID查询
     *
     * @param id 主键ID
     */
    SysUser selectByPrimaryKey(Long id);

    /**
     * 根据ID修改对应字段
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 根据ID修改所有字段(必须含ID）
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateByPrimaryKey(SysUser record);

    List<SysUser> selectBySelective(SysUser record);

//    SysUser selectRolesByUserName(String loginName);

//    SysUser selectPermissionByUserName(String loginName);
}