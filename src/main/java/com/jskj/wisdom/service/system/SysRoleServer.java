package com.jskj.wisdom.service.system;

import com.jskj.wisdom.model.system.SysRole;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.system
 * //TODO
 * @date 2018-05-24 15:15 星期四
 */
public interface SysRoleServer {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectBySelective(SysRole record);

    List<SysRole> selectRolesByUserId(Long userId);
}
