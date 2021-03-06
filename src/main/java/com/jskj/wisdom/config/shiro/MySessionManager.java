//package com.jskj.wisdom.config.shiro;
//
//import com.jskj.wisdom.utils.string.StringUtil;
//import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.apache.shiro.web.util.WebUtils;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.io.Serializable;
//
///**
// * Copyright © 2018 dragonSaberCaptain. All rights reserved.
// *
// * @author dragonSaberCaptain
// * @packageName com.jskj.wisdom.config.shiro
// * //TODO
// * @date 2018-05-25 09:16 星期五
// */
//public class MySessionManager extends DefaultWebSessionManager {
//
//    private static final String AUTHORIZATION = "Authorization";
//
//    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
//
//    public MySessionManager() {
//        super();
//    }
//
//    @Override
//    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
//        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
//        //如果请求头中有 Authorization 则其值为sessionId
//        if (!StringUtil.isBlank(id)) {
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
//            return id;
//        } else {
//            //否则按默认规则从cookie取sessionId
//            return super.getSessionId(request, response);
//        }
//    }
//}