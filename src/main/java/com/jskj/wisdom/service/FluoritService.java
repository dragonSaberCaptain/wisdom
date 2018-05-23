package com.jskj.wisdom.service;

import com.jskj.wisdom.model.fluorit.AccessTokenModel;
import com.jskj.wisdom.model.fluorit.AccountIdModel;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * @description
 * @date 2018-05-07 17:19 星期一
 */
public interface FluoritService {

    /**
     * 生成萤石云token
     *
     * @param appKey
     * @param appSecret
     * @return 萤石云token
     * @author dragonSaberCaptain
     * @date 2018-05-23 10:49:38
     */
    AccessTokenModel getAccessToken(String appKey, String appSecret);

    /**
     * 根据萤石云的accessToken获取子账户
     *
     * @param accessToken 萤石云token
     * @param accountName 账号
     * @param password    密码
     * @return 萤石云子账户
     * @author dragonSaberCaptain
     * @date 2018-05-08 17:53:36
     */
    AccountIdModel getAccountId(String accessToken, String accountName, String password);
}
