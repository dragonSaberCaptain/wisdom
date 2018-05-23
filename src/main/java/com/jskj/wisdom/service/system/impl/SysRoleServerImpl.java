package com.jskj.wisdom.service.system.impl;

import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.system.SysRoleDAO;
import com.jskj.wisdom.model.system.SysRole;
import com.jskj.wisdom.service.system.SysRoleServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.system.impl
 * //TODO
 * @date 2018-05-24 15:16 星期四
 */
@Service
public class SysRoleServerImpl implements SysRoleServer {
    @Resource
    private SysRoleDAO sysRoleDAO;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysRoleDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRole record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return sysRoleDAO.insert(record);
    }

    @Override
    public int insertSelective(SysRole record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return sysRoleDAO.insertSelective(record);
    }

    @Override
    public SysRole selectByPrimaryKey(Long id) {
        return sysRoleDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        record.setUpdateTime(new Date());
        return sysRoleDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRole record) {
        record.setUpdateTime(new Date());
        return sysRoleDAO.updateByPrimaryKey(record);
    }

    @Override
    public List<SysRole> selectBySelective(SysRole record) {
        record.setIsDelete(Global.ZERO_STRING);
        return sysRoleDAO.selectBySelective(record);
    }

    @Override
    public List<SysRole> selectRolesByUserId(Long userId) {
        return sysRoleDAO.selectRolesByUserId(userId);
    }
}
