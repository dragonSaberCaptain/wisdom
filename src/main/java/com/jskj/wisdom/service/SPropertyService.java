package com.jskj.wisdom.service;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.model.SProperty;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * //TODO
 * @date 2018-05-28 09:43 星期一
 */
public interface SPropertyService {

    int deleteByPrimaryKey(Long id);

    int insert(SProperty record);

    int insertSelective(SProperty record);

    SProperty selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SProperty record);

    int updateByPrimaryKey(SProperty record);

    PageInfo<SProperty> selectBySelective(SProperty record, int pageNum, int pageSize);

    List<SProperty> selectBySelective(SProperty record);
}
