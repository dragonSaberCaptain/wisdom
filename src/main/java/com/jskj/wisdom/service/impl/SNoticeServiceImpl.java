package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.SNoticeDAO;
import com.jskj.wisdom.model.SNotice;
import com.jskj.wisdom.service.SNoticeService;
import com.jskj.wisdom.utils.string.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * //TODO
 * @date 2018-05-28 09:42 星期一
 */
@Service
public class SNoticeServiceImpl implements SNoticeService {
    @Resource
    private SNoticeDAO sNoticeDAO;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sNoticeDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SNotice record) {
        Date date = new Date();
        record.setUpdateTime(date);
        record.setCreateTime(date);
        return sNoticeDAO.insertSelective(record);
    }

    @Override
    public SNotice selectByPrimaryKey(Long id) {
        return sNoticeDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SNotice record) {
        record.setUpdateTime(new Date());
        return sNoticeDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SNotice> selectBySelective(SNotice record) {
        return sNoticeDAO.selectBySelective(record);
    }

    @Override
    public PageInfo<SNotice> selectBySelective(SNotice record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum - 1, pageSize);
        List<SNotice> sNotices = selectBySelective(record);

        String result;

        for (SNotice sNotice : sNotices) {
            if (StringUtil.isBlank(sNotice.getNoticePath())) {
                continue;
            }
            result = "http://" + Global.HTTP_HOST_POST + "/open/getPic?source=" + sNotice.getNoticePath() + "&scale=0.5&format=jpg";
            sNotice.setNoticePath(result);
        }
        return new PageInfo<>(sNotices);
    }
}
