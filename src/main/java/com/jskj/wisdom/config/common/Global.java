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
    //---------------------------------------------------------------默认参数-------------------------------------------------------------------------------

    public static final String USER_AGENT = "User-Agent";

    public static final String ZERO = "0";

    public static final String ONE = "1";

    /**
     * 上传文件大小
     */
    public static final int FILE_SIZE = 10 * 1024 * 1024;


    //---------------------------------------------------------------路径-------------------------------------------------------------------------------

    /**
     * 视频缩略图路径
     */
    public static final String VIDEO_PICTURE_PATH = "C:/picture/video_picture/";


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
