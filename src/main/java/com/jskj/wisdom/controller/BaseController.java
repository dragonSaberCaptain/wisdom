//package com.jskj.wisdom.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.github.pagehelper.PageInfo;
//import com.jskj.wisdom.enums.ResultEnum;
//import com.jskj.wisdom.service.BaseService;
//import com.jskj.wisdom.vo.ResultVo;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import java.io.Serializable;
//
///**
// * Copyright © 2018 dragonSaberCaptain. All rights reserved.
// *
// * @author dragonSaberCaptain
// * @packageName com.jskj.wisdom.controller
// * //TODO
// * @date 2018-06-05 10:23 星期二
// */
//@Controller
//@Api(value = "ComplaintController API", description = "投诉相关接口")
//public class BaseController<T, ID extends Serializable> {
//
//    private static final String URL_PATH = "complaint";
//
//    private static final String OBJECT_NAME = "测试";
//
//    @Resource
//    private BaseService<T, ID> baseService;
//
//    @PutMapping("/" + URL_PATH + "/addByParams")
//    @ApiOperation(value = "添加(按条件)", notes = "添加对象对应字段")
//    @ResponseBody
//    public ResultVo addByParams(@ApiParam(name = OBJECT_NAME + "对象 ", value = "传入json格式") T record,
//                                @RequestParam(value = "scale", defaultValue = "1", required = false) double scale,
//                                @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
//        int num = baseService.insertSelective(record, scale, imageFile);
//        if (num > 0) {
//            return new ResultVo(ResultEnum.OK);
//        }
//        return new ResultVo(ResultEnum.FAIL);
//    }
//
//
//    @DeleteMapping("/" + URL_PATH + "/deleteById")
//    @ApiOperation(value = "删除" + OBJECT_NAME + "信息(永久)", notes = "根据ID删除" + OBJECT_NAME + ",请谨慎处理")
//    @ResponseBody
//    public ResultVo deleteById(@RequestParam(value = "id") ID id) {
//        int num = baseService.deleteByPrimaryKey(id);
//        if (num > 0) {
//            return new ResultVo(ResultEnum.OK);
//        }
//        return new ResultVo(ResultEnum.FAIL);
//    }
//
//    @PostMapping("/" + URL_PATH + "/updateByParams")
//    @ApiOperation(value = "更新" + OBJECT_NAME + "信息 (按条件)", notes = "根据ID修改对应字段(必须含ID）")
//    @ResponseBody
//    public ResultVo updateByParams(@ApiParam(name = OBJECT_NAME + "对象 ", value = "传入json格式") T record) {
//        int num = baseService.updateByPrimaryKeySelective(record);
//        if (num > 0) {
//            return new ResultVo(ResultEnum.OK);
//        }
//        return new ResultVo(ResultEnum.FAIL);
//    }
//
//    @GetMapping("/" + URL_PATH + "/findById")
//    @ApiOperation(value = "获取" + OBJECT_NAME + "信息", notes = "根据ID查询")
//    @ResponseBody
//    public ResultVo findById(@RequestParam(value = "id") ID id) {
//        T record = baseService.selectByPrimaryKey(id);
//        if (record != null) {
//            return new ResultVo(ResultEnum.OK, record);
//        }
//        return new ResultVo(ResultEnum.FAIL);
//    }
//
//}
