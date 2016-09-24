package Entity;

import javax.persistence.*;

/**
 * 文章评论实体类
 */
@Entity
@Table(name = "article_Comment",schema = "xinli")
public class Article_Comment {

    //文章评论id
    private Long article_comment_id;
    //文章id
    private Article article;
    //文章评论内容
    private String article_comment_content;
    //评论者id
    private User commentUser;
    //被评论者id
    private User commentedUser;

    public Article_Comment() {
    }

    @Id
    @GeneratedValue
    public Long getArticle_comment_id() {
        return article_comment_id;
    }

    public void setArticle_comment_id(Long article_comment_id) {
        this.article_comment_id = article_comment_id;
    }

    @OneToOne
    @JoinColumn(name = "article_id",nullable = false)
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Column(name = "article_comment_content",nullable = false)
    public String getArticle_comment_content() {
        return article_comment_content;
    }

    public void setArticle_comment_content(String article_comment_content) {
        this.article_comment_content = article_comment_content;
    }

    @OneToOne
    @JoinColumn(name = "commentUser_id",nullable = false)
    public User getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }

    @OneToOne
    @JoinColumn(name = "commentedUser_id")
    public User getCommentedUser() {
        return commentedUser;
    }

    public void setCommentedUser(User commentedUser) {
        this.commentedUser = commentedUser;
    }
}
