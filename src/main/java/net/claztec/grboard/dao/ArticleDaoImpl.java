package net.claztec.grboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by claztec on 15. 4. 10.
 */

@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getTest() {

        String title = jdbcTemplate.queryForObject("select title from article where articleid = ?", new Object[] {"1"}, String.class);


        return title;
    }
}
