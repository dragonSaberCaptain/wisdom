package com.jskj.wisdom.service.system;

import com.jskj.wisdom.model.system.SysPermission;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.system
 * //TODO
 * @date 2018-05-24 15:25 星期四
 */
public interface SysPermissionServer {
    int deleteByPrimaryKey(Long id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> selectBySelective(SysPermission record);

    List<SysPermission> selectPermissionByUserId(Long userId);
}
