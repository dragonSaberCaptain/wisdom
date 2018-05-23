package com.jskj.wisdom.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jskj.wisdom.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.utils
 * @description
 * @date 2018-05-07 14:13 星期一
 */
public class ResultUtil {
    private static final Logger       logger = LoggerFactory.getLogger(ResultUtil.class);
    private static       ObjectMapper mapper = new ObjectMapper();

    public static void writeJson(Object obj, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf8");
            PrintWriter pw = resp.getWriter();
            String      str;
            if (!(obj instanceof String)) {
                str = toString(obj);
            } else {
                str = obj.toString();
            }
            pw.print(str);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static String toString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void result(ResultEnum resultEnum, HttpServletResponse httpServletResponse) {
        Map<String, Object> rec = new LinkedHashMap<String, Object>();
        rec.put("code", resultEnum.getCode());
        rec.put("msg", resultEnum.getMsg());
        ResultUtil.writeJson(rec, httpServletResponse);
    }

    public static void result(ResultEnum resultEnum, Object object, HttpServletResponse httpServletResponse) {
        Map<String, Object> rec = new LinkedHashMap<String, Object>();
        rec.put("code", resultEnum.getCode());
        rec.put("msg", resultEnum.getMsg());
        rec.put("data", object);
        ResultUtil.writeJson(rec, httpServletResponse);
    }

    public static void result(String code, String message, Object object, HttpServletResponse httpServletResponse) {
        Map<String, Object> rec = new LinkedHashMap<String, Object>();
        rec.put("code", code);
        rec.put("msg", message);
        rec.put("data", object);
        ResultUtil.writeJson(rec, httpServletResponse);
    }

    public static void result(String code, String message, HttpServletResponse httpServletResponse) {
        Map<String, Object> rec = new LinkedHashMap<String, Object>();
        rec.put("code", code);
        rec.put("msg", message);
        ResultUtil.writeJson(rec, httpServletResponse);
    }

    public static void Result(int code, String message, HttpServletResponse httpServletResponse) {
        Map<String, Object> rec = new LinkedHashMap<String, Object>();
        rec.put("code", code);
        rec.put("msg", message);
        ResultUtil.writeJson(rec, httpServletResponse);
    }
}
