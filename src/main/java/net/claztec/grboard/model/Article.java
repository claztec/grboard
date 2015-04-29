package net.claztec.grboard.model;

import org.hibernate.validator.constraints.NotBlank;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    private Date date;

    private Time time;

    private String dateOrTime;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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

    public String getDateOrTime() {
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );

        String registorDate = date.toString();
        String today = format.format(new Date());

        if (today.equals(registorDate)) {
            dateOrTime = time.toString();
        } else {
            dateOrTime = registorDate;
        }
        return dateOrTime;
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
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
