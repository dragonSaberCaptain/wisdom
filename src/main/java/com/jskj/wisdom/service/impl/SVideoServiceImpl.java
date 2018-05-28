package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.SVideoDAO;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.exception.VideoException;
import com.jskj.wisdom.model.SVideo;
import com.jskj.wisdom.service.SVideoService;
import com.jskj.wisdom.utils.pic.PicUtil;
import com.jskj.wisdom.utils.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @description
 * @date 2018-05-10 13:29 星期四
 */
@Service
public class SVideoServiceImpl implements SVideoService {
    private static final Logger    logger = LoggerFactory.getLogger(SVideoServiceImpl.class);
    @Resource
    private              SVideoDAO sVideoDAO;

    @Override
    public PageInfo<SVideo> selectBySelective(SVideo record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum - 1, pageSize);
        List<SVideo> listTUsers = sVideoDAO.selectBySelective(record);

        String result;
            for (SVideo listTUser : listTUsers) {
                if (StringUtil.isBlank(listTUser.getVideoPicUrl())) {
                    continue;
                }
                result = "http://" + Global.HOST + "/open/getPic?source=" + listTUser.getVideoPicUrl() + "&scale=0.5&format=jpg";
                listTUser.setVideoPicUrl(result);
            }
        return new PageInfo<>(listTUsers);
    }

    @Override
    public List<SVideo> selectBySelective(SVideo record) {
        return sVideoDAO.selectBySelective(record);
    }

    @Override
    public SVideo selectByPrimaryKey(Long id) {
        return sVideoDAO.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SVideo record, double scale, MultipartFile imageFile) {
        String url = null;
        if (imageFile != null) {
            if (imageFile.getSize() >= Global.FILE_SIZE) {
                throw new VideoException(ResultEnum.FILE_TOO_BIG);
            }
            url = PicUtil.savePic(Global.VIDEO_PICTURE_PATH, imageFile, scale);
        }
        Date   date   = new Date();
        SVideo sVideo = new SVideo();
        sVideo.setPid(record.getPid());
        sVideo.setVideoPathUrl(record.getVideoPathUrl());
        List<SVideo> sVideos = sVideoDAO.selectBySelective(sVideo);
        if (sVideos.size() > 0) {
            sVideos.get(0).setVideoPicUrl(url);
            sVideos.get(0).setVideoType(record.getVideoType());
            sVideos.get(0).setVideoName(record.getVideoName());
            sVideos.get(0).setUpdateTime(date);
            return sVideoDAO.updateByPrimaryKeySelective(sVideos.get(0));
        }
        sVideo.setVideoName(record.getVideoName());
        sVideo.setVideoType(record.getVideoType());
        sVideo.setVideoPicUrl(url);
        sVideo.setUpdateTime(date);
        sVideo.setCreateTime(date);
        return sVideoDAO.insertSelective(record);
    }

    @Override
    public int insert(SVideo record, double scale, MultipartFile imageFile) {
        String url = null;
        if (imageFile != null) {
            if (imageFile.getSize() >= Global.FILE_SIZE) {
                throw new VideoException(ResultEnum.FILE_TOO_BIG);
            }
            url = PicUtil.savePic(Global.VIDEO_PICTURE_PATH, imageFile, scale);
        }
        Date   date   = new Date();
        SVideo sVideo = new SVideo();
        sVideo.setPid(record.getPid());
        sVideo.setVideoPathUrl(record.getVideoPathUrl());
        List<SVideo> sVideos = sVideoDAO.selectBySelective(sVideo);
        if (sVideos.size() > 0) {
            sVideos.get(0).setVideoPicUrl(url);
            sVideos.get(0).setVideoType(record.getVideoType());
            sVideos.get(0).setVideoName(record.getVideoName());
            sVideos.get(0).setUpdateTime(date);
            return sVideoDAO.updateByPrimaryKeySelective(sVideos.get(0));
        }
        sVideo.setVideoName(record.getVideoName());
        sVideo.setVideoType(record.getVideoType());
        sVideo.setVideoPicUrl(url);
        sVideo.setUpdateTime(date);
        sVideo.setCreateTime(date);
        return sVideoDAO.insert(sVideo);
    }

    @Override
    public int updateByPrimaryKeySelective(SVideo record) {
        return sVideoDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SVideo record) {
        return sVideoDAO.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sVideoDAO.deleteByPrimaryKey(id);
    }
}
