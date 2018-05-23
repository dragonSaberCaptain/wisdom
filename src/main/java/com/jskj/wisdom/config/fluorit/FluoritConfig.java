package com.jskj.wisdom.config.fluorit;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.config.fluorit
 * @description
 * @date 2018-05-07 15:21 星期一
 */
public class FluoritConfig {
    public String appkey    = "207b530adc7944559bb185464517a1f8";
    public String appsecret = "e04f6074a1cdfd7d305531a70dcd484f";

    public String getTokenUrl        = "https://open.ys7.com/api/lapp/token/get";
    public String tokenUrlParameters = "appKey=" + appkey + "&appSecret=" + appsecret;

    public String getAccountUrl = "https://open.ys7.com/api/lapp/ram/account/create";

}
