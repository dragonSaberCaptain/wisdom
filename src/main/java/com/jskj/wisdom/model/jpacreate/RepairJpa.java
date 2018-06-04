package com.jskj.wisdom.model.jpacreate;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom.model.jpacreate
 * //TODO
 * @date 2018-06-08 10:12 星期五
 */
@Entity
@Table(name = "s_repair")
public class RepairJpa extends BaseModel {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "datetime COMMENT '预约时间'")
    private Date appointmentTime;

    @Column(columnDefinition = "varchar(255) COMMENT '描述'")
    private String depict;

    @Column(columnDefinition = "varchar(255) COMMENT '地点'")
    private String place;

    @Column(columnDefinition = "varchar(16) COMMENT '状态'")
    private String status;

    @Column(columnDefinition = "varchar(64) COMMENT '报修标题'")
    private String title;

    @Column(columnDefinition = " bigint(20) COMMENT '用户id'")
    private Long userId;
}
