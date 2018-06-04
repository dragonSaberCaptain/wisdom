package com.jskj.wisdom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.dto.ResultDto;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.model.wisdom.SRepair;
import com.jskj.wisdom.service.RepairService;
import com.jskj.wisdom.vo.repair.RepairAddVo;
import com.jskj.wisdom.vo.repair.RepairFindVo;
import com.jskj.wisdom.vo.repair.RepairUpdateVo;
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
 * //报修
 * @date 2018-06-04 17:48 Mon
 */
@Controller
@Api(value = "RepairController API", description = "报修相关接口")
public class RepairController {

    @Resource
    private RepairService repairService;

    @DeleteMapping("/repair/deleteById")
    @ApiOperation(value = "删除报修(永久)", notes = "根据ID删除报修,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto deleteById(@RequestParam(value = "id") Long id) {
        int num = repairService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new ResultDto(ResultEnum.OK);
        }
        return new ResultDto(ResultEnum.FAIL);
    }

    @PutMapping("/repair/addByParams")
    @ApiOperation(value = "添加报修(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<RepairAddVo> addByParams(
            @ApiParam(name = "报修新增对象 ", value = "传入json格式") RepairAddVo record,
            @RequestParam(value = "scale", defaultValue = "1", required = false) double scale,
            @RequestParam(value = "imageFile", required = false) MultipartFile[] imageFile) {
        if (scale > Global.TEN_DOUBLE) {
            scale = 10;
        }
        int num = repairService.insertSelective(record, scale, imageFile);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/repair/findById")
    @ApiOperation(value = "获取报修", notes = "根据ID查询")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<RepairFindVo> findById(@RequestParam(value = "id") Long id) {
        RepairFindVo repairFindVo = repairService.selectByPrimaryKey(id);
        if (repairFindVo != null) {
            return new ResultDto<>(ResultEnum.OK, repairFindVo);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/repair/findByParams")
    @ApiOperation(value = "获取报修(按条件分页)", notes = "根据条件查询并分页")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<PageInfo<RepairFindVo>> findByParams(@RequestParam(value = "searchParams", required = false) String searchParams,
                                                          @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                                          @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {
        SRepair record = JSON.parseObject(searchParams, SRepair.class);

        PageInfo<RepairFindVo> repairFindVoPageInfo = repairService.selectBySelective(record, pageNum, pageSize);
//        if (sRepairPageInfo.getSize() > 0) {
        return new ResultDto<>(ResultEnum.OK, repairFindVoPageInfo);
//        }
//        return new ResultDto<>(ResultEnum.FAIL);
    }

    @PostMapping("/repair/updateByParams")
    @ApiOperation(value = "更新报修 (按条件)", notes = "根据ID修改对应字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<RepairUpdateVo> updateByParams(@ApiParam(name = "报修对象 ", value = "传入json格式") RepairUpdateVo record) {
        int num = repairService.updateByPrimaryKeySelective(record);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

}
