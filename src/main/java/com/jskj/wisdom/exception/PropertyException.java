package com.jskj.wisdom.exception;

import com.jskj.wisdom.enums.ResultEnum;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.exception
 * //TODO
 * @date 2018-05-28 16:29 Mon
 */
public class PropertyException extends RuntimeException {
    private String code;
    private String msg;

    public PropertyException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public PropertyException(String code, String msg) {
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
