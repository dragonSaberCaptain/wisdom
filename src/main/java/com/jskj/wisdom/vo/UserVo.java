package com.jskj.wisdom.vo;

import com.jskj.wisdom.enums.UserEnum;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.vo
 * @description
 * @date 2018-05-14 15:38 星期一
 */
public class UserVo extends ResultVo {
    public UserVo(UserEnum userEnum) {
        this.code = userEnum.getCode();
        this.msg = userEnum.getMsg();
    }

    public UserVo(UserEnum userEnum, Object data) {
        this.code = userEnum.getCode();
        this.msg = userEnum.getMsg();
        this.data = data;
    }
}
