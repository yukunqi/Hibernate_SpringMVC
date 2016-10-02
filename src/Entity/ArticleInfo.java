package Entity;

import java.util.Date;

/**
 * 文章信息实体类
 */
public class ArticleInfo {

    private Long article_id;
    private String article_title;
    private Date article_build_date;
    private String article_picture;
    private int watched_num;
    private int good_num;

    public ArticleInfo() {
    }

    public ArticleInfo(Long article_id, String article_title, Date article_build_date, String article_picture, int watched_num, int good_num) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.article_build_date = article_build_date;
        this.article_picture = article_picture;
        this.watched_num = watched_num;
        this.good_num = good_num;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public Date getArticle_build_date() {
        return article_build_date;
    }

    public void setArticle_build_date(Date article_build_date) {
        this.article_build_date = article_build_date;
    }

    public String getArticle_picture() {
        return article_picture;
    }

    public void setArticle_picture(String article_picture) {
        this.article_picture = article_picture;
    }

    public int getWatched_num() {
        return watched_num;
    }

    public void setWatched_num(int watched_num) {
        this.watched_num = watched_num;
    }

    public int getGood_num() {
        return good_num;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }
}
