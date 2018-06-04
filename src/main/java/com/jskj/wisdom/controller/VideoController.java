package com.jskj.wisdom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.dto.ResultDto;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.model.wisdom.SVideo;
import com.jskj.wisdom.service.VideoService;
import com.jskj.wisdom.vo.video.VideoFindVo;
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
 * @description
 * @date 2018-05-10 13:12 星期四
 */
@Controller
@Api(value = "VideoController API", description = "视频相关接口")
public class VideoController {
    @Resource
    private VideoService videoService;

    @GetMapping("/video/findByParams")
    @ApiOperation(value = "获取视频(按条件分页)", notes = "根据小区id获取放列列表(视频地址和预览图)")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<PageInfo<VideoFindVo>> findByParams(
            @RequestParam(value = "searchParams", required = false) String searchParams,
            @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {

        SVideo sVideo = JSON.parseObject(searchParams, SVideo.class);

        PageInfo<VideoFindVo> recordPageInfo = videoService.selectBySelective(sVideo, pageNum, pageSize);
        if (recordPageInfo.getSize() > 0) {
            return new ResultDto<>(ResultEnum.OK, recordPageInfo);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }


    @GetMapping("/video/findById")
    @ApiOperation(value = "获取视频", notes = "根据视频id获取播放列列表(视频地址和预览图)")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<VideoFindVo> findById(@RequestParam(name = "id") Long id) {
        VideoFindVo record = videoService.selectByPrimaryKey(id);
        if (record != null) {
            return new ResultDto<>(ResultEnum.OK, record);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @PutMapping("/video/addByParams")
    @ApiOperation(value = "添加视频(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<SVideo> addByParams(@ApiParam(name = "视频对象 ", value = "传入json格式", required = true) SVideo sVideo,
                                         @RequestParam(value = "scale") double scale,
                                         @RequestParam(value = "imageFile") MultipartFile[] imageFile) {
        int num = videoService.insertSelective(sVideo, scale, imageFile);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @PostMapping("/video/updateByParams")
    @ApiOperation(value = "更新视频(按条件)", notes = "根据ID修改对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 1003, message = "更新失败,视频不存在或id不正确"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<SVideo> updateByParams(@RequestBody @ApiParam(name = "视频对象 ", value = "传入json格式", required = true) SVideo sVideo) {
        int num = videoService.updateByPrimaryKeySelective(sVideo);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @DeleteMapping("/video/deleteById")
    @ApiOperation(value = "删除视频(永久)", notes = "根据ID删除,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto deleteById(@RequestParam(name = "id") Long id) {
        int num = videoService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new ResultDto(ResultEnum.OK);
        }
        return new ResultDto(ResultEnum.FAIL);
    }
}
