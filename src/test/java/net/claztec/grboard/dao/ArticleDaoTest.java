package net.claztec.grboard.dao;

import net.claztec.grboard.config.ApplicationConfig;
import net.claztec.grboard.exception.DataNotFoundException;
import net.claztec.grboard.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Created by claztec on 15. 4. 10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class}, loader = SpringApplicationContextLoader.class)
public class ArticleDaoTest {

    private static final Logger log = LoggerFactory.getLogger(ArticleDaoTest.class);

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void getArticleId() {
        // 1. article dao 만들기
        // 2. article dao에서 테스트 메소드 호출하기.
        // 3. 테스트 메소드는 db연결이 되어있어야함.

        String title = articleDao.getTest();
        assertThat(title, is("테스트"));
    }

    /*
        - 글 등록
        - 글 조회
        - 글 목록
        - 글 삭제
        - 글 수정
     */

    @Test
    public void testAddArticle() {
        Article article = new Article();
        article.setTitle("test");
        article.setContents("content");
        Article insertedArticle = articleDao.add(article);
        assertThat(article.getTitle(), is(insertedArticle.getTitle()));
    }

    @Test
    public void testFindArticleById() {
        log.debug("@@ START @@");
        String articleId = "1";
        Article article = articleDao.findById(articleId);
        assertThat(article.getArticleId(), is(articleId));
        log.debug(article.toString());
    }

    @Test(expected = DataNotFoundException.class)
    public void testFindEmptyData() {
        String articleId = "111";
        Article article = articleDao.findById(articleId);
        assertThat(article.getArticleId(), is(articleId));
        log.debug(article.toString());
    }

    @Test
    public void testFindAll() {
        List<Article> articleList = articleDao.findAll();
        assertThat(articleList.size(), greaterThan(0));
        for(Article article : articleList) {
            log.debug(article.toString());
        }
    }

    @Test
    public void testRemoveById() {
        List<Article> articleList = articleDao.findAll();

        int length = articleList.size();
        assertThat(length, greaterThan(0));
        Article article = articleList.get(length - 1);
        int count = articleDao.removeById(article.getArticleId());
        assertThat(count, is(1));
    }

    @Test(expected = DataNotFoundException.class)
    public void testRemoveEmptyData() {
        String id = "15";
        int count = articleDao.removeById(id);
        assertThat(count, is(1));
    }

    @Test
    public void testUpdateById() {
        List<Article> articleList = articleDao.findAll();

        int length = articleList.size();
        assertThat(length, greaterThan(0));
        Article article = articleList.get(length - 1);

        article.setTitle("Change Title");
        article.upHit();
        article.upHate();
        article.upLike();
        article.setContents("Change Contents");
        int count = articleDao.update(article);
        assertThat(count, is(1));
    }

}