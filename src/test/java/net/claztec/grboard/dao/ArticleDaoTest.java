package net.claztec.grboard.dao;

import net.claztec.grboard.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by claztec on 15. 4. 10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationConfig.class}, loader = SpringApplicationContextLoader.class)
public class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void getArticleId() {
        String title = articleDao.getTest();
        assertThat(title, is("테스트"));
    }
}