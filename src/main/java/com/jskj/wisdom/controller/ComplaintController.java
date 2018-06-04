package com.jskj.wisdom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.dto.ResultDto;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.model.wisdom.SComplaint;
import com.jskj.wisdom.service.ComplaintService;
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
 * @date 2018-06-05 09:07 星期二
 */
@Controller
@Api(value = "ComplaintController API", description = "投诉相关接口")
public class ComplaintController {
    @Resource
    private ComplaintService complaintService;

    @PutMapping("/complaint/addByParams")
    @ApiOperation(value = "添加(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<SComplaint> addByParams(@ApiParam(name = "投诉对象 ", value = "传入json格式") SComplaint sComplaint,
                                             @RequestParam(value = "scale", defaultValue = "1", required = false) double scale,
                                             @RequestParam(value = "imageFile", required = false) MultipartFile[] imageFile) {
        int num = complaintService.insertSelective(sComplaint, scale, imageFile);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }


    @DeleteMapping("/complaint/deleteById")
    @ApiOperation(value = "删除投诉信息(永久)", notes = "根据ID删除投诉,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto deleteById(@RequestParam(value = "id") Long id) {
        int num = complaintService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new ResultDto(ResultEnum.OK);
        }
        return new ResultDto(ResultEnum.FAIL);
    }

    @PostMapping("/complaint/updateByParams")
    @ApiOperation(value = "更新投诉信息 (按条件)", notes = "根据ID修改对应字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<SComplaint> updateByParams(@ApiParam(name = "投诉对象 ", value = "传入json格式") SComplaint sComplaint) {
        int num = complaintService.updateByPrimaryKeySelective(sComplaint);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/complaint/findById")
    @ApiOperation(value = "获取投诉信息", notes = "根据ID查询")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<SComplaint> findById(@RequestParam(value = "id") Long id) {
        SComplaint sComplaint = complaintService.selectByPrimaryKey(id);
        if (sComplaint != null) {
            return new ResultDto<>(ResultEnum.OK, sComplaint);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/complaint/findByParams")
    @ApiOperation(value = "获取投诉信息(按条件分页)", notes = "根据条件查询并分页")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<PageInfo<SComplaint>> findByParams(@RequestParam(value = "searchParams", required = false) String searchParams,
                                                        @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                                        @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {

        SComplaint sComplaint = JSON.parseObject(searchParams, SComplaint.class);

        PageInfo<SComplaint> sComplaintPageInfo = complaintService.selectBySelective(sComplaint, pageNum, pageSize);
        if (sComplaintPageInfo.getSize() > 0) {
            return new ResultDto<>(ResultEnum.OK, sComplaintPageInfo);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

}
