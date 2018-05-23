package com.jskj.wisdom.config.shiro;

import com.jskj.wisdom.config.common.Global;
import com.jskj.wisdom.enums.UserEnum;
import com.jskj.wisdom.exception.UserException;
import com.jskj.wisdom.model.system.SysPermission;
import com.jskj.wisdom.model.system.SysRole;
import com.jskj.wisdom.model.system.SysUser;
import com.jskj.wisdom.service.system.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.config.shiro
 * @description
 * @date 2018-05-23 16:52 Wed
 */
public class ShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysUserServer sysUserServer;

    @Resource
    private SysUserRoleServer sysUserRoleServer;

    @Resource
    private SysRoleServer sysRoleServer;

    @Resource
    private SysRolePermissionServer sysRolePermissionServer;

    @Resource
    private SysPermissionServer sysPermissionServer;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo+" + principalCollection.toString());

        SysUser sysUser = new SysUser();
        sysUser.setLoginName((String) principalCollection.getPrimaryPrincipal());
        List<SysUser> sysUsers = sysUserServer.selectBySelective(sysUser);
        if (sysUsers.size() == 0) {
            throw new UserException(UserEnum.NOT_FOUND);
        }
        if (sysUsers.size() > 1) {
            throw new UserException(UserEnum.LOGIN_NAME_NOT_UNIQUE);
        }
        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(sysUsers.get(0).getId()), SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        List<SysRole> sysRoles = sysRoleServer.selectRolesByUserId(sysUsers.get(0).getId());

        //赋予角色
        for (SysRole sysRole : sysRoles) {
            authorizationInfo.addRole(sysRole.getName());
        }

        List<SysPermission> sysPermissions = sysPermissionServer.selectPermissionByUserId(sysUsers.get(0).getId());

        //赋予权限
        for (SysPermission sysPermission : sysPermissions) {
            authorizationInfo.addStringPermission(sysPermission.getName());
        }

        //更新登录状态等
        sysUsers.get(0).setLoginFlag(Global.ONE_STRING);
        sysUserServer.updateByPrimaryKeySelective(sysUsers.get(0));

        //记录登录日志
        logger.info("权限认证登录成功:" + sysUsers.get(0).toString());
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo +" + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String userName = token.getUsername();

        // 校验用户名密码
        SysUser sysUser = new SysUser();
        sysUser.setLoginName(userName);
        List<SysUser> sysUsers = sysUserServer.selectBySelective(sysUser);
        if (sysUsers.size() == 0) {
            throw new UserException(UserEnum.NOT_FOUND);
        }
        if (sysUsers.size() > 1) {
            throw new UserException(UserEnum.LOGIN_NAME_NOT_UNIQUE);
        }
        if (Global.ONE_STRING.equals(sysUsers.get(0).getIsDelete())) {
            throw new UserException(UserEnum.PROHIBIT_LANDING);
        }
        String md5Salt = DigestUtils.md5Hex(Global.MD5_SALT + sysUsers.get(0).getPassword());

        //设置用户session
        Session session = SecurityUtils.getSubject().getSession();
//        session.setAttribute("user", sysUsers.get(0));
        return new SimpleAuthenticationInfo(sysUsers.get(0), Global.MD5_SALT + sysUsers.get(0).getPassword(), ByteSource.Util.bytes(md5Salt), getName());
    }
}