package com.jskj.wisdom.service.impl;

import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.TRoomDAO;
import com.jskj.wisdom.model.TRoom;
import com.jskj.wisdom.service.TRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * @description
 * @date 2018-05-09 10:27 星期三
 */
@Service
public class TRoomServiceImpl implements TRoomService {
    @Resource
    private TRoomDAO tRoomDAO;

    @Override
    public List<TRoom> selectBySelective(TRoom tRoom) {
        if (tRoom != null) {
            tRoom.setIsDelete(Global.ZERO_STRING);
        }
        return tRoomDAO.selectBySelective(tRoom);
    }
}
