package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.SComplaintDAO;
import com.jskj.wisdom.model.wisdom.PPictures;
import com.jskj.wisdom.model.wisdom.SComplaint;
import com.jskj.wisdom.service.ComplaintService;
import com.jskj.wisdom.service.PicturesService;
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
 * @date 2018-06-05 09:02 星期二
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Resource
    private SComplaintDAO sComplaintDAO;

    @Resource
    private PicturesService picturesService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sComplaintDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SComplaint record, double scale, MultipartFile[] imageFile) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        int num = sComplaintDAO.insertSelective(record);
        if (num > 0) {
            PPictures pPictures = new PPictures();
            pPictures.setPicTypeId(record.getId());
            pPictures.setPicType(Global.COMPLAINT_PICTURE);
            num = picturesService.insertSelective(pPictures, scale, imageFile);
        }
        return num;
    }

    @Override
    public SComplaint selectByPrimaryKey(Long id) {
        return sComplaintDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SComplaint record) {
        record.setUpdateTime(new Date());
        return sComplaintDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SComplaint> selectBySelective(SComplaint record) {
        return sComplaintDAO.selectBySelective(record);
    }

    @Override
    public PageInfo<SComplaint> selectBySelective(SComplaint record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum - 1, pageSize);
        List<SComplaint> sComplaints = selectBySelective(record);
        return new PageInfo<>(sComplaints);
    }
}
