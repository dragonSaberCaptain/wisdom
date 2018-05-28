package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.SPropertyDAO;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.exception.PropertyException;
import com.jskj.wisdom.model.SProperty;
import com.jskj.wisdom.service.SPropertyService;
import com.jskj.wisdom.utils.pic.PicUtil;
import com.jskj.wisdom.utils.string.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public int insert(SProperty record, double scale, MultipartFile imageFile) {
        String url = null;
        if (imageFile != null) {
            if (imageFile.getSize() >= Global.FILE_SIZE) {
                throw new PropertyException(ResultEnum.FILE_TOO_BIG);
            }
            url = PicUtil.savePic(Global.PROPERTY_PICTURE_PATH, imageFile, scale);
        }

        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        record.setPicPath(url);
        return sPropertyDAO.insert(record);
    }

    @Override
    public int insertSelective(SProperty record, double scale, MultipartFile imageFile) {
        String url = null;
        if (imageFile != null) {
            if (imageFile.getSize() >= Global.FILE_SIZE) {
                throw new PropertyException(ResultEnum.FILE_TOO_BIG);
            }
            url = PicUtil.savePic(Global.PROPERTY_PICTURE_PATH, imageFile, scale);
        }

        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        record.setPicPath(url);
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
        List<SProperty> sProperties = sPropertyDAO.selectBySelective(record);
        String          result;
        for (SProperty sProperty : sProperties) {
            if (StringUtil.isBlank(sProperty.getPicPath())) {
                continue;
            }
            result = "http://" + Global.HOST + "/open/getPic?source=" + sProperty.getPicPath() + "&scale=0.5&format=jpg";
            sProperty.setPicPath(result);
        }
        return new PageInfo<>(sProperties);
    }

    @Override
    public List<SProperty> selectBySelective(SProperty record) {
        return sPropertyDAO.selectBySelective(record);
    }
}
