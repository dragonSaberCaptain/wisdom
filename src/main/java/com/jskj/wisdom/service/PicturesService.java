package com.jskj.wisdom.service;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.model.wisdom.PPictures;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * //TODO
 * @date 2018-06-05 11:28 星期二
 */
public interface PicturesService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(PPictures record);

    int insertSelective(PPictures record, double scale, MultipartFile[] imageFile);

    int insertSelective(PPictures record, double scale, MultipartFile imageFile);

    PPictures selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PPictures record);

    List<PPictures> selectBySelective(PPictures record);

    PageInfo<PPictures> selectBySelective(PPictures record, int pageNum, int pageSize);


}
