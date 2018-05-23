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
     * @description 获取萤石云的accessToken
     * @author dragonSaberCaptain
     * @date 2018-05-07 17:23:37
     */
    AccessTokenModel getAccessToken(String appKey, String appSecret);

    /**
     * @param
     * @return
     * @description 根据萤石云的accessToken获取子账户
     * @author dragonSaberCaptain
     * @date 2018-05-08 17:53:36
     */
    AccountIdModel getAccountId(String accessToken, String accountName, String password);
}
