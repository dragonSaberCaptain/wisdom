package com.jskj.wisdom.config.web;

import com.jskj.wisdom.filter.ApiInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom
 * @description
 * @date 2018-05-07 13:47 星期一
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> stringList = new ArrayList<>();
        stringList.add("/open/**");
        stringList.add("/webjars/**");
        stringList.add("/swagger-resources/**");
        stringList.add("/swagger-ui.html");
        stringList.add("/static/**");
        //拦截规则：除了open，其他都拦截判断
        registry.addInterceptor(new ApiInterceptor()).addPathPatterns("/**").excludePathPatterns(stringList);
    }
}
