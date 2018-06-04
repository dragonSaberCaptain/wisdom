import com.jskj.wisdom.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    @Test
    public void Test() {
    }
}