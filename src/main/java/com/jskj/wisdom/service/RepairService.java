package com.jskj.wisdom.service;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.model.wisdom.SRepair;
import com.jskj.wisdom.vo.repair.RepairAddVo;
import com.jskj.wisdom.vo.repair.RepairFindVo;
import com.jskj.wisdom.vo.repair.RepairUpdateVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * //TODO
 * @date 2018-06-04 17:33 Mon
 */
public interface RepairService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(RepairAddVo record, double scale, MultipartFile[] imageFile);

    RepairFindVo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RepairUpdateVo record);

    PageInfo<RepairFindVo> selectBySelective(SRepair record, int pageNum, int pageSize);
}
