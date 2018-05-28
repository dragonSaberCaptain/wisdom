package com.jskj.wisdom.vo;

import com.jskj.wisdom.enums.NoticeEnum;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.vo
 * //TODO
 * @date 2018-05-28 10:08 星期一
 */
public class NoticeVo extends ResultVo {
    public NoticeVo(NoticeEnum noticeEnum) {
        this.code = noticeEnum.getCode();
        this.msg = noticeEnum.getMsg();
    }

    public NoticeVo(NoticeEnum noticeEnum, Object data) {
        this.code = noticeEnum.getCode();
        this.msg = noticeEnum.getMsg();
        this.data = data;
    }
}
