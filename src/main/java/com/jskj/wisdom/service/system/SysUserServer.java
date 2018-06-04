package com.jskj.wisdom.service.system;

import com.jskj.wisdom.model.system.SysUser;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.system.impl
 * @description
 * @date 2018-05-23 17:55 Wed
 */
public interface SysUserServer {
    /**
     * 添加对象对应字段
     *
     * @param record 插入字段对象
     * @return int
     * @author dragonSaberCaptain
     * @date 2018-05-24 09:49:19
     */

    int insertSelective(SysUser record);

    int insertSelective(String loginName, String password);

    /**
     * 根据ID删除
     *
     * @param id
     * @return int
     * @author dragonSaberCaptain
     * @date 2018-05-24 09:51:41
     */
    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    List<SysUser> selectBySelective(SysUser sysUser);

}
