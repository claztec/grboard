package net.claztec.grboard.service;

import net.claztec.grboard.dao.ArticleDao;
import net.claztec.grboard.model.Article;
import net.claztec.grboard.model.Page;
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
    public List<Article> getArticleListAll(Page page) {
        List<Article> articleList = articleDao.findAll(page);
        int totalCount = articleDao.totalCount();
        page.setTotalItemCount(totalCount);
        return articleList;
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
        return articleDao.insert(article);
    }

    @Override
    public void upHitCount(Article article) {
        articleDao.upHitCount(article.getArticleId());
    }
}
