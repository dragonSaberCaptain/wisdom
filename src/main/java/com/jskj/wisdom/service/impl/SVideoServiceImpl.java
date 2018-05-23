package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.SVideoDAO;
import com.jskj.wisdom.enums.VideoEnum;
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
    public PageInfo<SVideo> selectBySelective(Long pid, boolean picToBase64, String pageNum, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageNum) - 1, Integer.parseInt(pageSize));
        SVideo sVideo = new SVideo();
        sVideo.setPid(pid);
        List<SVideo> listTUsers = selectBySelective(sVideo);
        if (picToBase64) {
            String result;
            for (SVideo listTUser : listTUsers) {
                result = PicUtil.getImageStr(Global.VIDEO_PICTURE_PATH + listTUser.getVideoPicUrl());
                if (StringUtil.isBlank(result)) {
                    continue;
                }
                listTUser.setVideoPicUrl(result);
            }
        }
        return new PageInfo<>(listTUsers);
    }

    @Override
    public List<SVideo> selectBySelective(SVideo record) {
        record.setIsDelete(Global.ZERO_STRING);
        return sVideoDAO.selectBySelective(record);
    }

    @Override
    public SVideo selectByPrimaryKey(Long id) {
        return sVideoDAO.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SVideo record) {
        return sVideoDAO.insertSelective(record);
    }

    @Override
    public int insert(Long pid, String videoPathUrl, double scale, MultipartFile imageFile) {
        if (imageFile == null) {
            throw new VideoException(VideoEnum.PIC_IS_EMPTY);
        }

        if (imageFile.getSize() >= Global.FILE_SIZE) {
            throw new VideoException(VideoEnum.PIC_TOO_BIG);
        }
        Date   date   = new Date();
        SVideo sVideo = new SVideo();
        sVideo.setPid(pid);
        sVideo.setVideoPathUrl(videoPathUrl);
        List<SVideo> sVideos = sVideoDAO.selectBySelective(sVideo);

        String url = PicUtil.savePic(imageFile, scale);

        if (sVideos.size() > 0) {
            sVideo = new SVideo();
            sVideo.setId(sVideos.get(0).getId());
            sVideo.setUpdateTime(date);
            sVideo.setVideoPicUrl(url);
            return sVideoDAO.updateByPrimaryKeySelective(sVideo);
        }

        sVideo.setIsDelete(Global.ZERO_STRING);
        sVideo.setVideoPicUrl(url);
        sVideo.setCreateTime(date);
        sVideo.setUpdateTime(date);
        return sVideoDAO.insert(sVideo);
    }

    @Override
    public int updateByPrimaryKeySelective(SVideo record) {
        return sVideoDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SVideo record) {
        if (record.getId() <= 0) {
            throw new VideoException(VideoEnum.UPDATE_FAIL);
        }
        return sVideoDAO.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sVideoDAO.deleteByPrimaryKey(id);
    }
}
