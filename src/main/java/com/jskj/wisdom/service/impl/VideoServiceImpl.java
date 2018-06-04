package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.SVideoDAO;
import com.jskj.wisdom.model.wisdom.PPictures;
import com.jskj.wisdom.model.wisdom.SVideo;
import com.jskj.wisdom.service.PicturesService;
import com.jskj.wisdom.service.VideoService;
import com.jskj.wisdom.vo.video.VideoFindVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * @description
 * @date 2018-05-10 13:29 星期四
 */
@Service
public class VideoServiceImpl implements VideoService {
    private static final Logger logger = LoggerFactory.getLogger(VideoServiceImpl.class);

    @Resource
    private SVideoDAO sVideoDAO;

    @Resource
    private PicturesService picturesService;

    @Override
    public PageInfo<VideoFindVo> selectBySelective(SVideo record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum - 1, pageSize);
        List<SVideo> listTUsers = sVideoDAO.selectBySelective(record);
        return new PageInfo<>(findPic(VideoFindVo.daoToVo(listTUsers)));
    }

    @Override
    public List<VideoFindVo> selectBySelective(SVideo record) {
        return findPic(VideoFindVo.daoToVo(sVideoDAO.selectBySelective(record)));
    }

    @Override
    public VideoFindVo selectByPrimaryKey(Long id) {
        return findPic(VideoFindVo.daoToVo(sVideoDAO.selectByPrimaryKey(id)));
    }

    @Override
    public int insertSelective(SVideo record, double scale, MultipartFile[] imageFile) {
        Date date = new Date();
        record.setUpdateTime(date);
        record.setCreateTime(date);

        int num = sVideoDAO.insertSelective(record);
        if (num > 0) {
            PPictures pPictures = new PPictures();
            pPictures.setPicTypeId(record.getId());
            pPictures.setPicType(Global.VIDEO_PICTURE);
            num = picturesService.insertSelective(pPictures, scale, imageFile);
        }
        return num;
    }

    @Override
    public int updateByPrimaryKeySelective(SVideo record) {
        return sVideoDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sVideoDAO.deleteByPrimaryKey(id);
    }


    private List<VideoFindVo> findPic(List<VideoFindVo> recordVos) {
        PPictures    pPictures;
        List<String> picPaths;
        for (VideoFindVo recordVo : recordVos) {
            picPaths = new LinkedList<>();
            pPictures = new PPictures();

            pPictures.setPicType(Global.VIDEO_PICTURE);
            pPictures.setPicTypeId(recordVo.getId());
            List<PPictures> pPictures1 = picturesService.selectBySelective(pPictures);
            for (PPictures pictures : pPictures1) {
                picPaths.clear();
                picPaths.add(pictures.getPicPath());
            }
            recordVo.setPicPaths(picPaths);
        }
        return recordVos;
    }

    private VideoFindVo findPic(VideoFindVo recordVo) {
        List<String> picPaths;
        PPictures    pPictures;
        if (recordVo != null) {
            pPictures = new PPictures();
            picPaths = new LinkedList<>();
            pPictures.setPicType(Global.VIDEO_PICTURE);
            pPictures.setPicTypeId(recordVo.getId());
            List<PPictures> pPictures1 = picturesService.selectBySelective(pPictures);
            for (PPictures pictures : pPictures1) {
                picPaths.clear();
                picPaths.add(pictures.getPicPath());
            }
            recordVo.setPicPaths(picPaths);
        }
        return recordVo;
    }
}
