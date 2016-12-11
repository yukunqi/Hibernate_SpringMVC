package Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 帖子实体类
 */
@Entity
@Table(name = "note",schema = "xinli")
public class Note {

    //帖子id
    private Long note_id;
    //发布帖子用户id
    private User user;
    //帖子内容
    private String note_content;
    //帖子创建时间
    private Date note_buildtime;
    //帖子评论数
    private int note_reply_num;
    //帖子标题
    private String note_title;
    //帖子是否匿名
    private int note_anonymous;
    //帖子点赞数
    private int note_good_num;
    //帖子浏览数
    private int watched_num;

    public Note() {
    }

    @Id
    @GeneratedValue
    public Long getNote_id() {
        return note_id;
    }

    public void setNote_id(Long note_id) {
        this.note_id = note_id;
    }

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "note_content",nullable = false)
    public String getNote_content() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content = note_content;
    }

    @Column(name = "note_buildtime",nullable = false)
    public Date getNote_buildtime() {
        return note_buildtime;
    }

    public void setNote_buildtime(Date note_buildtime) {
        this.note_buildtime = note_buildtime;
    }

    @Column(name = "note_reply_num",nullable = false,columnDefinition = "INT default 0")
    public int getNote_reply_num() {
        return note_reply_num;
    }

    public void setNote_reply_num(int note_reply_num) {
        this.note_reply_num = note_reply_num;
    }

    @Column(name = "note_title",nullable = false)
    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    @Column(name = "note_anonymous",nullable = false,columnDefinition = "INT default 0")
    public int getNote_anonymous() {
        return note_anonymous;
    }

    public void setNote_anonymous(int note_anonymous) {
        this.note_anonymous = note_anonymous;
    }

    @Column(name = "note_good_num",nullable = false,columnDefinition = "INT default 0")
    public int getNote_good_num() {
        return note_good_num;
    }

    public void setNote_good_num(int note_good_num) {
        this.note_good_num = note_good_num;
    }

    @Column(name = "comment_watched_num",columnDefinition = "INT default 0")
    public int getWatched_num() {
        return watched_num;
    }

    public void setWatched_num(int watched_num) {
        this.watched_num = watched_num;
    }
}
