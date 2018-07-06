package com.jskj.wisdom.service.impl;

import com.alibaba.fastjson.JSON;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.config.fluorit.FluoritConfig;
import com.jskj.wisdom.dao.AccountTokenDAO;
import com.jskj.wisdom.model.fluorit.AccessTokenModel;
import com.jskj.wisdom.model.fluorit.AccountIdModel;
import com.jskj.wisdom.model.wisdom.AccountToken;
import com.jskj.wisdom.model.wisdom.TUser;
import com.jskj.wisdom.service.FluoritService;
import com.jskj.wisdom.utils.http.HttpClientUtil;
import com.jskj.wisdom.utils.safety.UuidUtil;
import com.jskj.wisdom.utils.string.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    private static final Logger logger = LoggerFactory.getLogger(FluoritServiceImpl.class);

    private FluoritConfig fluoritConfig = new FluoritConfig();

    @Resource
    private AccountTokenDAO accountTokenDAO;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

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
        String uuid = UuidUtil.creatUUID();
        if (StringUtil.isBlank(accessToken)) {
            AccessTokenModel accessTokenModel = getAccessToken(null, null);
            accessToken = accessTokenModel.getData().getAccessToken();

        }
        logger.info("生成的萤石云父token：" + accessToken);
        if (StringUtil.isBlank(accountName)) {
            accountName = DigestUtils.md5Hex(Global.MD5_SALT + uuid).toUpperCase();
        }

        logger.info("生成的md5,token：" + accountName);

        if (StringUtil.isBlank(password)) {
            password = "dragonSaberCaptain" + uuid;
        }
        password = DigestUtils.md5Hex(accessToken + "#" + password).toLowerCase();
        String         result         = HttpClientUtil.sendPostRequest(fluoritConfig.getAccountUrl, "accessToken=" + accessToken + "&accountName=" + accountName + "&password=" + password);
        AccountIdModel accountIdModel = null;
        if (StringUtil.isNotBlank(result)) {
            accountIdModel = JSON.parseObject(result, AccountIdModel.class);
        }
        return accountIdModel;
    }

    @Override
    public AccountToken createAccountId(TUser tUser, String token, String uuid) {
        AccountToken accountToken = new AccountToken();

        String accountId = stringRedisTemplate.opsForValue().get( tUser.getId() + "_fluorite-cloudt_accountId" );
        logger.info("先从缓存中找萤石云子账户id:" + accountId);

        if (StringUtil.isBlank(accountId)) {
            accountToken.setUserId(tUser.getId());
            accountToken.setThirdName("萤石云");
            accountToken.setThirdPartyType("子账户");
            List<AccountToken> accountTokens = accountTokenDAO.selectBySelective(accountToken);

            logger.info("从数据库中找萤石云子账户id");
            if (accountTokens.size() > 0) {
                return accountToken;
            } else {
                logger.info("数据库中也没有萤石云子账户则创建");

                AccessTokenModel accessTokenModel = getAccessToken(null, null);
                logger.info("生成的萤石云父token：" + accessTokenModel.getData().toString());

                String password = "dragonSaberCaptain" + uuid;

                logger.info("生成萤石云子token前参数：父token" + accessTokenModel.getData().getAccessToken() + ",账号：" + token + ",密码:" + password);
                AccountIdModel accountIdModel = getAccountId(accessTokenModel.getData().getAccessToken(), token, password);
                logger.info("生成萤石云子token后：" + accountIdModel.getData().toString());

                accountToken.setCreateId(tUser.getId());
                accountToken.setCreateTime(new Date());
                accountToken.setUpdateTime(new Date());
                accountToken.setThirdPartyName(token);
                accountToken.setThirdPartyPassword(password);
                accountToken.setThirdPartyToken(accessTokenModel.getData().getAccessToken());
                accountToken.setThirdPartyId(accountIdModel.getData().getAccountId());
                logger.info("保存生成的萤石云子账户id到数据库:" + accountToken.getThirdPartyId());
                int i = accountTokenDAO.insertSelective(accountToken);
                if (i > 0) {
                    logger.info("保存生成的萤石云子账户id到缓存中:" + accountToken.getThirdPartyId());
                    stringRedisTemplate.opsForValue().set( tUser.getId() + "_fluorite-cloud_accountId", accountToken.getThirdPartyId() );
                    return accountToken;
                }
            }
        } else {
            accountToken.setThirdPartyId(accountId);
            return accountToken;
        }
        return null;
    }
}
