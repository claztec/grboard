package net.claztec.grboard.dao;

import net.claztec.grboard.model.Article;

/**
 * Created by claztec on 15. 4. 10.
 */
public interface ArticleDao {
    String getTest();

    Article add(Article article);

    Article findById(String articleId);
}
