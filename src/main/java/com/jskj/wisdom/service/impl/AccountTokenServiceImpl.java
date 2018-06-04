package com.jskj.wisdom.service.impl;

import com.jskj.wisdom.dao.AccountTokenDAO;
import com.jskj.wisdom.model.wisdom.AccountToken;
import com.jskj.wisdom.service.AccountTokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * //TODO
 * @date 2018-06-13 17:54 星期三
 */
@Service
public class AccountTokenServiceImpl implements AccountTokenService {
    @Resource
    private AccountTokenDAO accountTokenDAO;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return accountTokenDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(AccountToken record) {
        return accountTokenDAO.insertSelective(record);
    }

    @Override
    public AccountToken selectByPrimaryKey(Long id) {
        return accountTokenDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AccountToken record) {
        return accountTokenDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<AccountToken> selectBySelective(AccountToken record) {
        return accountTokenDAO.selectBySelective(record);
    }
}
