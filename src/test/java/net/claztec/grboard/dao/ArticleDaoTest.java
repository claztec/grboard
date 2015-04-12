package net.claztec.grboard.dao;

import net.claztec.grboard.config.ApplicationConfig;
import net.claztec.grboard.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by claztec on 15. 4. 10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationConfig.class}, loader = SpringApplicationContextLoader.class)
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
}