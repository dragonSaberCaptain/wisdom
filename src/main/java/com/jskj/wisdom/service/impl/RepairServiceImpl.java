package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.SRepairDAO;
import com.jskj.wisdom.model.wisdom.PPictures;
import com.jskj.wisdom.model.wisdom.SRepair;
import com.jskj.wisdom.service.PicturesService;
import com.jskj.wisdom.service.RepairService;
import com.jskj.wisdom.vo.repair.RepairAddVo;
import com.jskj.wisdom.vo.repair.RepairFindVo;
import com.jskj.wisdom.vo.repair.RepairUpdateVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * //TODO
 * @date 2018-06-04 17:34 Mon
 */
@Service
public class RepairServiceImpl implements RepairService {

    @Resource
    private SRepairDAO sRepairDAO;

    @Resource
    private PicturesService picturesService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sRepairDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(RepairAddVo record, double scale, MultipartFile[] imageFile) {
        SRepair sRepair = record.voToDao(record);
        int     num     = sRepairDAO.insertSelective(sRepair);
        if (num > 0) {
            PPictures pPictures = new PPictures();
            pPictures.setUserId(record.getUserId());
            pPictures.setPicTypeId(sRepair.getId());
            pPictures.setPicType(Global.REPAIR_PICTURE);
            picturesService.insertSelective(pPictures, scale, imageFile);
        }
        return num;
    }

    @Override
    public RepairFindVo selectByPrimaryKey(Long id) {
        RepairFindVo repairFindVo = RepairFindVo.daoToVo(sRepairDAO.selectByPrimaryKey(id));
        return findPic(repairFindVo);
    }

    @Override
    public int updateByPrimaryKeySelective(RepairUpdateVo record) {
        return sRepairDAO.updateByPrimaryKeySelective(record.voToDao(record));
    }

    @Override
    public PageInfo<RepairFindVo> selectBySelective(SRepair record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "update_time desc");
        List<SRepair>      sRepairs      = sRepairDAO.selectBySelective(record);
        List<RepairFindVo> repairFindVos = RepairFindVo.daoToVo(sRepairs);
        return new PageInfo<>(findPic(repairFindVos));
    }

    private List<RepairFindVo> findPic(List<RepairFindVo> repairFindVos) {
        PPictures       pPictures;
        List<String>    picPaths;
        List<PPictures> pPictures1;
        for (RepairFindVo repairFindVo : repairFindVos) {
            picPaths = new LinkedList<>();
            pPictures = new PPictures();

            pPictures.setPicType(Global.REPAIR_PICTURE);
            pPictures.setPicTypeId(repairFindVo.getId());
            pPictures1 = picturesService.selectBySelective(pPictures);
            for (PPictures pictures : pPictures1) {
                picPaths.add(pictures.getPicPath());
            }
            repairFindVo.setPicPaths(picPaths);
        }
        return repairFindVos;
    }

    private RepairFindVo findPic(RepairFindVo repairFindVo) {
        List<String>    picPaths;
        PPictures       pPictures;
        List<PPictures> pPictures1;
        if (repairFindVo != null) {
            pPictures = new PPictures();
            picPaths = new LinkedList<>();
            pPictures.setPicType(Global.REPAIR_PICTURE);
            pPictures.setPicTypeId(repairFindVo.getId());
            pPictures1 = picturesService.selectBySelective(pPictures);
            for (PPictures pictures : pPictures1) {

                picPaths.add(pictures.getPicPath());
            }
            repairFindVo.setPicPaths(picPaths);
        }
        return repairFindVo;
    }
}
