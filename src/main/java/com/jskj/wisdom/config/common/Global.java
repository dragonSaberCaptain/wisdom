package com.jskj.wisdom.config.common;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.config
 * @description 全局变量
 * @date 2018-05-06 14:57 星期日
 */
public class Global {
    //---------------------------------------------------------------常量-------------------------------------------------------------------------------

    public static final String USER_AGENT = "User-Agent";

    /**
     * 上传文件大小
     */
    public static final int FILE_SIZE = 10 * 1024 * 1024;

    public static final String SPOT = ".";

    public static final String CODE = "code";
    public static final String MSG  = "msg";
    public static final String DATA = "data";

    //---------------------------------------------------------------数字常量-------------------------------------------------------------------------------

    public static final String ZERO_STRING = "0";
    public static final int    ZERO_INT    = 0;

    public static final String ONE_STRING = "1";
    public static final int    ONE_INT    = 1;

    public static final String TWO_STRING = "2";
    public static final int    TWO_INT    = 2;

    public static final String THREE_STRING = "3";
    public static final int    THREE_INT    = 3;


    public static final String FOUR_STRING = "4";
    public static final int    FOUR_INT    = 4;

    public static final String FIVE_STING = "5";
    public static final int    FIVE_INT   = 5;

    public static final String FIFTEEN_STING = "15";
    public static final int    FIFTEEN_INT   = 15;


    //---------------------------------------------------------------路径-------------------------------------------------------------------------------

    /**
     * 视频缩略图路径
     */
    public static final String USER_PICTURE_PATH = "C:/picture/user_picture/";

    public static final String VIDEO_PICTURE_PATH = "C:/picture/video_picture/";

    public static final String PROPERTY_PICTURE_PATH = "C:/picture/property_picture/";

    public static final String NOTICE_PICTURE_PATH = "C:/picture/notice_picture/";

    //---------------------------------------------------------------ip-------------------------------------------------------------------------------

    public static final String LOCALHOST = "127.0.0.1";

    public static final String HOST = "192.168.0.119";

    //---------------------------------------------------------------前缀-------------------------------------------------------------------------------

    /**
     * 开放接口前缀
     */
    public static final String OPEN = "/open";

    /**
     * 缓存用户token前缀
     */
    public static final String LOGIN_VALID_TOKEN = "userToken:";

    /**
     * 缓存用户信息前缀
     */
    public static final String USER_INFO = "userInfo:";

    //---------------------------------------------------------------盐-------------------------------------------------------------------------------

    /**
     * 盐原始值
     */
    public static final String SALT     = "dragonSaberCaptain";
    /**
     * 盐md5后的值
     */
    public static final String MD5_SALT = "e5a5be7e769d12575d7ea8efa004b154";

}
