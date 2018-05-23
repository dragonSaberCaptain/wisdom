package com.jskj.wisdom.service.system;

import com.jskj.wisdom.model.system.SysRolePermission;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.system
 * //TODO
 * @date 2018-05-24 15:21 星期四
 */
public interface SysRolePermissionServer {
    int deleteByPrimaryKey(Long id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}
