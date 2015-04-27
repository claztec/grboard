package net.claztec.grboard.model;

import org.hibernate.validator.constraints.NotBlank;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Derek Choi on 15. 4. 12.
 */

public class Article {

    private String articleId;

    @NotBlank(message = "제목을 입력하세요.")
    private String title;

    @NotBlank(message = "내용을 입력하세요.")
    private String contents;

    private int like;

    private int hate;

    private int hit;

    private Timestamp regdttm;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getHate() {
        return hate;
    }

    public void setHate(int hate) {
        this.hate = hate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public Timestamp getRegdttm() {
        return regdttm;
    }

    public void setRegdttm(Timestamp regdttm) {
        this.regdttm = regdttm;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", like=" + like +
                ", hate=" + hate +
                ", hit=" + hit +
                ", regdttm=" + regdttm +
                '}';
    }

    public void upHit() {
        this.hit++;
    }


    public void upHate() {
        this.hate++;
    }

    public void upLike() {
        this.like++;
    }
}
