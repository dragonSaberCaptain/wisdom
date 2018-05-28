package com.jskj.wisdom.service;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.model.SVideo;
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
public interface SVideoService {
    PageInfo<SVideo> selectBySelective(Long pid, boolean picToBase64, int pageNum, int pageSize);

    List<SVideo> selectBySelective(SVideo record);

    SVideo selectByPrimaryKey(Long id);

    int insertSelective(SVideo record);

    int insert(Long pid, String videoPathUrl, double scale, MultipartFile imageFile);

    int updateByPrimaryKeySelective(SVideo record);

    int updateByPrimaryKey(SVideo record);

    int deleteByPrimaryKey(Long id);
}
