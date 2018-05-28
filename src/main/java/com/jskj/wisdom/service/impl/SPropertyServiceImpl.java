package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.SPropertyDAO;
import com.jskj.wisdom.model.SProperty;
import com.jskj.wisdom.service.SPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * //TODO
 * @date 2018-05-28 09:43 星期一
 */
@Service
public class SPropertyServiceImpl implements SPropertyService {
    @Resource
    private SPropertyDAO sPropertyDAO;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sPropertyDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SProperty record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return sPropertyDAO.insert(record);
    }

    @Override
    public int insertSelective(SProperty record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return sPropertyDAO.insertSelective(record);
    }

    @Override
    public SProperty selectByPrimaryKey(Long id) {
        return sPropertyDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SProperty record) {
        record.setUpdateTime(new Date());
        return sPropertyDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SProperty record) {
        record.setUpdateTime(new Date());
        return sPropertyDAO.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<SProperty> selectBySelective(SProperty record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum - 1, pageSize);
        List<SProperty> sProperties = selectBySelective(record);
        for (SProperty sProperty : sProperties) {
            sProperty.setPicPath(Global.PROPERTY_PICTURE_PATH + sProperty.getPicPath());
        }
        return new PageInfo<>(sProperties);
    }

    @Override
    public List<SProperty> selectBySelective(SProperty record) {
        record.setIsDelete(Global.ZERO_STRING);
        return sPropertyDAO.selectBySelective(record);
    }
}
