package com.jskj.wisdom.service.impl;

import cn.jsms.api.ValidSMSResult;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.TPcellDAO;
import com.jskj.wisdom.dao.TRoomDAO;
import com.jskj.wisdom.dao.TUserDAO;
import com.jskj.wisdom.enums.UserEnum;
import com.jskj.wisdom.exception.UserException;
import com.jskj.wisdom.model.mongodb.MongodbUser;
import com.jskj.wisdom.model.wisdom.TPcell;
import com.jskj.wisdom.model.wisdom.TRoom;
import com.jskj.wisdom.model.wisdom.TUser;
import com.jskj.wisdom.service.FluoritService;
import com.jskj.wisdom.service.UserService;
import com.jskj.wisdom.utils.database.mongodb.MongodbUtil;
import com.jskj.wisdom.utils.database.redis.JedisUtil;
import com.jskj.wisdom.utils.jpush.JpushSMSUtil;
import com.jskj.wisdom.utils.safety.UuidUtil;
import com.jskj.wisdom.utils.safety.VerifyUtil;
import com.jskj.wisdom.utils.string.StringUtil;
import com.mongodb.client.MongoCollection;
import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * @description
 * @date 2018-05-04 12:24 星期五
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private TUserDAO tUserDAO;

    @Resource
    private TPcellDAO tPcellDAO;

    @Resource
    private TRoomDAO tRoomDAO;

    @Resource
    private FluoritService fluoritService;

    @Override
    public int updateByPrimaryKeySelective(TUser tUser) {
        tUser.setUpdateTime(new Date());
        return tUserDAO.updateByPrimaryKeySelective(tUser);
    }

    @Override
    public TUser selectByPrimaryKey(Long userId) {
        TUser tUser = tUserDAO.selectByPrimaryKey(userId);
        if (null == tUser) {
            logger.error("用户不存在");
            throw new UserException(UserEnum.NOT_FOUND);
        }
        if (tUser.getIsDelete().equals(Global.ONE_STRING)) {
            logger.error("用户已删除");
            throw new UserException(UserEnum.DELETED);
        }
        if (tUser.getIsRegister().equals(Global.ZERO_STRING)) {
            logger.error("用户未注册");
            throw new UserException((UserEnum.UNREGISTERED));
        }
        logger.info("脱敏处理");
        tUser.setIdNumber(VerifyUtil.idDesensitization(tUser.getIdNumber()));
        tUser.setMobile(VerifyUtil.mobileDesensitization(tUser.getMobile()));
        return tUser;
    }

    @Override
    public PageInfo<TUser> selectBySelective(TUser tUser, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum - 1, pageSize);
        List<TUser> listTUsers = selectBySelective(tUser);
        //脱敏处理
        for (TUser listTUser : listTUsers) {
            listTUser.setIdNumber(VerifyUtil.idDesensitization(listTUser.getIdNumber()));
            listTUser.setMobile(VerifyUtil.mobileDesensitization(listTUser.getMobile()));
        }
        return new PageInfo<>(listTUsers);
    }

    @Override
    public List<TUser> selectBySelective(TUser tUser) {
        return tUserDAO.selectBySelective(tUser);
    }

    @Override
    public TUser insertSelective(TUser tUser) {
        logger.info("向t_user表发起查询：查询条件" + tUser.toString());
        List<TUser> tUsers = tUserDAO.selectBySelective(tUser);
        if (tUsers != null && tUsers.size() != 0) {
            logger.error("用户已存在");
            throw new UserException(UserEnum.ALREADY_EXISTED);
        }

        //TODO 这里有待优化
        String                    housingEstate = "flib_1";
        MongoCollection<Document> collection    = MongodbUtil.createCollection(housingEstate);
        Document                  document      = collection.find(eq("phone", tUser.getMobile())).first();
        if (document == null) {
            housingEstate = "flib_4";
            collection = MongodbUtil.createCollection(housingEstate);
            document = collection.find(eq("phone", tUser.getMobile())).first();
            if (document == null) {
                logger.error("用户未登记不允许注册");
                throw new UserException(UserEnum.NO_REGISTER);
            }
        }

        MongodbUser mongodbUser = JSON.parseObject(document.toJson(), MongodbUser.class);

        Date date = new Date();
        tUser.setUsername(mongodbUser.getName());
        tUser.setMobile(mongodbUser.getPhone());
        tUser.setIdNumber(mongodbUser.getZjnum());
        tUser.setNickname("未填写");
        tUser.setIsRegister(Global.ONE_STRING);
        tUser.setCreateTime(date);
        tUser.setUpdateTime(date);
        int num = tUserDAO.insertSelective(tUser);
        logger.info("新增用户：" + tUser.toString());
        if (num < 1) {
            throw new UserException(UserEnum.FAIL);
        }

        TPcell tPcell = new TPcell();
        tPcell.setUid(tUser.getId());
        tPcell.setPcellNumber(housingEstate);
        tPcell.setCreateTime(date);
        tPcell.setUpdateTime(date);
        num = tPcellDAO.insertSelective(tPcell);
        logger.info("新增用户所在小区：" + tPcell.toString());
        if (num < 1) {
            throw new UserException(UserEnum.FAIL);
        }
        List<MongodbUser.RoomsBean> roomsBeans = mongodbUser.getRooms();
        TRoom                       tRoom;
        for (MongodbUser.RoomsBean roomsBean : roomsBeans) {
            tRoom = new TRoom();
            tRoom.setPcellId(tPcell.getId());
            tRoom.setRoomNumber(String.valueOf(roomsBean.getRoomnum()));
            tRoom.setRoomLeaseCategory(roomsBean.getLivetype());
            tRoom.setRoomTower(String.valueOf(roomsBean.getBuildingnum()));
            tRoom.setRoomUnit(String.valueOf(roomsBean.getUnitnum()));
            tRoomDAO.insertSelective(tRoom);
            logger.info("新增用户所在房间信息：" + tRoom.toString());
        }
        return tUser;
    }

    @Override
    public Map<String, Object> login(String mobile, String code) {

        TUser tUser = new TUser();
        tUser.setMobile(mobile);
        logger.info("向t_user表发起查询：查询条件" + tUser.toString());
        List<TUser> tUsers = tUserDAO.selectBySelective(tUser);
        if (tUsers.size() == 0) {
            tUser = insertSelective(tUser);
            tUsers.add(tUser);
        } else if (tUsers.size() > 1) {
            logger.error("手机号不唯一");
            throw new UserException(UserEnum.MOBILE_NOT_UNIQUE);
        } else if (tUsers.get(0).getIsDelete().equals(Global.ONE_STRING)) {
            logger.error("用户已删除");
            throw new UserException(UserEnum.DELETED);
        } else if (tUsers.get(0).getIsRegister().equals(Global.ZERO_STRING)) {
            logger.error("用户未注册");
            throw new UserException((UserEnum.UNREGISTERED));
        }

        boolean bool = false;
        if (Global.DEBUG) {
            bool = true;
        } else {
            String msgId = JedisUtil.Strings.get(Global.APPLICATION_NAME + mobile + ":msgId");
            logger.info("从缓存中获取msgid:" + msgId);
            if (StringUtil.isBlank(msgId)) {
                logger.error("验证码已超时");
                throw new UserException(UserEnum.VERIFICATION_CODE_TIMEOUT);
            }
            try {
                logger.info("发送验证信息判断验证码是否正确");
                ValidSMSResult validSMSResult = JpushSMSUtil.sendValidSMSCode(msgId, code);
                if (validSMSResult != null) {
                    bool = validSMSResult.getIsValid();
                }
            } catch (Exception e) {
                logger.error("验证码不正确");
                throw new UserException(UserEnum.VERIFICATION_FAILURE);
            }
        }

        String uuid = UuidUtil.creatUUID();
        logger.info("生成uuid：" + uuid);

        Map<String, Object> resultMap = new HashMap<>(16);
        if (bool) {
            String token = DigestUtils.md5Hex(Global.MD5_SALT + uuid).toUpperCase();
            logger.info("生成的md5,token：" + token);


            TPcell tPcell = new TPcell();
            tPcell.setUid(tUsers.get(0).getId());

            List<TPcell> tPcells = tPcellDAO.selectBySelective(tPcell);
            logger.info("向t_pcell表发起查询：查询条件" + tPcell.toString());

            if (tPcells.size() != 0) {
                List<TRoom> tRooms;
                TRoom       tRoom;
                for (TPcell pcell : tPcells) {
                    tRoom = new TRoom();
                    tRoom.setPcellId(pcell.getId());
                    logger.info("向t_room表发起查询：查询条件" + tRoom.toString());
                    tRooms = tRoomDAO.selectBySelective(tRoom);
                    if (tRooms.size() != 0) {
                        pcell.settRooms(tRooms);
                    }
                }
                tUsers.get(0).settPcells(tPcells);
            }

            resultMap.put("userInfo", tUsers.get(0));
            resultMap.put("token", token);
            resultMap.put("accountId", fluoritService.createAccountId(tUsers.get(0), token, uuid).getThirdPartyId());
            resultMap.put("uuid", uuid);

            JedisUtil.Strings.setEx(Global.LOGIN_VALID_TOKEN + token, token, 604800);
            logger.info("存储用户token到redis并设置7天有效期,token:" + token);

            JedisUtil.Strings.setEx(Global.USER_INFO + token, JSON.toJSONString(resultMap), 604800);
            logger.info("存储用户记录到redis并设置7天有效期");
        }
        return resultMap;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tUserDAO.deleteByPrimaryKey(id);
    }
}