package com.jskj.wisdom.service;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.model.wisdom.SComplaint;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * //TODO
 * @date 2018-06-05 09:00 星期二
 */
public interface ComplaintService {

    int insertSelective(SComplaint record, double scale, MultipartFile[] imageFile);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SComplaint record);

    SComplaint selectByPrimaryKey(Long id);

    List<SComplaint> selectBySelective(SComplaint record);

    PageInfo<SComplaint> selectBySelective(SComplaint record, int pageNum, int pageSize);

}
