package com.jskj.wisdom.service;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.model.TUser;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * @description
 * @date 2018-05-04 12:23 星期五
 */
public interface TUserService {
    int updateByPrimaryKeySelective(TUser tUser);

    TUser selectByPrimaryKey(Long userId);

    /**
     * @param tUser    查询条件
     * @param pageNum  当前页
     * @param pageSize 每页大小
     * @return PageInfo<TUser>
     * @description 按查询条件分页查询
     * @author dragonSaberCaptain
     * @date 2018-05-14 09:12:25
     */
    PageInfo<TUser> selectBySelective(TUser tUser, String pageNum, String pageSize);

    List<TUser> selectBySelective(TUser tUser);

    TUser insertSelective(TUser tUser);

    Map<String, Object> login(String mobile, String code);

    int deleteByPrimaryKey(Long id);
}
