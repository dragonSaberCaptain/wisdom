package com.jskj.wisdom.enums;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.enums
 * @description
 * @date 2018-05-16 09:27 星期三
 */
public enum VideoEnum {

    /**
     * 200(成功)
     */
    OK("200", "成功"),
    /**
     * 1002(失败)
     */
    FAIL("1002", "失败"),

    /**
     * 1003(更新失败,视频不存在或id不正确)
     */
    UPDATE_FAIL("1003", "更新失败,视频不存在或id不正确"),

    /**
     * 1004(imageFile不能为空)
     */
    PIC_IS_EMPTY("1004", "imageFile不能为空"),

    /**
     * 1005（文件不能大于10M）
     */
    PIC_TOO_BIG("1005", "文件不能大于10M"),
    // ****************************【其他错误】****************************

    /**
     * 该id不存在
     */
    FINDMSGBYID_FAILURE("9998", "枚举id不存在"),

    /**
     * 该内容不存在
     */
    FINDIDBYMSG_FAILURE("9999", "枚举内容不存在");

    private String code;
    private String msg;

    VideoEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return ResultEnum
     * @description 通过传入的状态id查找内容
     * @title findMsgByid
     */
    public static VideoEnum findMsgByid(String id) {
        for (VideoEnum videoEnum : values()) {
            if (videoEnum.getCode().equals(id)) {
                return videoEnum;
            }
        }
        return FINDMSGBYID_FAILURE;
    }

    /**
     * @return ResultEnum
     * @description 通过传入的内容查找id
     * @title findidByMsg
     */
    public static VideoEnum findidByMsg(String mgs) {
        for (VideoEnum videoEnum : values()) {
            if (videoEnum.getMsg().equals(mgs)) {
                return videoEnum;
            }
        }
        return FINDIDBYMSG_FAILURE;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
