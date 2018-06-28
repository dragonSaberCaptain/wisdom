package com.jskj.wisdom.controller.system;

import com.jskj.wisdom.service.system.SysUserServer;
import com.jskj.wisdom.utils.string.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.controller.system
 * //TODO
 * @date 2018-06-04 09:09 星期一
 */
@Controller
public class SysLoginController {

    @Resource
    private SysUserServer sysUserServer;

//    @RequestMapping("/login")
//    public String index(@RequestParam(name = "userName", required = false) String userName, @RequestParam(name = "password", required = false) String password, @RequestParam(name = "rememberMe", required = false, defaultValue = "false") boolean rememberMe) {
//        if (StringUtil.isBlank(userName) || StringUtil.isBlank(password)) {
//            return "/login";
//        }
//        // 获取当前的Subject
//        Subject currentUser = SecurityUtils.getSubject();
//
//        // 测试当前的用户是否已经被认证，即是否已经登陆
//        // 调用Subject的isAuthenticated
//        if (currentUser.isAuthenticated()) {
//            return "redirect:swagger-ui.html";
//        }
//        // 把用户名和密码封装为UsernamePasswordToken 对象
//        UsernamePasswordToken token = new UsernamePasswordToken(userName.trim(), DigestUtils.md5Hex(password.trim()), rememberMe);
//        try {
//            // 执行登陆
//            currentUser.login(token);
//            return "redirect:swagger-ui.html";
//        } catch (IncorrectCredentialsException e) {
//            System.out.println("登录密码错误!!!" + e);
//        } catch (ExcessiveAttemptsException e) {
//            System.out.println("登录失败次数过多!!!" + e);
//        } catch (LockedAccountException e) {
//            System.out.println("帐号已被锁定!!!" + e);
//        } catch (DisabledAccountException e) {
//            System.out.println("帐号已被禁用!!!" + e);
//        } catch (ExpiredCredentialsException e) {
//            System.out.println("帐号已过期!!!" + e);
//        } catch (UnknownAccountException e) {
//            System.out.println("帐号不存在!!!" + e);
//        } catch (UnauthorizedException e) {
//            System.out.println("您没有得到相应的授权！" + e);
//        } catch (Exception e) {
//            System.out.println("出错！！！" + e);
//        }
//        return "/login";
//    }


    @RequestMapping({"", "/home"})
    public String home() {
        System.out.printf("--------------LoginController.login: %s %n", "home");
        return "redirect:swagger-ui.html";
    }

    @RequestMapping("/ajaxLogin")
    public String ajaxLogin() {
        return "/login";
    }

    @RequestMapping("/register")
    public String register(@RequestParam(name = "userName", required = false) String userName, @RequestParam(name = "password", required = false) String password) {
        if (StringUtil.isBlank(userName) || StringUtil.isBlank(password)) {
            return "/register";
        }
        int num = sysUserServer.insertSelective(userName, password);
        if (num > 0) {
            return "/login";
        }
        return "/register";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "403";
    }
}
