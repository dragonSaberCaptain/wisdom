package com.jskj.wisdom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.dto.ResultDto;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.model.wisdom.SNotice;
import com.jskj.wisdom.service.NoticeService;
import com.jskj.wisdom.vo.notice.NoticeFindVo;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.controller
 * //TODO
 * @date 2018-05-28 09:58 星期一
 */
@Controller
@Api(value = "NoticeController API", description = "公告相关接口")
public class NoticeController {
    @Resource
    private NoticeService noticeService;


    @DeleteMapping("/notice/deleteById")
    @ApiOperation(value = "删除公告(永久)", notes = "根据ID删除公告,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto deleteById(@RequestParam(value = "id") Long id) {
        int num = noticeService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new ResultDto(ResultEnum.OK);
        }
        return new ResultDto(ResultEnum.FAIL);
    }

    @PutMapping("/notice/addByParams")
    @ApiOperation(value = "添加公告(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<SNotice> addByParams(@ApiParam(name = "公告对象 ", value = "传入json格式") SNotice record,
                                          @RequestParam(value = "scale", defaultValue = "1", required = false) double scale,
                                          @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
        int num = noticeService.insertSelective(record, scale, imageFile);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);

    }

    @GetMapping("/notice/findById")
    @ApiOperation(value = "获取公告", notes = "根据ID查询")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<NoticeFindVo> findById(@RequestParam(value = "id") Long id) {
        NoticeFindVo noticeFindVo = noticeService.selectByPrimaryKey(id);
        if (noticeFindVo != null) {
            return new ResultDto<>(ResultEnum.OK, noticeFindVo);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/notice/findByParams")
    @ApiOperation(value = "获取公告(按条件分页)", notes = "根据条件分页查询")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<PageInfo<NoticeFindVo>> findByParams(@RequestParam(value = "searchParams", required = false) String searchParams,
                                                          @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                                          @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {
        SNotice                sNotice              = JSON.parseObject(searchParams, SNotice.class);
        PageInfo<NoticeFindVo> noticeFindVoPageInfo = noticeService.selectBySelective(sNotice, pageNum, pageSize);
        if (noticeFindVoPageInfo.getSize() > 0) {
            return new ResultDto<>(ResultEnum.OK, noticeFindVoPageInfo);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @PostMapping("/notice/updateByParams")
    @ApiOperation(value = "更新公告 (按条件)", notes = "根据ID修改对应字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<SNotice> updateByParams(@RequestBody @ApiParam(name = "公告对象 ", value = "传入json格式") SNotice record) {
        int num = noticeService.updateByPrimaryKeySelective(record);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);

    }

    @GetMapping("/notice/findNewest")
    @ApiOperation(value = "获取最新公告信息", notes = "获取最新的公告信息")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<List<NoticeFindVo>> findNewest(@RequestParam(name = "topNum", required = false, defaultValue = "1") int topNum) {
        List<NoticeFindVo> noticeFindVos = noticeService.selectByUpdateTime(topNum);
        if (noticeFindVos.size() > 0) {
            return new ResultDto<>(ResultEnum.OK, noticeFindVos);
        }
        return new ResultDto<>(ResultEnum.FAIL);

    }

}
