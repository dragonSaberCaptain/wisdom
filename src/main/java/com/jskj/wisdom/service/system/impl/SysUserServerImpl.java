package com.jskj.wisdom.service.system.impl;

import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.system.SysUserDAO;
import com.jskj.wisdom.model.system.SysUser;
import com.jskj.wisdom.service.system.SysUserRoleServer;
import com.jskj.wisdom.service.system.SysUserServer;
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
 * @date 2018-05-23 17:57 Wed
 */
@Service
public class SysUserServerImpl implements SysUserServer {
    @Resource
    private SysUserDAO sysUserDAO;

    @Resource
    private SysUserRoleServer sysUserRoleServer;

    @Override
    public int insert(SysUser record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        record.setNickName("未填写");
        return sysUserDAO.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        record.setNickName("未填写");
        return sysUserDAO.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUserDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        record.setUpdateTime(new Date());
        return sysUserDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        record.setUpdateTime(new Date());
        return sysUserDAO.updateByPrimaryKey(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Long id) {
        return sysUserDAO.selectByPrimaryKey(id);
    }

    @Override
    public List<SysUser> selectBySelective(SysUser sysUser) {
        sysUser.setIsDelete(Global.ZERO_STRING);
        return sysUserDAO.selectBySelective(sysUser);
    }
}
