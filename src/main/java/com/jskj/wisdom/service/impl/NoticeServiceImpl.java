package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.SNoticeDAO;
import com.jskj.wisdom.model.wisdom.PPictures;
import com.jskj.wisdom.model.wisdom.SNotice;
import com.jskj.wisdom.service.NoticeService;
import com.jskj.wisdom.service.PicturesService;
import com.jskj.wisdom.vo.notice.NoticeFindVo;
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
 * //TODO
 * @date 2018-05-28 09:42 星期一
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private SNoticeDAO sNoticeDAO;

    @Resource
    private PicturesService picturesService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sNoticeDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SNotice record, double scale, MultipartFile imageFile) {
        Date date = new Date();
        record.setUpdateTime(date);
        record.setCreateTime(date);
        int num = sNoticeDAO.insertSelective(record);
        if (num > 0) {
            PPictures pPictures = new PPictures();
            pPictures.setPicTypeId(record.getId());
            pPictures.setPicType(Global.NOTICE_PICTURE);
            picturesService.insertSelective(pPictures, scale, imageFile);
        }
        return num;
    }

    @Override
    public NoticeFindVo selectByPrimaryKey(Long id) {
        return findPic(NoticeFindVo.daoToVo(sNoticeDAO.selectByPrimaryKey(id)));
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
    public PageInfo<NoticeFindVo> selectBySelective(SNotice record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum - 1, pageSize);
        List<SNotice>      sNotices      = sNoticeDAO.selectBySelective(record);
        List<NoticeFindVo> noticeFindVos = NoticeFindVo.daoToVo(sNotices);
        return new PageInfo<>(findPic(noticeFindVos));
    }

    @Override
    public List<NoticeFindVo> selectByUpdateTime(Integer topNum) {
        return findPic(NoticeFindVo.daoToVo(sNoticeDAO.selectByUpdateTime(topNum)));
    }

    private List<NoticeFindVo> findPic(List<NoticeFindVo> noticeFindVos) {
        PPictures       pPictures;
        List<String>    picPaths;
        List<PPictures> pPictures1;
        for (NoticeFindVo noticeFindVo : noticeFindVos) {
            picPaths = new LinkedList<>();
            pPictures = new PPictures();

            pPictures.setPicType(Global.NOTICE_PICTURE);
            pPictures.setPicTypeId(noticeFindVo.getId());
            pPictures1 = picturesService.selectBySelective(pPictures);
            for (PPictures pictures : pPictures1) {
                picPaths.add(pictures.getPicPath());
            }
            noticeFindVo.setPicPaths(picPaths);
        }
        return noticeFindVos;
    }

    private NoticeFindVo findPic(NoticeFindVo noticeFindVo) {
        List<String>    picPaths;
        PPictures       pPictures;
        List<PPictures> pPictures1;
        if (noticeFindVo != null) {
            pPictures = new PPictures();
            picPaths = new LinkedList<>();
            pPictures.setPicType(Global.NOTICE_PICTURE);
            pPictures.setPicTypeId(noticeFindVo.getId());
            pPictures1 = picturesService.selectBySelective(pPictures);
            for (PPictures pictures : pPictures1) {
                picPaths.clear();
                picPaths.add(pictures.getPicPath());
            }
            noticeFindVo.setPicPaths(picPaths);
        }
        return noticeFindVo;
    }
}
