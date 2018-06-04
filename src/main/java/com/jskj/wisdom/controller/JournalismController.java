package com.jskj.wisdom.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.dto.ResultDto;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.model.wisdom.SJournalism;
import com.jskj.wisdom.service.JournalismService;
import com.jskj.wisdom.vo.journalism.JournalismFindVo;
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
 * 新闻相关
 * @date 2018-05-28 09:58 星期一
 */
@Controller
@Api(value = "JournalismController API", description = "新闻相关接口")
public class JournalismController {
    @Resource
    private JournalismService journalismService;

    @DeleteMapping("/property/deleteById")
    @ApiOperation(value = "删除新闻(永久)", notes = "根据ID删除新闻,请谨慎处理")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto deleteById(@RequestParam(value = "id") Long id) {
        int num = journalismService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new ResultDto(ResultEnum.OK);
        }
        return new ResultDto(ResultEnum.FAIL);
    }

    @PutMapping("/property/addByParams")
    @ApiOperation(value = "添加(按条件)", notes = "添加对象对应字段")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<SJournalism> addByParams(@ApiParam(name = "公告对象 ", value = "传入json格式") SJournalism sJournalism,
                                              @RequestParam(value = "scale", defaultValue = "1", required = false) double scale,
                                              @RequestParam(value = "imageFile", required = false) MultipartFile[] imageFile) {
        int num = journalismService.insertSelective(sJournalism, scale, imageFile);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/property/findById")
    @ApiOperation(value = "获取新闻", notes = "根据ID查询")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<JournalismFindVo> findById(@RequestParam(value = "id") Long id) {
        JournalismFindVo journalismFindVo = journalismService.selectByPrimaryKey(id);
        if (journalismFindVo != null) {
            return new ResultDto<>(ResultEnum.OK, journalismFindVo);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @GetMapping("/property/findByParams")
    @ApiOperation(value = "获取新闻(按条件分页)", notes = "根据条件查询并分页")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<PageInfo<JournalismFindVo>> findByParams(@RequestParam(value = "searchParams", required = false) String searchParams,
                                                              @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                                              @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {

        SJournalism sJournalism = JSON.parseObject(searchParams, SJournalism.class);

        PageInfo<JournalismFindVo> journalismFindVoPageInfo = journalismService.selectBySelective(sJournalism, pageNum, pageSize);
        if (journalismFindVoPageInfo.getSize() > 0) {
            return new ResultDto<>(ResultEnum.OK, journalismFindVoPageInfo);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

    @PostMapping("/property/updateByParams")
    @ApiOperation(value = "更新新闻 (按条件)", notes = "根据ID修改对应字段(必须含ID）")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<SJournalism> updateByParams(@ApiParam(name = "新闻对象 ", value = "传入json格式") SJournalism sJournalism) {
        int num = journalismService.updateByPrimaryKeySelective(sJournalism);
        if (num > 0) {
            return new ResultDto<>(ResultEnum.OK);
        }
        return new ResultDto<>(ResultEnum.FAIL);
    }

}
