package com.jskj.wisdom.model.jpacreate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.jpacreate
 * // TODO 第三方账号
 * @date 2018-06-13 17:36 星期三
 */
@Entity
@Table(name = "account_token")
public class accountTokenJpa extends BaseModel {

    @Column(columnDefinition = " bigint(64) COMMENT '用户id'")
    private Long userId;

    @Column(columnDefinition = " varchar(64) COMMENT '第三方名称'")
    private String thirdName;

    @Column(columnDefinition = " varchar(64) COMMENT '第三方Url'")
    private String thirdPartyUrl;

    @Column(columnDefinition = " varchar(64) COMMENT '第三方账户id'")
    private String thirdPartyId;

    @Column(columnDefinition = " varchar(64) COMMENT '第三方账户名称'")
    private String thirdPartyName;

    @Column(columnDefinition = " varchar(64) COMMENT '第三方账户类型'")
    private String thirdPartyType;

    @Column(columnDefinition = " varchar(64) COMMENT '第三方账户Token'")
    private String thirdPartyToken;

    @Column(columnDefinition = " varchar(64) COMMENT '第三方账户图片链接'")
    private String thirdPartyPicUrl;

    @Column(columnDefinition = " varchar(64) COMMENT '第三方账户密码'")
    private String thirdPartyPassword;

}
