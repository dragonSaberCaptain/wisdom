package com.jskj.wisdom.service.impl;

import com.jskj.wisdom.dao.TPcellDAO;
import com.jskj.wisdom.model.TPcell;
import com.jskj.wisdom.service.TPcellService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.service.impl
 * @description
 * @date 2018-05-09 10:25 星期三
 */
@Service
public class TPcellServiceImpl implements TPcellService {
    @Resource
    private TPcellDAO tPcellDAO;

    @Override
    public List<TPcell> selectBySelective(TPcell tPcell) {
        return tPcellDAO.selectBySelective(tPcell);
    }
}
