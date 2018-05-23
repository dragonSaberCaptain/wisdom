package com.jskj.wisdom.service.impl;

import com.alibaba.fastjson.JSON;
import com.jskj.wisdom.config.fluorit.FluoritConfig;
import com.jskj.wisdom.model.fluorit.AccessTokenModel;
import com.jskj.wisdom.model.fluorit.AccountIdModel;
import com.jskj.wisdom.service.FluoritService;
import com.jskj.wisdom.utils.http.HttpClientUtil;
import com.jskj.wisdom.utils.string.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * @description
 * @date 2018-05-07 17:20 星期一
 */
@Service
public class FluoritServiceImpl implements FluoritService {
    private FluoritConfig fluoritConfig = new FluoritConfig();

    @Override
    public AccessTokenModel getAccessToken(String appKey, String appSecret) {
        if (StringUtil.isNotBlank(appKey)) {
            fluoritConfig.appkey = appKey;
        }
        if (StringUtil.isNotBlank(appSecret)) {
            fluoritConfig.appsecret = appSecret;
        }
        String           result           = HttpClientUtil.sendPostRequest(fluoritConfig.getTokenUrl, fluoritConfig.tokenUrlParameters);
        AccessTokenModel accessTokenModel = null;
        if (StringUtil.isNotBlank(result)) {
            accessTokenModel = JSON.parseObject(result, AccessTokenModel.class);
        }
        return accessTokenModel;
    }

    @Override
    public AccountIdModel getAccountId(String accessToken, String accountName, String password) {
        if (StringUtil.isBlank(accessToken)) {
            return null;
        }
        if (StringUtil.isBlank(accountName)) {
            return null;
        }
        if (StringUtil.isBlank(password)) {
            return null;
        }
        password = DigestUtils.md5Hex(accessToken + "#" + password).toLowerCase();
        String         result         = HttpClientUtil.sendPostRequest(fluoritConfig.getAccountUrl, "accessToken=" + accessToken + "&accountName=" + accountName + "&password=" + password);
        AccountIdModel accountIdModel = null;
        if (StringUtil.isNotBlank(result)) {
            accountIdModel = JSON.parseObject(result, AccountIdModel.class);
        }
        return accountIdModel;
    }
}
