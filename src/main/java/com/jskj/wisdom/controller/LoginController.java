package com.jskj.wisdom.controller;

import cn.jsms.api.SendSMSResult;
import com.jskj.wisdom.config.jpush.JpushConfig;
import com.jskj.wisdom.enums.UserEnum;
import com.jskj.wisdom.model.TUser;
import com.jskj.wisdom.service.TUserService;
import com.jskj.wisdom.utils.jpush.JpushSMSUtil;
import com.jskj.wisdom.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.controller
 * @description 登陆相关
 * @date 2018-05-04 13:51 星期五
 */
@Controller
@Api(value = "LoginController API", description = "登陆与注册相关接口")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private TUserService        tUserService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/open/getLoginCode")
    @ApiOperation(value = "获取短信验证码", notes = "通过用户手机号获取短信验证码")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1005, message = "手机号不存在"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserVo getLoginCode(
            @RequestParam(name = "mobile") String mobile) throws Exception {
        TUser tUser = new TUser();
        tUser.setMobile(mobile);
        List<TUser> tUsers = tUserService.selectBySelective(tUser);
        if (tUsers.size() > 0) {
            SendSMSResult sendSMSResult = JpushSMSUtil.sendSMSCode(mobile, JpushConfig.TEMPLD);
            logger.info("发送短信验证码:" + sendSMSResult.toString());
            stringRedisTemplate.opsForValue().set(mobile + ":msgId", sendSMSResult.getMessageId());
            logger.info("存储msgId并设置有效期:" + mobile + ":msgId", sendSMSResult.getMessageId());

            return new UserVo(UserEnum.OK);
        }
        return new UserVo(UserEnum.NO_FIND_MOBILE);
    }

    @GetMapping("/open/login")
    @ApiOperation(value = "登陆", notes = "验证用户是否存在，验证码是否正确")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 1006, message = "验证码已超时"),
            @ApiResponse(code = 1007, message = "验证未通过,验证码不正确"),
            @ApiResponse(code = 1004, message = "用户不存在"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    @Transactional(rollbackFor = Exception.class)
    public UserVo login(
            @RequestParam(name = "mobile") String mobile,
            @RequestParam(name = "code") String code) {
        Map<String, Object> resultMap = tUserService.login(mobile, code);
        if (resultMap != null) {
            return new UserVo(UserEnum.OK, resultMap);
        }
        return new UserVo(UserEnum.FAIL);
    }

    @RequestMapping({"/", "/index"})
    public String index() {
        System.out.printf("--------------LoginController.login: %s %n", "index");
        return "/index";
    }

    @RequestMapping("/login")
    public String login() {
        System.out.printf("--------------LoginController.login: %s %n", "login");
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "403";
    }
}
