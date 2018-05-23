package com.jskj.wisdom.service.system.impl;

import com.jskj.wisdom.dao.system.SysRolePermissionDAO;
import com.jskj.wisdom.model.system.SysRolePermission;
import com.jskj.wisdom.service.system.SysRolePermissionServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.system.impl
 * //TODO
 * @date 2018-05-24 15:21 星期四
 */
@Service
public class SysRolePermissionServerImpl implements SysRolePermissionServer {
    @Resource
    private SysRolePermissionDAO sysRolePermissionDAO;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysRolePermissionDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRolePermission record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return sysRolePermissionDAO.insert(record);
    }

    @Override
    public int insertSelective(SysRolePermission record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return sysRolePermissionDAO.insertSelective(record);
    }

    @Override
    public SysRolePermission selectByPrimaryKey(Long id) {
        return sysRolePermissionDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRolePermission record) {
        record.setUpdateTime(new Date());
        return sysRolePermissionDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRolePermission record) {
        record.setUpdateTime(new Date());
        return sysRolePermissionDAO.updateByPrimaryKey(record);
    }
}
