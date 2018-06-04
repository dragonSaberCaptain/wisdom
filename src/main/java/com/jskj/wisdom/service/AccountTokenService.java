package com.jskj.wisdom.service;

import com.jskj.wisdom.model.wisdom.AccountToken;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * //TODO
 * @date 2018-06-13 17:54 星期三
 */
public interface AccountTokenService {
    int deleteByPrimaryKey(Long id);

    int insertSelective(AccountToken record);

    AccountToken selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountToken record);

    List<AccountToken> selectBySelective(AccountToken record);
}
