package Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 文章实体类
 */
@Entity
@Table(name = "article",schema = "xinli")
public class Article {

    //文章id
    private Long article_id;
    //文章标题
    private String article_title;
    //文章创建时间
    private Date build_date;
    //作者id 外键
    private User user;
    //阅读数
    private int watched_num;
    //评论数
    private int comment_num;
    //点赞数
    private int good_num;
    //文章内容
    private String article_content;
    //文章配图
    private String article_picture;

    public Article() {
    }

    public Article(Long article_id, String article_title, Date build_date, String article_picture, int watched_num, int good_num) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.build_date = build_date;
        this.article_picture = article_picture;
        this.watched_num = watched_num;
        this.good_num = good_num;
    }

    @Id
    @GeneratedValue
    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    @Column(name = "article_title",nullable = false)
    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    @Column(name = "build_date",nullable = false)
    public Date getBuild_date() {
        return build_date;
    }

    public void setBuild_date(Date build_date) {
        this.build_date = build_date;
    }

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "watched_num",nullable = false)
    public int getWatched_num() {
        return watched_num;
    }

    public void setWatched_num(int watched_num) {
        this.watched_num = watched_num;
    }

    @Column(name = "comment_num",nullable = false)
    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    @Column(name = "good_num",nullable = false)
    public int getGood_num() {
        return good_num;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }

    @Column(name = "article_content",nullable = false)
    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    @Column(name = "article_picture",nullable = false)
    public String getArticle_picture() {
        return article_picture;
    }

    public void setArticle_picture(String article_picture) {
        this.article_picture = article_picture;
    }
}
