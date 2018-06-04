package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.SJournalismDAO;
import com.jskj.wisdom.model.wisdom.PPictures;
import com.jskj.wisdom.model.wisdom.SJournalism;
import com.jskj.wisdom.service.JournalismService;
import com.jskj.wisdom.service.PicturesService;
import com.jskj.wisdom.vo.journalism.JournalismFindVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * //新闻相关
 * @date 2018-06-04 16:58 Mon
 */
@Service
public class JournalismServiceImpl implements JournalismService {
    @Resource
    private SJournalismDAO sJournalismDAO;

    @Resource
    private PicturesService picturesService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sJournalismDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SJournalism record, double scale, MultipartFile[] imageFile) {
        Date date = new Date();
        record.setUpdateTime(date);
        record.setCreateTime(date);

        int num = sJournalismDAO.insertSelective(record);
        if (num > 0) {
            PPictures pPictures = new PPictures();
            pPictures.setPicTypeId(record.getId());
            pPictures.setPicType(Global.JOURNALISM_PICTURE);
            num = picturesService.insertSelective(pPictures, scale, imageFile);
        }
        return num;
    }

    @Override
    public int updateByPrimaryKeySelective(SJournalism record) {
        Date date = new Date();
        record.setUpdateTime(date);
        return sJournalismDAO.updateByPrimaryKeySelective(record);
    }


    @Override
    public JournalismFindVo selectByPrimaryKey(Long id) {
        return findPic(JournalismFindVo.daoToVo(sJournalismDAO.selectByPrimaryKey(id)));
    }

    @Override
    public List<JournalismFindVo> selectBySelective(SJournalism record) {
        return findPic(JournalismFindVo.daoToVo(sJournalismDAO.selectBySelective(record)));
    }

    @Override
    public PageInfo<JournalismFindVo> selectBySelective(SJournalism record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum - 1, pageSize);
        List<JournalismFindVo> journalismFindVos = JournalismFindVo.daoToVo(sJournalismDAO.selectBySelective(record));
        return new PageInfo<>(findPic(journalismFindVos));
    }

    private List<JournalismFindVo> findPic(List<JournalismFindVo> recordVos) {
        PPictures    pPictures;
        List<String> picPaths;
        for (JournalismFindVo recordVo : recordVos) {
            picPaths = new LinkedList<>();
            pPictures = new PPictures();

            pPictures.setPicType(Global.JOURNALISM_PICTURE);
            pPictures.setPicTypeId(recordVo.getId());
            List<PPictures> pPictures1 = picturesService.selectBySelective(pPictures);
            for (PPictures pictures : pPictures1) {
                picPaths.clear();
                picPaths.add(pictures.getPicPath());
            }
            recordVo.setPicPaths(picPaths);
        }
        return recordVos;
    }

    private JournalismFindVo findPic(JournalismFindVo recordVo) {
        List<String> picPaths;
        PPictures    pPictures;
        if (recordVo != null) {
            pPictures = new PPictures();
            picPaths = new LinkedList<>();
            pPictures.setPicType(Global.JOURNALISM_PICTURE);
            pPictures.setPicTypeId(recordVo.getId());
            List<PPictures> pPictures1 = picturesService.selectBySelective(pPictures);
            for (PPictures pictures : pPictures1) {
                picPaths.clear();
                picPaths.add(pictures.getPicPath());
            }
            recordVo.setPicPaths(picPaths);
        }
        return recordVo;
    }
}
