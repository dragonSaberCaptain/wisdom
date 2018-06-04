package com.jskj.wisdom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.dto.ResultDto;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.model.wisdom.PPictures;
import com.jskj.wisdom.service.PicturesService;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.controller
 * //TODO
 * @date 2018-06-05 14:42 星期二
 */
@Controller
@Api(value = "PicturesController API", description = "图片相关接口")
public class PicturesController {
    @Resource
    private PicturesService picturesService;

    @DeleteMapping("/picture/deleteById")
    @ApiOperation(value = "删除图片(永久)", notes = "根据ID删除图片,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto deleteById(@RequestParam(value = "id") Long id) {
        int num = picturesService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new ResultDto(ResultEnum.OK);
        }
        return new ResultDto(ResultEnum.FAIL);
    }

    @PutMapping("/picture/addByParams")
    @ApiOperation(value = "添加图片(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<PPictures> addByParams(@ApiParam(name = "图片对象 ", value = "传入json格式") PPictures record,
                                            @RequestParam(value = "scale", defaultValue = "1", required = false) double scale,
                                            @RequestParam(value = "imageFile", required = false) MultipartFile[] imageFile) {
        int num = picturesService.insertSelective(record, scale, imageFile);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/picture/findById")
    @ApiOperation(value = "获取图片", notes = "根据ID查询")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<PPictures> findById(@RequestParam(value = "id") Long id) {
        PPictures record = picturesService.selectByPrimaryKey(id);
        if (record != null) {
            return new ResultDto<>(ResultEnum.OK, record);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/picture/findByParams")
    @ApiOperation(value = "获取图片(按条件分页)", notes = "根据条件查询并分页")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<PageInfo<PPictures>> findByParams(@RequestParam(value = "searchParams", required = false) String searchParams,
                                                       @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                                       @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {

        PPictures record = JSON.parseObject(searchParams, PPictures.class);

        PageInfo<PPictures> pPicturesPageInfo = picturesService.selectBySelective(record, pageNum, pageSize);
        if (pPicturesPageInfo.getSize() > 0) {
            return new ResultDto<>(ResultEnum.OK, pPicturesPageInfo);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @PostMapping("/picture/updateByParams")
    @ApiOperation(value = "更新图片 (按条件)", notes = "根据ID修改对应字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<PPictures> updateByParams(@ApiParam(name = "图片对象 ", value = "传入json格式") PPictures record) {
        int num = picturesService.updateByPrimaryKeySelective(record);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }


}
