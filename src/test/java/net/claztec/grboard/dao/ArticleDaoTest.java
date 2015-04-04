package net.claztec.grboard.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by claztec on 15. 4. 4.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/grboard-context.xml")
public class ArticleDaoTest {

    private static final Logger log = LoggerFactory.getLogger(ArticleDaoTest.class);

    @Test
    public void test() {
        log.debug("@@ Hello World @@");
    }
}
