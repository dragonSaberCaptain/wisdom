package com.jskj.wisdom.exception;

import com.jskj.wisdom.enums.ResultEnum;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.exception
 * @description
 * @date 2018-05-16 09:30 星期三
 */
public class VideoException extends RuntimeException {
    private String code;
    private String msg;

    public VideoException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public VideoException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
