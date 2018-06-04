package com.jskj.wisdom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dao.PPicturesDAO;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.model.wisdom.PPictures;
import com.jskj.wisdom.service.PicturesService;
import com.jskj.wisdom.utils.pic.PicUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * //TODO
 * @date 2018-06-05 11:30 星期二
 */
@Service
public class PicturesServiceImpl implements PicturesService {
    @Resource
    private PPicturesDAO pPicturesDAO;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pPicturesDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PPictures record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return pPicturesDAO.insertSelective(record);
    }

    @Override
    public int insertSelective(PPictures record, double scale, MultipartFile[] imageFile) {
        int num = 0;
        if (imageFile != null) {
            for (MultipartFile multipartFile : imageFile) {
                num = insertSelective(record, scale, multipartFile);
            }
        }
        return num;
    }

    @Override
    public int insertSelective(PPictures record, double scale, MultipartFile imageFile) {
        String url;
        if (imageFile != null) {
            if (imageFile.getSize() >= Global.FILE_SIZE) {
                record.setRemark(ResultEnum.FILE_TOO_BIG.getMsg());
            } else {
                PPictures pPictures = new PPictures();
                String    fileHash  = PicUtil.getFileHash(imageFile);

                pPictures.setFileHash(fileHash);
                List<PPictures> pPicturesList = pPicturesDAO.selectBySelective(pPictures);
                if (pPicturesList.size() > 0) {
                    record.setPicPath(pPicturesList.get(0).getPicPath());
                    record.setPicHost(Global.HOST);
                    record.setPicPort(Global.PORT);
                    record.setRemark("急速秒传");
                    record.setInterfacePrefix(Global.PIC_INTERFACE_PREFIX);
                } else {
                    url = PicUtil.savePic(Global.PIC_PREFIX, record.getPicType(), imageFile, scale);
                    record.setPicPath(url);
                    record.setPicHost(Global.HOST);
                    record.setPicPort(Global.PORT);
                    record.setFileHash(fileHash);
                    record.setInterfacePrefix(Global.PIC_INTERFACE_PREFIX);
                    record.setRemark("原始图片");
                }
            }
        }
        return insertSelective(record);
    }

    @Override
    public PPictures selectByPrimaryKey(Long id) {
        return pPicturesDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PPictures record) {
        record.setUpdateTime(new Date());
        return pPicturesDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<PPictures> selectBySelective(PPictures record) {
        List<PPictures> pPicturesList = pPicturesDAO.selectBySelective(record);

        StringBuffer stringBuffer;

        boolean bool = false;

        PPictures pictures;
        for (PPictures pPictures : pPicturesList) {
            pictures = new PPictures();

            if (!Global.HOST.equals(pPictures.getPicHost())) {
                pictures.setPicHost(Global.HOST);
                bool = true;
            }
            if (!Global.PORT.equals(pPictures.getPicPort())) {
                pictures.setPicPort(Global.PORT);
                bool = true;
            }
            if (!Global.PIC_INTERFACE_PREFIX.equals(pPictures.getInterfacePrefix())) {
                pictures.setInterfacePrefix(Global.PIC_INTERFACE_PREFIX);
                bool = true;
            }
            stringBuffer = new StringBuffer();
            stringBuffer.append(Global.HTTP)
                    .append(Global.HOST)
                    .append(":")
                    .append(Global.PORT)
                    .append(Global.PIC_INTERFACE_PREFIX)
                    .append(pPictures.getPicType())
                    .append(pPictures.getPicPath());
            pPictures.setPicPath(stringBuffer.toString());
            if (bool) {
                pictures.setUpdateTime(new Date());
                pictures.setId(pPictures.getId());
                pPicturesDAO.updateByPrimaryKeySelective(pictures);
                bool = false;
            }
        }
        return pPicturesList;
    }

    @Override
    public PageInfo<PPictures> selectBySelective(PPictures record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum - 1, pageSize);
        List<PPictures> sComplaints = selectBySelective(record);
        return new PageInfo<>(sComplaints);
    }
}
