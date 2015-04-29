package net.claztec.grboard.service;

import net.claztec.grboard.model.Article;

import java.util.List;

/**
 * Created by Derek Choi on 15. 4. 25.
 */
public interface ArticleService {
    List<Article> getArticleListAll();

    Article getArticle(String articleId);

    void updateArticle(Article beforeArticle);

    void removeArticle(String articleId);

    Article addArticle(Article article);

    void upHitCount(Article article);
}
