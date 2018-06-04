package com.jskj.wisdom.service;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.model.wisdom.SJournalism;
import com.jskj.wisdom.vo.journalism.JournalismFindVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * //TODO
 * @date 2018-06-04 16:55 Mon
 */
public interface JournalismService {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SJournalism record, double scale, MultipartFile[] imageFile);

    int updateByPrimaryKeySelective(SJournalism record);

    JournalismFindVo selectByPrimaryKey(Long id);

    List<JournalismFindVo> selectBySelective(SJournalism record);

    PageInfo<JournalismFindVo> selectBySelective(SJournalism record, int pageNum, int pageSize);
}
