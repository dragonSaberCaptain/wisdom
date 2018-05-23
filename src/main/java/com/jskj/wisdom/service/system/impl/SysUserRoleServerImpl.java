package com.jskj.wisdom.service.system.impl;

import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.system.SysUserRoleDAO;
import com.jskj.wisdom.model.system.SysUserRole;
import com.jskj.wisdom.service.system.SysUserRoleServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.system.impl
 * @description
 * @date 2018-05-23 18:03 Wed
 */
@Service
public class SysUserRoleServerImpl implements SysUserRoleServer {

    @Resource
    private SysUserRoleDAO sysUserRoleDAO;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUserRoleDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUserRole record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return sysUserRoleDAO.insert(record);
    }

    @Override
    public int insertSelective(SysUserRole record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return sysUserRoleDAO.insertSelective(record);
    }

    @Override
    public SysUserRole selectByPrimaryKey(Long id) {
        return sysUserRoleDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUserRole record) {
        record.setUpdateTime(new Date());
        return sysUserRoleDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUserRole record) {
        record.setUpdateTime(new Date());
        return sysUserRoleDAO.updateByPrimaryKey(record);
    }

    @Override
    public List<SysUserRole> selectBySelective(SysUserRole sysUserRole) {
        sysUserRole.setIsDelete(Global.ZERO_STRING);
        return sysUserRoleDAO.selectBySelective(sysUserRole);
    }
}
