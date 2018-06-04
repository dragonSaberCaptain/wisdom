//package com.jskj.wisdom.dao;
//
//import java.io.Serializable;
//import java.util.List;
//
///**
// * Copyright © 2018 dragonSaberCaptain. All rights reserved.
// *
// * @author dragonSaberCaptain
// * @packageName com.jskj.wisdom.dao
// * //TODO
// * @date 2018-06-05 10:05 星期二
// */
//public interface BaseDao<T, ID extends Serializable> {
//
//    /**
//     * 添加对象所有字段
//     *
//     * @param record 插入字段对象
//     * @author dragonSaberCaptain
//     * @date 2018-06-05 10:10:06
//     */
//    int insert(T record);
//
//    /**
//     * 添加对象对应字段
//     *
//     * @param record 插入字段对象
//     * @author dragonSaberCaptain
//     * @date 2018-06-05 10:10:50
//     */
//    int insertSelective(T record);
//
//    /**
//     * 根据ID删除
//     *
//     * @param id 主键ID
//     * @author dragonSaberCaptain
//     * @date 2018-06-05 10:09:38
//     */
//    int deleteByPrimaryKey(ID id);
//
//    /**
//     * 根据ID修改对应字段(必须含ID）
//     *
//     * @param record 修改字段对象(必须含ID）
//     * @author dragonSaberCaptain
//     * @date 2018-06-05 10:11:43
//     */
//    int updateByPrimaryKeySelective(T record);
//
//    /**
//     * 根据ID修改所有字段(必须含ID）
//     *
//     * @param record 修改字段对象(必须含ID）
//     * @author dragonSaberCaptain
//     * @date 2018-06-05 10:12:31
//     */
//    int updateByPrimaryKey(T record);
//
//
//    /**
//     * 根据ID查询
//     *
//     * @param id 主键ID
//     * @author dragonSaberCaptain
//     * @date 2018-06-05 10:11:08
//     */
//    T selectByPrimaryKey(ID id);
//
//    /**
//     * 根据查询条件查询
//     *
//     * @param record 查询字段对象
//     * @author dragonSaberCaptain
//     * @date 2018-06-05 10:13:19
//     */
//    List<T> selectBySelective(T record);
//}
