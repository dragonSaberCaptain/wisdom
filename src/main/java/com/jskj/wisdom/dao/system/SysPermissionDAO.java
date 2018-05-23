/* https://github.com/orange1438 */
package com.jskj.wisdom.dao.system;


import com.jskj.wisdom.model.system.SysPermission;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 *
 * @author LastChaosCaptain
 */
public interface SysPermissionDAO {
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
    int insert(SysPermission record);

    /**
     * 添加对象对应字段
     *
     * @param record 插入字段对象(必须含ID）
     */
    int insertSelective(SysPermission record);

    /**
     * 根据ID查询
     *
     * @param id 主键ID
     */
    SysPermission selectByPrimaryKey(Long id);

    /**
     * 根据ID修改对应字段
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     * 根据ID修改所有字段(必须含ID）
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> selectBySelective(SysPermission record);

    List<SysPermission> selectPermissionByUserId(Long userId);
}