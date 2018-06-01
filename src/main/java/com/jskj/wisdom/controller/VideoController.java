package com.jskj.wisdom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.model.SVideo;
import com.jskj.wisdom.service.SVideoService;
import com.jskj.wisdom.vo.ResultVo;
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
    private SVideoService sVideoService;

    @GetMapping("/video/getVideosBySelective")
    @ApiOperation(value = "获取视频(按条件分页)", notes = "根据小区id获取放列列表(视频地址和预览图)")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultVo getVideosBySelective(
            @RequestParam(value = "searchParams", required = false) String searchParams,
            @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {

        SVideo sVideo = JSON.parseObject(searchParams, SVideo.class);

        PageInfo<SVideo> tUserPageInfo = sVideoService.selectBySelective(sVideo, pageNum, pageSize);
        if (tUserPageInfo.getSize() > 0) {
            return new ResultVo(ResultEnum.OK, tUserPageInfo);
        }
        return new ResultVo(ResultEnum.FAIL);
    }


    @GetMapping("/video/getVideoById")
    @ApiOperation(value = "获取视频", notes = "根据视频id获取播放列列表(视频地址和预览图)")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultVo getVideoById(@RequestParam(name = "id") Long id) {
        SVideo sVideo = sVideoService.selectByPrimaryKey(id);
        if (sVideo != null) {
            return new ResultVo(ResultEnum.OK, sVideo);
        }
        return new ResultVo(ResultEnum.FAIL);
    }


    @PutMapping(value = "/video/insertVideo")
    @ApiOperation(value = "添加视频", notes = "添加对象所有字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    @Deprecated
    public ResultVo insertVideo(
            @ApiParam(name = "视频对象 ", value = "传入json格式", required = true) SVideo sVideo,
            @RequestParam(value = "scale") double scale,
            @RequestParam(value = "imageFile") MultipartFile imageFile) {
        int num = sVideoService.insert(sVideo, scale, imageFile);
        if (num > 0) {
            return new ResultVo(ResultEnum.OK);
        }
        return new ResultVo(ResultEnum.FAIL);
    }

    @PutMapping("/video/insertVideoBySelective")
    @ApiOperation(value = "添加视频(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultVo insertVideoBySelective(@ApiParam(name = "视频对象 ", value = "传入json格式", required = true) SVideo sVideo,
                                           @RequestParam(value = "scale") double scale,
                                           @RequestParam(value = "imageFile") MultipartFile imageFile) {
        int num = sVideoService.insertSelective(sVideo, scale, imageFile);
        if (num > 0) {
            return new ResultVo(ResultEnum.OK);
        }
        return new ResultVo(ResultEnum.FAIL);
    }


    @PostMapping("/video/updateVideo")
    @ApiOperation(value = "更新视频", notes = "根据ID修改所有字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 1003, message = "更新失败,视频不存在或id不正确"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    @Deprecated
    public ResultVo updateVideo(@RequestBody @ApiParam(name = "视频对象 ", value = "传入json格式", required = true) SVideo sVideo) {
        int num = sVideoService.updateByPrimaryKey(sVideo);
        if (num > 0) {
            return new ResultVo(ResultEnum.OK);
        }
        return new ResultVo(ResultEnum.FAIL);
    }

    @PostMapping("/video/updateVideoBySelective")
    @ApiOperation(value = "更新视频(按条件)", notes = "根据ID修改对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 1003, message = "更新失败,视频不存在或id不正确"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultVo updateVideoBySelective(@RequestBody @ApiParam(name = "视频对象 ", value = "传入json格式", required = true) SVideo sVideo) {
        int num = sVideoService.updateByPrimaryKeySelective(sVideo);
        if (num > 0) {
            return new ResultVo(ResultEnum.OK);
        }
        return new ResultVo(ResultEnum.FAIL);
    }

    @DeleteMapping("/video/deleteVideoById")
    @ApiOperation(value = "删除视频(永久)", notes = "根据ID删除,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultVo deleteVideoById(@RequestParam(name = "id") Long id) {
        int num = sVideoService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new ResultVo(ResultEnum.OK);
        }
        return new ResultVo(ResultEnum.FAIL);
    }
}
