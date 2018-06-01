package com.jskj.wisdom.controller;

import cn.jsms.api.SendSMSResult;
import com.jskj.wisdom.config.jpush.JpushConfig;
import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.enums.UserEnum;
import com.jskj.wisdom.model.TUser;
import com.jskj.wisdom.service.TUserService;
import com.jskj.wisdom.utils.jpush.JpushSMSUtil;
import com.jskj.wisdom.utils.pic.PicUtil;
import com.jskj.wisdom.utils.pic.ThumbnailatorUtil;
import com.jskj.wisdom.utils.string.StringUtil;
import com.jskj.wisdom.vo.ResultVo;
import com.jskj.wisdom.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
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
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

    @GetMapping("/open/getPic")
    @ApiOperation(value = "获取图片", notes = "可以通过改变缩放比例和类型来输出图片")
    @ResponseBody
    public ResultVo getPic(@RequestParam(name = "source") String source, @RequestParam(name = "toBase64", defaultValue = "false", required = false) boolean toBase64, @RequestParam(name = "scale") double scale, @RequestParam(name = "format") String format, HttpServletResponse response) {
        if (toBase64) {
            String imageStr = PicUtil.getImageStr(source);
            if (StringUtil.isBlank(imageStr)) {
                return new ResultVo(ResultEnum.FAIL);
            }
            return new ResultVo(ResultEnum.OK, imageStr);
        }
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            if (scale > 10L) {
                scale = 10L;
            }
            BufferedImage buf = ThumbnailatorUtil.ImgBufferedImage(source, scale);
            if (buf != null) {
                ImageIO.write(buf, format, out);
            }
        } catch (Exception e) {
            logger.error("LoginController--getPic", e);
            e.printStackTrace();
            return new ResultVo(ResultEnum.FAIL);
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
        return new ResultVo(ResultEnum.OK);
    }


    @RequestMapping({"/", "/index"})
    public String index(@RequestParam(name = "userName") String userName, @RequestParam(name = "password") String password, @RequestParam(name = "rememberMe", required = false, defaultValue = "false") boolean rememberMe) {
//        注册使用
//        String result = new Md5Hash("fe7bfb09becc4e645420f3ad67b5147c(ps：前端传入的md5后的密码值)", DigestUtils.md5Hex(Global.MD5_SALT + userName), 1024).toString();

        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();

        // 测试当前的用户是否已经被认证，即是否已经登陆
        // 调用Subject的isAuthenticated
        if (currentUser.isAuthenticated()) {
            System.out.printf("--------------LoginController.index: %s %n", "已登录！");
            return "redirect:swagger-ui.html";
        }
        // 把用户名和密码封装为UsernamePasswordToken 对象
        UsernamePasswordToken token = new UsernamePasswordToken(userName.trim(), password.trim(), rememberMe);
        try {
            // 执行登陆
            currentUser.login(token);
            return "redirect:swagger-ui.html";
        } catch (IncorrectCredentialsException e) {
            System.out.println("登录密码错误!!!" + e);
        } catch (ExcessiveAttemptsException e) {
            System.out.println("登录失败次数过多!!!" + e);
        } catch (LockedAccountException e) {
            System.out.println("帐号已被锁定!!!" + e);
        } catch (DisabledAccountException e) {
            System.out.println("帐号已被禁用!!!" + e);
        } catch (ExpiredCredentialsException e) {
            System.out.println("帐号已过期!!!" + e);
        } catch (UnknownAccountException e) {
            System.out.println("帐号不存在!!!" + e);
        } catch (UnauthorizedException e) {
            System.out.println("您没有得到相应的授权！" + e);
        } catch (Exception e) {
            System.out.println("出错！！！" + e);
        }
        return "/login";
    }

    @RequestMapping("/ajaxLogin")
    public String ajaxLogin() {
        System.out.printf("--------------LoginController.login: %s %n", "ajaxLogin");
        return "/login";
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
