package net.claztec.grboard.dao;

import net.claztec.grboard.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<Article> findAll() {
        return jdbcTemplate.query("select * from article", new ArticleRowMapper());
    }

    @Override
    public int removeById(String articleId) {
        return jdbcTemplate.update("delete from article where articleid = ?", new Object[]{articleId});
    }

    @Override
    public int update(Article article) {
        return jdbcTemplate.update("update article set title=?, contents=?, likecount=?, hatecount=?, hitcount=? where articleid=?",
                new Object[] {article.getTitle(), article.getContents(), article.getLike(), article.getHate(), article.getHit(), article.getArticleId()});
    }

    private static final class ArticleRowMapper implements RowMapper<Article> {
        @Override
        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
            Article article = new Article();
            article.setArticleId(rs.getString("articleid"));
            article.setTitle(rs.getString("title"));
            article.setContents(rs.getString("contents"));
            article.setLike(rs.getInt("likecount"));
            article.setHate(rs.getInt("hatecount"));
            article.setHit(rs.getInt("hitcount"));
            article.setRegdttm(rs.getDate("regdttm"));
            return article;
        }
    }
}