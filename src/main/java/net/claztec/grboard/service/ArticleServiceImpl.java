package net.claztec.grboard.service;

import net.claztec.grboard.dao.ArticleDao;
import net.claztec.grboard.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Derek Choi on 15. 4. 25.
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> getArticleListAll() {
        return articleDao.findAll();
    }

    @Override
    public Article getArticle(String articleId) {
        return articleDao.findById(articleId);
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.update(article);
    }

    @Override
    public void removeArticle(String articleId) {
        articleDao.removeById(articleId);
    }

    @Override
    public Article addArticle(Article article) {
        return articleDao.add(article);
    }
}
