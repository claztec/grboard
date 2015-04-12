package net.claztec.grboard.dao;

import net.claztec.grboard.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by claztec on 15. 4. 10.
 */

@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getTest() {

        String title = jdbcTemplate.queryForObject("select title from article where articleid = ?", new Object[]{"1"}, String.class);


        return title;
    }

    @Override
    public Article add(Article article) {
        jdbcTemplate.update("insert into article (title, contents, regdttm) values (?, ?, ?)", new Object[]{article.getTitle(), article.getContents(), new Date()});
        return article;
    }

    @Override
    public Article findById(String articleId) {
        return jdbcTemplate.queryForObject("select * from article where articleid = ?", new Object[]{articleId}, new ArticleRowMapper());
    }

    private static final class ArticleRowMapper implements RowMapper<Article> {
        @Override
        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
            Article article = new Article();
            article.setArticleId(rs.getString("articleid"));
            article.setTitle(rs.getString("title"));
            article.setContents(rs.getString("contents"));
            article.setLike(rs.getInt("like"));
            article.setHate(rs.getInt("hate"));
            article.setHit(rs.getInt("hit"));
            article.setRegdttm(rs.getDate("regdttm"));
            return article;
        }
    }
}