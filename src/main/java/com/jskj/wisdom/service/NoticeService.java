package com.jskj.wisdom.service;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.model.wisdom.SNotice;
import com.jskj.wisdom.vo.notice.NoticeFindVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * //TODO
 * @date 2018-05-28 09:42 星期一
 */
public interface NoticeService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(SNotice record, double scale, MultipartFile imageFile);

    NoticeFindVo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SNotice record);

    List<SNotice> selectBySelective(SNotice record);

    PageInfo<NoticeFindVo> selectBySelective(SNotice record, int pageNum, int pageSize);

    List<NoticeFindVo> selectByUpdateTime(Integer topNum);
}
