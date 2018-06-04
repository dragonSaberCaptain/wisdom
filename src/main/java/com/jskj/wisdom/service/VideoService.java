package com.jskj.wisdom.service;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.model.wisdom.SVideo;
import com.jskj.wisdom.vo.video.VideoFindVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * @description
 * @date 2018-05-10 13:28 星期四
 */
public interface VideoService {
    PageInfo<VideoFindVo> selectBySelective(SVideo sVideo, int pageNum, int pageSize);

    List<VideoFindVo> selectBySelective(SVideo record);

    VideoFindVo selectByPrimaryKey(Long id);

    int insertSelective(SVideo record, double scale, MultipartFile[] imageFile);

    int updateByPrimaryKeySelective(SVideo record);

    int deleteByPrimaryKey(Long id);
}
