//package com.jskj.wisdom.service.impl;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.jskj.wisdom.dao.BaseDao;
//import com.jskj.wisdom.service.BaseService;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import java.io.Serializable;
//import java.util.List;
//
///**
// * Copyright © 2018 dragonSaberCaptain. All rights reserved.
// *
// * @author dragonSaberCaptain
// * @packageName com.jskj.wisdom.service
// * //TODO
// * @date 2018-06-05 09:59 星期二
// */
//public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {
//    @Resource
//    private BaseDao<T, ID> baseDao;
//
////    public abstract BaseDao<T, ID> getDao();
//
//    @Override
//    public int insertSelective(T record, double scale, MultipartFile imageFile) {
//        return baseDao.insertSelective(record);
//    }
//
//    @Override
//    public int deleteByPrimaryKey(ID id) {
//        return baseDao.deleteByPrimaryKey(id);
//    }
//
//    @Override
//    public int updateByPrimaryKeySelective(T record) {
//        return baseDao.updateByPrimaryKeySelective(record);
//    }
//
//    @Override
//    public T selectByPrimaryKey(ID id) {
//        return baseDao.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public List<T> selectBySelective(T record) {
//        return baseDao.selectBySelective(record);
//    }
//
//    @Override
//    public PageInfo<T> selectBySelective(T record, int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum - 1, pageSize);
//        List<T> lists = selectBySelective(record);
//        return new PageInfo<>(lists);
//    }
//}
