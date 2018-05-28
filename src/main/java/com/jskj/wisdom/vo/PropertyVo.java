package com.jskj.wisdom.vo;

import com.jskj.wisdom.enums.PropertyEnum;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.vo
 * //TODO
 * @date 2018-05-28 10:43 星期一
 */
public class PropertyVo extends ResultVo {
    public PropertyVo(PropertyEnum propertyEnum) {
        this.code = propertyEnum.getCode();
        this.msg = propertyEnum.getMsg();
    }

    public PropertyVo(PropertyEnum propertyEnum, Object data) {
        this.code = propertyEnum.getCode();
        this.msg = propertyEnum.getMsg();
        this.data = data;
    }
}
