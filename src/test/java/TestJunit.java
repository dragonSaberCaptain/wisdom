import com.jskj.wisdom.Application;
import com.jskj.wisdom.dao.TUserDAO;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName PACKAGE_NAME
 * @description
 * @date 2018-05-04 9:14 星期五
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestJunit {
    private static final Logger logger = LoggerFactory.getLogger(TestJunit.class);

    @Resource
    private TUserDAO tUserDAO;

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void Test() {
        mongoTemplate.createCollection("flib_1");
        Query    query    = new Query();
        Criteria criteria = Criteria.where("phone").is("13540034037");
        query.addCriteria(criteria);
        mongoTemplate.findOne(query, Document.class);
    }
}