package com.jskj.wisdom.enums;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.enums
 * @description 用户相关错误:均为1xxx
 * @date 2018-05-14 15:23 星期一
 */
public enum UserEnum {
    /**
     * 200(成功)
     */
    OK("200", "成功"),
    /**
     * 1002(失败)
     */
    FAIL("1002", "失败"),

    /**
     * 1003(用户已存在)
     */
    ALREADY_EXISTED("1003", "用户已存在"),
    /**
     * 1004(用户不存在)
     */
    NOT_FOUND("1004", "用户不存在"),
    /**
     * 1005(手机号不存在)
     */
    NO_FIND_MOBILE("1005", "手机号不存在"),
    /**
     * 1006(验证码已超时)
     */
    VERIFICATION_CODE_TIMEOUT("1006", "验证码已超时"),

    /**
     * 1007(验证未通过, 验证码不正确)
     */
    VERIFICATION_FAILURE("1007", "验证未通过,验证码不正确"),

    /**
     * 1008(手机号不唯一)
     */
    MOBILE_NOT_UNIQUE("1008", "手机号不唯一"),
    /**
     * 1009(身份证号不唯一)
     */
    IDNUMBER_NOT_UNIQUE("1009", "身份证号不唯一"),

    /**
     * 1010(用户已删除)
     */
    DELETED("1010", "用户已删除"),

    /**
     * 1011(用户未注册)
     */
    UNREGISTERED("1011", "用户未注册"),

    /**
     * 1012（用户未登记不允许注册）
     */
    NO_REGISTER("1012", "用户未登记不允许注册"),

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

    UserEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return ResultEnum
     * @description 通过传入的状态id查找内容
     * @title findMsgByid
     */
    public static UserEnum findMsgByid(String id) {
        for (UserEnum userEnum : values()) {
            if (userEnum.getCode().equals(id)) {
                return userEnum;
            }
        }
        return FINDMSGBYID_FAILURE;
    }

    /**
     * @return ResultEnum
     * @description 通过传入的内容查找id
     * @title findidByMsg
     */
    public static UserEnum findidByMsg(String mgs) {
        for (UserEnum userEnum : values()) {
            if (userEnum.getMsg().equals(mgs)) {
                return userEnum;
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
