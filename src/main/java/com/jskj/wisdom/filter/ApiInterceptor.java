package com.jskj.wisdom.filter;

import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.utils.ResultUtil;
import com.jskj.wisdom.utils.ip.IpUtil;
import com.jskj.wisdom.utils.safety.VerifyUtil;
import com.jskj.wisdom.utils.string.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.filter
 * @description
 * @date 2018-05-06 22:25 星期日
 */
public class ApiInterceptor implements HandlerInterceptor {
    private static final Logger              logger = LoggerFactory
            .getLogger(ApiInterceptor.class);
    @Resource
    private              StringRedisTemplate stringRedisTemplate;

    private Map<String, Object> getParams(HttpServletRequest request) {
        Map<String, String[]> rec    = request.getParameterMap();
        Map<String, Object>   result = new LinkedHashMap<String, Object>();

        for (Map.Entry<String, String[]> entry : rec.entrySet()) {
            String name  = entry.getKey();
            Object value = entry.getValue()[0];
            result.put(name, value);
            logger.info("请求参数:" + name + ", value:" + value);
        }
        return result;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        String url = httpServletRequest.getRequestURI();
        logger.info("请求地址： " + url);
        String ip = IpUtil.getIpAddress(httpServletRequest);
        logger.info("请求ip： " + ip);
        String agent = httpServletRequest.getHeader("User-Agent");
        logger.info("请求来源： " + agent);

        Map<String, Object> requestMap = getParams(httpServletRequest);

//        判断请求是否来自手机 返回true表示是手机
        boolean judgeismoblie = VerifyUtil.judgeIsMoblie(httpServletRequest);
        if (!judgeismoblie) {
            return true;
        }

        Map<String, Object> rec     = new LinkedHashMap<>();
        String              token   = (String) requestMap.get("token");
        String              signMsg = (String) requestMap.get("signMsg");
        String              uuid    = (String) requestMap.get("uuid");

        if (StringUtil.isBlank(token)) {
            rec.put("code", "2002");
            rec.put("msg", "token不能为空");
            ResultUtil.writeJson(rec, httpServletResponse);
            return false;
        }
        //重缓存中获取token
        String webToken = null;
        try {
            webToken = stringRedisTemplate.opsForValue().get(Global.LOGIN_VALID_TOKEN + token);
        } catch (Exception e) {
            logger.error("ApiInterceptor--preHandle", e);
            e.printStackTrace();

            rec.put("code", "2000");
            rec.put("msg", "token不存在或已过期，请重新登陆");
            ResultUtil.writeJson(rec, httpServletResponse);
            return false;
        }
        //验证前端传入的token与后台存储的token是否一致
        if (webToken.equals(token)) {
            //验证流程
            String  webSignMsg = DigestUtils.md5Hex(Global.MD5_SALT + uuid).toUpperCase();
            boolean bool       = webSignMsg.equalsIgnoreCase(signMsg);
            if (bool) {
                return true;
            }
        }

        rec.put("code", "2001");
        rec.put("msg", "验证失败,token错误");
        ResultUtil.writeJson(rec, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
