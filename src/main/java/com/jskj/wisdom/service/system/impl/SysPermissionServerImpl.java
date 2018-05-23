package com.jskj.wisdom.service.system.impl;

import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.system.SysPermissionDAO;
import com.jskj.wisdom.model.system.SysPermission;
import com.jskj.wisdom.service.system.SysPermissionServer;
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
 * @date 2018-05-24 15:25 星期四
 */
@Service
public class SysPermissionServerImpl implements SysPermissionServer {
    @Resource
    private SysPermissionDAO sysPermissionDAO;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysPermissionDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysPermission record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return sysPermissionDAO.insert(record);
    }

    @Override
    public int insertSelective(SysPermission record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return sysPermissionDAO.insertSelective(record);
    }

    @Override
    public SysPermission selectByPrimaryKey(Long id) {
        return sysPermissionDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysPermission record) {
        record.setUpdateTime(new Date());
        return sysPermissionDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysPermission record) {
        record.setUpdateTime(new Date());
        return sysPermissionDAO.updateByPrimaryKey(record);
    }

    @Override
    public List<SysPermission> selectBySelective(SysPermission record) {
        record.setIsDelete(Global.ZERO_STRING);
        return sysPermissionDAO.selectBySelective(record);
    }

    @Override
    public List<SysPermission> selectPermissionByUserId(Long userId) {
        return sysPermissionDAO.selectPermissionByUserId(userId);
    }
}
