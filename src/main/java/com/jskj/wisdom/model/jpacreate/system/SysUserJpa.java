package com.jskj.wisdom.model.jpacreate.system;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.jpacreate.system
 * @description
 * @date 2018-05-23 14:12 Wed
 */
@Entity
@Table(name = "sys_user")
public class SysUserJpa extends BaseModel {

    @Column(columnDefinition = "varchar(64) COMMENT '登录账号'")
    private String loginName;

    @Column(columnDefinition = "varchar(64) COMMENT '登录密码'")
    private String password;

    @Column(columnDefinition = "varchar(64) COMMENT '工号'")
    private Long workNumber;

    @Column(columnDefinition = "varchar(64) COMMENT '昵称'")
    private String nickName;

    @Column(columnDefinition = "varchar(32) COMMENT '邮箱'")
    private String email;

    @Column(columnDefinition = "varchar(32) COMMENT '座机'")
    private String phone;

    @Column(columnDefinition = "varchar(32) COMMENT '手机号'")
    private String mobile;

    @Column(columnDefinition = "varchar(32) COMMENT '用户类型'")
    private String userType;

    @Column(columnDefinition = "varchar(32) COMMENT '登录标志'")
    private String loginFlag;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("loginName", loginName)
                .append("password", password)
                .append("workNumber", workNumber)
                .append("nickName", nickName)
                .append("email", email)
                .append("phone", phone)
                .append("mobile", mobile)
                .append("userType", userType)
                .append("loginFlag", loginFlag)
                .toString();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getNumber() {
        return workNumber;
    }

    public void setNumber(Long workNumber) {
        this.workNumber = workNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }
}
