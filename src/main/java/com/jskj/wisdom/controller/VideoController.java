package com.jskj.wisdom.controller;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.enums.VideoEnum;
import com.jskj.wisdom.model.SVideo;
import com.jskj.wisdom.service.SVideoService;
import com.jskj.wisdom.utils.pic.ThumbnailatorUtil;
import com.jskj.wisdom.vo.VideoVo;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
    @ApiOperation(value = "获取视频(按条件)", notes = "根据查询条件获取放列列表(视频地址和预览图)")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public VideoVo getVideosBySelective(
            @RequestParam(value = "pid") Long pid,
            @RequestParam(value = "picToBase64", defaultValue = "false", required = false) boolean picToBase64,
            @RequestParam(name = "pageNum", defaultValue = "1", required = false) String pageNum,
            @RequestParam(name = "pageSize", defaultValue = "30", required = false) String pageSize) {
        PageInfo<SVideo> tUserPageInfo = sVideoService.selectBySelective(pid, picToBase64, pageNum, pageSize);
        if (tUserPageInfo.getSize() > 0) {
            return new VideoVo(VideoEnum.OK, tUserPageInfo);
        }
        return new VideoVo(VideoEnum.FAIL);
    }


    @GetMapping("/video/getVideoById")
    @ApiOperation(value = "获取视频", notes = "根据视频id获取播放列列表(视频地址和预览图)")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public VideoVo getVideoById(@RequestParam(name = "id") Long id) {
        SVideo sVideo = sVideoService.selectByPrimaryKey(id);
        if (sVideo != null) {
            return new VideoVo(VideoEnum.OK, sVideo);
        }
        return new VideoVo(VideoEnum.FAIL);
    }


    @PutMapping(value = "/video/insertVideo", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "添加视频", notes = "添加对象所有字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public VideoVo insertVideo(
            @RequestParam(value = "pid") Long pid,
            @RequestParam(value = "videoPathUrl") String videoPathUrl,
            @RequestParam(value = "scale") double scale,
            @RequestParam(value = "imageFile") MultipartFile imageFile) {
        int num = sVideoService.insert(pid, videoPathUrl, scale, imageFile);
        if (num > 0) {
            return new VideoVo(VideoEnum.OK);
        }
        return new VideoVo(VideoEnum.FAIL);
    }

    @PutMapping("/video/insertVideoBySelective")
    @ApiOperation(value = "添加视频(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public VideoVo insertVideoBySelective(@RequestBody @ApiParam(name = "视频对象 ", value = "传入json格式", required = true) SVideo sVideo) {
        int num = sVideoService.insertSelective(sVideo);
        if (num > 0) {
            return new VideoVo(VideoEnum.OK);
        }
        return new VideoVo(VideoEnum.FAIL);
    }


    @PostMapping("/video/updateVideo")
    @ApiOperation(value = "更新视频", notes = "根据ID修改所有字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 1003, message = "更新失败,视频不存在或id不正确"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public VideoVo updateVideo(@RequestBody @ApiParam(name = "视频对象 ", value = "传入json格式", required = true) SVideo sVideo) {
        int num = sVideoService.updateByPrimaryKey(sVideo);
        if (num > 0) {
            return new VideoVo(VideoEnum.OK);
        }
        return new VideoVo(VideoEnum.FAIL);
    }

    @PostMapping("/video/updateVideoBySelective")
    @ApiOperation(value = "更新视频(按条件)", notes = "根据ID修改对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 1003, message = "更新失败,视频不存在或id不正确"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public VideoVo updateVideoBySelective(@RequestBody @ApiParam(name = "视频对象 ", value = "传入json格式", required = true) SVideo sVideo) {
        int num = sVideoService.updateByPrimaryKeySelective(sVideo);
        if (num > 0) {
            return new VideoVo(VideoEnum.OK);
        }
        return new VideoVo(VideoEnum.FAIL);
    }

    @DeleteMapping("/video/deleteVideo")
    @ApiOperation(value = "删除视频(永久)", notes = "根据ID删除,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public VideoVo deleteVideo(@RequestParam(name = "id") Long id) {
        int num = sVideoService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new VideoVo(VideoEnum.OK);
        }
        return new VideoVo(VideoEnum.FAIL);
    }

    @GetMapping("/open/getPic")
    @ApiOperation(value = "获取图片", notes = "通过传入的图片地址、输出大小为缩放比例（0.1f~1f之间）、格式的图片")
    public void getPic(@RequestParam(name = "source") String source, @RequestParam(name = "scale") double scale, @RequestParam(name = "format") String format, HttpServletResponse response) {
        ThumbnailatorUtil.ImgBufferedImage(Global.VIDEO_PICTURE_PATH + source, response, scale, format);
    }
}
