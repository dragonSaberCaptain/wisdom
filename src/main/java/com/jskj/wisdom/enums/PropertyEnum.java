package com.jskj.wisdom.enums;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.enums
 * //TODO
 * @date 2018-05-28 10:42 星期一
 */
public enum PropertyEnum {

    /**
     * 200(成功)
     */
    OK("200", "成功"),
    /**
     * 1002(失败)
     */
    FAIL("1002", "失败"),

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

    PropertyEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return ResultEnum
     * @description 通过传入的状态id查找内容
     * @title findMsgByid
     */
    public static PropertyEnum findMsgByid(String id) {
        for (PropertyEnum propertyEnum : values()) {
            if (propertyEnum.getCode().equals(id)) {
                return propertyEnum;
            }
        }
        return FINDMSGBYID_FAILURE;
    }

    /**
     * @return ResultEnum
     * @description 通过传入的内容查找id
     * @title findidByMsg
     */
    public static PropertyEnum findidByMsg(String mgs) {
        for (PropertyEnum propertyEnum : values()) {
            if (propertyEnum.getMsg().equals(mgs)) {
                return propertyEnum;
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
