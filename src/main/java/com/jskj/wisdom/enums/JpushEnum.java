package com.jskj.wisdom.enums;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.enums
 * @description
 * @date 2018-05-04 18:04 星期五
 */
public enum JpushEnum {

    // ****************************【其他错误】****************************
    /**
     * 该id不存在
     */
    FINDMSGBYID_FAILURE("9001", "枚举id不存在"),
    /**
     * 该内容不存在
     */
    FINDIDBYMSG_FAILURE("9002", "枚举内容不存在"),;
    private String status;
    private String message;

    JpushEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * @return ResultEnum
     * @description 通过传入的状态id查找内容
     * @title findMsgByid
     */
    public static JpushEnum findMsgByid(String id) {
        for (JpushEnum jpushEnum : values()) {
            if (jpushEnum.getStatus().equals(id)) {
                return jpushEnum;
            }
        }
        return FINDMSGBYID_FAILURE;
    }

    /**
     * @return ResultEnum
     * @description 通过传入的内容查找id
     * @title findidByMsg
     */

    public static JpushEnum findidByMsg(String mgs) {
        for (JpushEnum jpushEnum : values()) {
            if (jpushEnum.getMessage().equals(mgs)) {
                return jpushEnum;
            }
        }
        return FINDIDBYMSG_FAILURE;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
