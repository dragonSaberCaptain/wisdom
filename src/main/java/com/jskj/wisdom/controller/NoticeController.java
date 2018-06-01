package com.jskj.wisdom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.model.SNotice;
import com.jskj.wisdom.service.SNoticeService;
import com.jskj.wisdom.vo.ResultVo;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    private SNoticeService sNoticeService;


    @DeleteMapping("/notice/deleteByPrimaryKey")
    @ApiOperation(value = "删除公告(永久)", notes = "根据ID删除公告,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultVo deleteByPrimaryKey(@RequestParam(value = "id") Long id) {
        int num = sNoticeService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new ResultVo(ResultEnum.OK);
        }
        return new ResultVo(ResultEnum.FAIL);
    }

    @PutMapping("/notice/insertSelective")
    @ApiOperation(value = "添加公告(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultVo insertSelective(@RequestBody @ApiParam(name = "公告对象 ", value = "传入json格式") SNotice record) {
        int num = sNoticeService.insertSelective(record);
        if (num > 0) {
            return new ResultVo(ResultEnum.OK);
        }
        return new ResultVo(ResultEnum.FAIL);

    }

    @GetMapping("/notice/selectByPrimaryKey")
    @ApiOperation(value = "获取公告", notes = "根据ID查询")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultVo selectByPrimaryKey(@RequestParam(value = "id") Long id) {
        SNotice sNotice = sNoticeService.selectByPrimaryKey(id);
        if (sNotice != null) {
            return new ResultVo(ResultEnum.OK, sNotice);
        }
        return new ResultVo(ResultEnum.FAIL);
    }

    @GetMapping("/notice/selectBySelective")
    @ApiOperation(value = "获取公告(按条件分页)", notes = "根据条件分页查询")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultVo selectBySelective(@RequestParam(value = "searchParams", required = false) String searchParams,
                                      @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                      @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {
        SNotice           sNotice  = JSON.parseObject(searchParams, SNotice.class);
        PageInfo<SNotice> sNotices = sNoticeService.selectBySelective(sNotice, pageNum, pageSize);
        if (sNotices.getSize() > 0) {
            return new ResultVo(ResultEnum.OK, sNotices);
        }
        return new ResultVo(ResultEnum.FAIL);
    }

    @PostMapping("/notice/updateByPrimaryKeySelective")
    @ApiOperation(value = "更新公告 (按条件)", notes = "根据ID修改对应字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultVo updateByPrimaryKeySelective(@RequestBody @ApiParam(name = "公告对象 ", value = "传入json格式") SNotice record) {
        int num = sNoticeService.updateByPrimaryKeySelective(record);
        if (num > 0) {
            return new ResultVo(ResultEnum.OK);
        }
        return new ResultVo(ResultEnum.FAIL);

    }

}
