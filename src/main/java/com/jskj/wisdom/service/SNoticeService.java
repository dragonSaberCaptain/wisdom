package com.jskj.wisdom.service;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.model.SNotice;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * //TODO
 * @date 2018-05-28 09:42 星期一
 */
public interface SNoticeService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(SNotice record);

    SNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SNotice record);

    List<SNotice> selectBySelective(SNotice record);

    PageInfo<SNotice> selectBySelective(SNotice record, int pageNum, int pageSize);
}
