//package com.jskj.wisdom.service;
//
//import com.github.pagehelper.PageInfo;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.Serializable;
//import java.util.List;
//
///**
// * Copyright © 2018 dragonSaberCaptain. All rights reserved.
// *
// * @author dragonSaberCaptain
// * @packageName com.jskj.wisdom.service
// * //TODO
// * @date 2018-06-05 09:57 星期二
// */
//public interface BaseService<T, ID> extends Serializable {
//
//    int insertSelective(T record, double scale, MultipartFile imageFile);
//
//    int deleteByPrimaryKey(ID id);
//
//    int updateByPrimaryKeySelective(T record);
//
//    T selectByPrimaryKey(ID id);
//
//    List<T> selectBySelective(T record);
//
//    PageInfo<T> selectBySelective(T record, int pageNum, int pageSize);
//}
