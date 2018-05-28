package com.jskj.wisdom.controller;

import com.github.pagehelper.PageInfo;
import com.jskj.wisdom.enums.UserEnum;
import com.jskj.wisdom.model.TUser;
import com.jskj.wisdom.service.TUserService;
import com.jskj.wisdom.vo.UserVo;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.controller
 * @description 用户相关
 * @date 2018-05-04 10:18 星期五
 */
@Controller
@Api(value = "UserController API", description = "用户相关接口")
public class UserController {
    @Resource
    private TUserService tUserService;

    @PostMapping("/user/updateUserInfo")
    @ApiOperation(value = "修改用户信息(按条件)", notes = "该接口用于修改用户的相关信息")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserVo updateUserInfo(@RequestBody @ApiParam(name = "用户对象 ", value = "传入json格式", required = true) TUser tUser) {
        int num = tUserService.updateByPrimaryKeySelective(tUser);
        if (num > 0) {
            return new UserVo(UserEnum.OK);
        }
        return new UserVo(UserEnum.FAIL);
    }

    @GetMapping("/user/getUserById")
    @ApiOperation(value = "获取用户", notes = "根据用户id获取单个用户")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1004, message = "用户不存在"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserVo getUserById(@RequestParam(name = "id") Long id) {
        TUser tUser = tUserService.selectByPrimaryKey(id);
        if (tUser != null) {
            return new UserVo(UserEnum.OK, tUser);
        }
        return new UserVo(UserEnum.NOT_FOUND);
    }

    @GetMapping("/user/getUsersBySelective")
    @ApiOperation(value = "获取用户(按条件)", notes = "根据条件获取多个用户")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1004, message = "用户不存在"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserVo getUsersBySelective(
            @RequestBody @ApiParam(name = "用户对象 ", value = "传入json格式") TUser tUser,
            @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "30", required = false) int pageSize) {
        PageInfo<TUser> tUserPageInfo = tUserService.selectBySelective(tUser, pageNum, pageSize);
        if (tUserPageInfo.getSize() > 0) {
            return new UserVo(UserEnum.OK, tUserPageInfo);
        }
        return new UserVo(UserEnum.NOT_FOUND);
    }

    @PutMapping("/open/insertUser")
    @ApiOperation(value = "新增用户(按条件)", notes = "添加对象对应字段：验证手机号是否唯一，身份证号是否唯一")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 1003, message = "用户已存在"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserVo insertUser(@RequestBody @ApiParam(name = "用户对象 ", value = "传入json格式", required = true) TUser tUser) {
        TUser user = tUserService.insertSelective(tUser);
        if (user != null) {
            return new UserVo(UserEnum.OK);
        }
        return new UserVo(UserEnum.FAIL);
    }

    @DeleteMapping("/user/deleteUser")
    @ResponseBody
    @ApiOperation(value = "删除用户(永久)", notes = "根据ID删除,请谨慎处理")
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserVo deleteUser(@RequestParam(name = "id") Long id) {
        int num = tUserService.deleteByPrimaryKey(id);
        if (num > 0) {
            return new UserVo(UserEnum.OK);
        }
        return new UserVo(UserEnum.FAIL);
    }
}

