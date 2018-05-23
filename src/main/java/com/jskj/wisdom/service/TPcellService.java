package com.jskj.wisdom.service;

import com.jskj.wisdom.model.TPcell;

import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service
 * @description
 * @date 2018-05-09 10:08 星期三
 */
public interface TPcellService {

    List<TPcell> selectBySelective(TPcell tPcell);
}
