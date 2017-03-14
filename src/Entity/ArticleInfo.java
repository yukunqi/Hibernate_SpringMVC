package Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文章信息实体类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleInfo {

    private Long article_id;
    private String article_title;
    private String article_build_date;
    private String article_picture;
    private String author;
    private int watched_num;
    private int good_num;
    private int comment_num;
    private String article_markdown;
    private String article_content;

    private static SimpleDateFormat format;
    static {
        format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    public ArticleInfo() {
    }

    /**
     * 获取文章的内容 进行文章展示
     * @param author
     * @param article_id
     * @param article_title
     * @param comment_num
     * @param good_num
     * @param watched_num
     * @param article_build_date
     * @param article_content
     */
    public ArticleInfo(String author, Long article_id, String article_title, int comment_num, int good_num, int watched_num, Date article_build_date, String article_content) {
        this.author = author;
        this.article_id = article_id;
        this.article_title = article_title;
        this.comment_num = comment_num;
        this.good_num = good_num;
        this.watched_num = watched_num;
        this.article_build_date = format.format(article_build_date);
        this.article_content = article_content;
    }

    public ArticleInfo(Long article_id, String article_title, Date article_build_date, String article_picture, int watched_num, int good_num) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.article_build_date = format.format(article_build_date);
        this.article_picture = article_picture;
        this.watched_num = watched_num;
        this.good_num = good_num;
    }

    /**
     * 获取文章的markdown进行文章编辑
     * @param article_id
     * @param article_title
     * @param article_markdown
     */
    public ArticleInfo(Long article_id, String article_title, String article_markdown) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.article_markdown = article_markdown;
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

    public String  getArticle_build_date() {
        return article_build_date;
    }

    public void setArticle_build_date(String article_build_date) {
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

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public String getArticle_markdown() {
        return article_markdown;
    }

    public void setArticle_markdown(String article_markdown) {
        this.article_markdown = article_markdown;
    }
}
