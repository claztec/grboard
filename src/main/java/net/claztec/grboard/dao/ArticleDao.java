package net.claztec.grboard.dao;

import net.claztec.grboard.model.Article;

import java.util.List;

/**
 * Created by claztec on 15. 4. 10.
 */
public interface ArticleDao {

    Article insert(Article article);

    Article findById(String articleId);

    List<Article> findAll();

    int removeById(String articleId);

    int update(Article article);

    int upHitCount(String articleId);
}
