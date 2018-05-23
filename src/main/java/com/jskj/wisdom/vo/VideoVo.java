package com.jskj.wisdom.vo;

import com.jskj.wisdom.enums.VideoEnum;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.vo
 * @description
 * @date 2018-05-16 09:28 星期三
 */
public class VideoVo extends ResultVo {
    public VideoVo(VideoEnum videoEnum) {
        this.code = videoEnum.getCode();
        this.msg = videoEnum.getMsg();
    }

    public VideoVo(VideoEnum videoEnum, Object data) {
        this.code = videoEnum.getCode();
        this.msg = videoEnum.getMsg();
        this.data = data;
    }
}
