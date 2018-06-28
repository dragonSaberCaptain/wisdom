package com.jskj.wisdom.controller;

import cn.jsms.api.SendSMSResult;
import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.config.jpush.JpushConfig;
import com.jskj.wisdom.dto.ResultDto;
import com.jskj.wisdom.dto.UserDto;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.enums.UserEnum;
import com.jskj.wisdom.service.NoticeService;
import com.jskj.wisdom.service.PicturesService;
import com.jskj.wisdom.service.UserService;
import com.jskj.wisdom.utils.database.redis.JedisUtil;
import com.jskj.wisdom.utils.jpush.JpushSMSUtil;
import com.jskj.wisdom.utils.pic.PicUtil;
import com.jskj.wisdom.utils.pic.ThumbnailatorUtil;
import com.jskj.wisdom.utils.string.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
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
    private UserService userService;

    @Resource
    private NoticeService noticeService;

    @Resource
    private PicturesService picturesService;

    @GetMapping("/open/getLoginCode")
    @ApiOperation(value = "获取短信验证码", notes = "通过用户手机号获取短信验证码")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1005, message = "手机号不存在"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserDto getLoginCode(
            @RequestParam(name = "mobile") String mobile) throws Exception {
            if (Global.DEBUG) {
                return new UserDto(UserEnum.OK);
            }
            SendSMSResult sendSMSResult = JpushSMSUtil.sendSMSCode(mobile, JpushConfig.TEMPLD);
            logger.info("发送短信验证码:" + sendSMSResult.toString());

        JedisUtil.Strings.setEx(Global.APPLICATION_NAME + mobile + ":msgId", sendSMSResult.getMessageId(), 90);
            logger.info("存储msgId并设置有效期:" + mobile + ":msgId", sendSMSResult.getMessageId());
            return new UserDto(UserEnum.OK);
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
    public UserDto<Map<String, Object>> login(
            @RequestParam(name = "mobile") String mobile,
            @RequestParam(name = "code") String code) {
        Map<String, Object> resultMap = userService.login(mobile, code);
        if (resultMap != null) {
            return new UserDto<>(UserEnum.OK, resultMap);
        }
        return new UserDto<>(UserEnum.FAIL);
    }

    @GetMapping("/open/logout")
    @ApiOperation(value = "退出登录", notes = "清空当前用户token")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public UserDto<Map<String, Object>> logout(@RequestParam(name = "token") String token) {
        Long result = JedisUtil.Keys.del(Global.LOGIN_VALID_TOKEN + token);
        if (result > 0) {
            return new UserDto<>(UserEnum.OK);
        }
        return new UserDto<>(UserEnum.FAIL);
    }

    @GetMapping("/open/getPic")
    @ApiOperation(value = "获取图片", notes = "可以通过改变缩放比例和类型来输出图片")
    @ResponseBody
    public ResultDto<String> getPic(@RequestParam(name = "source") String source, @RequestParam(name = "toBase64", defaultValue = "false", required = false) boolean toBase64, @RequestParam(name = "scale") double scale, @RequestParam(name = "format") String format, HttpServletResponse response) {

        source = Global.PIC_PREFIX + source;
        if (toBase64) {
            String imageStr = PicUtil.getImageStr(source);
            if (StringUtil.isBlank(imageStr)) {
                return new ResultDto<>(ResultEnum.FAIL);
            }
            return new ResultDto<>(ResultEnum.OK, imageStr);
        }
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            if (scale > Global.TEN_DOUBLE) {
                scale = 10;
            }
            BufferedImage buf = ThumbnailatorUtil.ImgBufferedImage(source, scale);
            if (buf != null) {
                ImageIO.write(buf, format, out);
            }
        } catch (Exception e) {
            logger.error("LoginController--getPic", e);
            e.printStackTrace();
            return new ResultDto<>(ResultEnum.FAIL);
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ResultDto<>(ResultEnum.OK);
    }

    @GetMapping("/home/getHomeInfo")
    @ApiOperation(value = "获取首页信息", notes = "封装与首页相关的信息")
    @ResponseBody
    @ApiResponses({@ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 1002, message = "失败"),
            @ApiResponse(code = 500, message = "服务器内部异常")})
    public ResultDto<Map<String, Object>> getHomeInfo() {
        Map<String, Object> resultMap = new HashMap<>(16);
        //首页广告栏
        resultMap.put("homeTop1", noticeService.selectByUpdateTime(3));
        //首页最新公告
        resultMap.put("homeTop2", noticeService.selectByUpdateTime(2));

        return new ResultDto<>(ResultEnum.OK, resultMap);
    }
}
