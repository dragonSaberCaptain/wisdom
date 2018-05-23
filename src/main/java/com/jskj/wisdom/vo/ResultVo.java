package com.jskj.wisdom.vo;

import com.jskj.wisdom.enums.ResultEnum;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.dto
 * @description
 * @date 2018-05-04 13:34 星期五
 */

public class ResultVo implements Serializable {
    protected String code;
    protected String msg;
    @ApiModelProperty(value = "返回数据", required = true)
    protected Object data;

    public ResultVo(ResultEnum resultEnum) {
        super();
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public ResultVo(ResultEnum resultEnum, Object data) {
        super();
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public ResultVo(String code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResultVo(int code, String msg) {
        super();
        this.code = String.valueOf(code);
        this.msg = msg;
    }


    public ResultVo() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}