/* https://github.com/orange1438 */
package com.jskj.wisdom.dao;

import com.jskj.wisdom.model.wisdom.TPcell;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 *
 * @author LastChaosCaptain
 */
public interface TPcellDAO {
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
    int insert(TPcell record);

    /**
     * 添加对象对应字段
     *
     * @param record 插入字段对象(必须含ID）
     */
    int insertSelective(TPcell record);

    /**
     * 根据ID查询
     *
     * @param id 主键ID
     */
    TPcell selectByPrimaryKey(Long id);

    /**
     * 根据ID修改对应字段
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateByPrimaryKeySelective(TPcell record);

    /**
     * 根据ID修改所有字段(必须含ID）
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateByPrimaryKey(TPcell record);

    List<TPcell> selectBySelective(TPcell record);
}