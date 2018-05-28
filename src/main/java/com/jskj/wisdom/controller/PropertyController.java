package com.jskj.wisdom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.enums.PropertyEnum;
import com.jskj.wisdom.model.SProperty;
import com.jskj.wisdom.service.SPropertyService;
import com.jskj.wisdom.vo.PropertyVo;
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
@Api(value = "PropertyController API", description = "物业相关接口")
public class PropertyController {
    @Resource
    private SPropertyService sPropertyService;

    @DeleteMapping("/property/deleteByPrimaryKey")
    @ApiOperation(value = "删除物业信息(永久)", notes = "根据ID删除物业信息,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public PropertyVo deleteByPrimaryKey(@RequestParam(value = "id") Long id) {
        int num = sPropertyService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new PropertyVo(PropertyEnum.OK);
        }
        return new PropertyVo(PropertyEnum.FAIL);
    }

    @PutMapping("/property/insert")
    @ApiOperation(value = "添加物业信息", notes = "添加对象所有字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public PropertyVo insert(@RequestBody @ApiParam(name = "公告对象 ", value = "传入json格式") SProperty record) {
        int num = sPropertyService.insert(record);
        if (num > 0) {
            return new PropertyVo(PropertyEnum.OK);
        }
        return new PropertyVo(PropertyEnum.FAIL);
    }

    @PutMapping("/property/insertSelective")
    @ApiOperation(value = "添加物业信息(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public PropertyVo insertSelective(@RequestBody @ApiParam(name = "公告对象 ", value = "传入json格式") SProperty record) {
        int num = sPropertyService.insertSelective(record);
        if (num > 0) {
            return new PropertyVo(PropertyEnum.OK);
        }
        return new PropertyVo(PropertyEnum.FAIL);
    }

    @GetMapping("/property/selectByPrimaryKey")
    @ApiOperation(value = "获取物业信息", notes = "根据ID查询")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public PropertyVo selectByPrimaryKey(@RequestParam(value = "id") Long id) {
        SProperty sProperty = sPropertyService.selectByPrimaryKey(id);
        if (sProperty != null) {
            return new PropertyVo(PropertyEnum.OK, sProperty);
        }
        return new PropertyVo(PropertyEnum.FAIL);
    }

    @GetMapping("/property/selectBySelective")
    @ApiOperation(value = "获取物业信息(按条件分页)", notes = "根据条件查询并分页")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public PropertyVo selectBySelective(@RequestParam(value = "searchParams", required = false) String searchParams,
                                        @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                        @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {
        SProperty           sProperty   = JSON.parseObject(searchParams, SProperty.class);
        PageInfo<SProperty> sProperties = sPropertyService.selectBySelective(sProperty, pageNum, pageSize);
        if (sProperties.getSize() > 0) {
            return new PropertyVo(PropertyEnum.OK, sProperties);
        }
        return new PropertyVo(PropertyEnum.FAIL);
    }

    @PostMapping("/property/updateByPrimaryKeySelective")
    @ApiOperation(value = "更新物业信息 (按条件)", notes = "根据ID修改对应字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public PropertyVo updateByPrimaryKeySelective(@RequestBody @ApiParam(name = "公告对象 ", value = "传入json格式") SProperty record) {
        int num = sPropertyService.updateByPrimaryKeySelective(record);
        if (num > 0) {
            return new PropertyVo(PropertyEnum.OK);
        }
        return new PropertyVo(PropertyEnum.FAIL);

    }


    @PostMapping("/property/updateByPrimaryKey")
    @ApiOperation(value = "更新物业信息", notes = "根据ID修改所有字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public PropertyVo updateByPrimaryKey(@RequestBody @ApiParam(name = "公告对象 ", value = "传入json格式") SProperty record) {
        int num = sPropertyService.updateByPrimaryKey(record);
        if (num > 0) {
            return new PropertyVo(PropertyEnum.OK);
        }
        return new PropertyVo(PropertyEnum.FAIL);
    }
}
