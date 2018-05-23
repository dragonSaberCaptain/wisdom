package com.jskj.wisdom.controller;

import com.jskj.wisdom.enums.ResultEnum;
import com.jskj.wisdom.model.fluorit.AccessTokenModel;
import com.jskj.wisdom.model.fluorit.AccountIdModel;
import com.jskj.wisdom.service.FluoritService;
import com.jskj.wisdom.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.controller
 * @description
 * @date 2018-05-07 16:39 星期一
 */
@Controller
@Api(value = "FluoritController API", description = "萤石云相关接口")
public class FluoritController {
    @Resource
    private FluoritService fluoritService;

    @PostMapping("/fluorit/getSubAccount")
    @ResponseBody
    @ApiOperation(value = "获取萤石云子账户", notes = "通过名称和密码生成子账户")
    @Deprecated
    public ResultVo getSubAccount(@RequestParam(name = "accountName") String accountName,
                                  @RequestParam(name = "password") String password) {
        AccessTokenModel accessTokenModel = fluoritService.getAccessToken(null, null);
        AccountIdModel   accountIdModel   = fluoritService.getAccountId(accessTokenModel.getData().getAccessToken(), accountName, password);
        return new ResultVo(ResultEnum.OK, accountIdModel);
    }

}
