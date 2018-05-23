package com.jskj.wisdom.service.system;

import com.jskj.wisdom.model.system.SysUserRole;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.system
 * @description
 * @date 2018-05-23 18:03 Wed
 */
public interface SysUserRoleServer {

    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    List<SysUserRole> selectBySelective(SysUserRole sysUserRole);
}
