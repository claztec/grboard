package net.claztec.grboard.service;

import net.claztec.grboard.config.ApplicationConfig;
import net.claztec.grboard.exception.DataNotFoundException;
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
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

/**
 * Created by Derek Choi on 15. 4. 25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class}, loader = SpringApplicationContextLoader.class)
public class ArticleServiceTest {
    private static final Logger log = LoggerFactory.getLogger(ArticleServiceTest.class);

    @Autowired
    private ArticleService articleService;

    /*
       - 글 등록
        - 글 조회
        - 글 목록
        - 글 삭제
        - 글 수정
     */


    @Test
    public void testGetArticleListAll() {
        assertNotNull(articleService);

        List<Article> list = articleService.getArticleListAll();
        assertNotNull(list);

        list.forEach(value -> log.debug(value.toString()));
    }

    @Test
    public void testGetArticle() {
        String articleId = "1";
        Article article = articleService.getArticle(articleId);
        assertThat(article.getArticleId(), is(articleId));

    }

    @Test
    @Transactional
    public void testUpdateArticle() {
        String articleId = "1";
        Article beforeArticle = articleService.getArticle(articleId);
        int beforeHitCount = beforeArticle.getHit();
        assertThat(beforeArticle.getArticleId(), is(articleId));
        beforeArticle.setHit(beforeHitCount + 1);
        articleService.updateArticle(beforeArticle);
        Article afterArticle = articleService.getArticle(articleId);
        assertThat(afterArticle.getHit(), greaterThan(beforeHitCount));

    }

    @Test(expected = DataNotFoundException.class)
    @Transactional
    public void testRemoveArticle() {
        String articleId = "9";
        articleService.removeArticle(articleId);
        Article article = articleService.getArticle(articleId);
    }

    @Test
    @Repeat(100000)
    public void testAddArticle() {
        String title = "게시판 테스트";
        String contents = "게시판 테스트. \n 줄바꿈 해서 한줄.";
        Article article = new Article();
        article.setTitle(title);
        article.setContents(contents);
        Article afterArticle = articleService.addArticle(article);
        assertThat(afterArticle.getTitle(), is(article.getTitle()));
        log.debug(afterArticle.toString());
    }

    @Test
    public void dateCal() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );

        String date1 = "2015-04-28";
        String date2 = format.format(new Date());

        boolean result = date1.equals(date2);
        System.out.println(result);
    }
}
