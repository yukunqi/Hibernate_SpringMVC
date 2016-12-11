package Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 问答帖子评论类
 */
@Entity
@Table(name = "note_Comment",schema = "xinli")
public class Note_Comment {

    //帖子评论id
    private Long note_comment_id;
    //帖子Id
    private Note note;
    //帖子评论时间
    private Date comment_date;
    //帖子评论内容
    private String note_comment_content;
    //帖子评论者id
    private User note_comment_user;
    //帖子评论点赞数
    private int comment_good_num;
    //评论下的二次评论数
    private int second_comment_num;


    public Note_Comment() {
    }

    @OneToOne
    @JoinColumn(name = "note_id",nullable = false)
    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Id
    @GeneratedValue
    public Long getNote_comment_id() {
        return note_comment_id;
    }

    public void setNote_comment_id(Long note_comment_id) {
        this.note_comment_id = note_comment_id;
    }

    @Column(name = "note_comment_content",nullable = false)
    public String getNote_comment_content() {
        return note_comment_content;
    }

    public void setNote_comment_content(String note_comment_content) {
        this.note_comment_content = note_comment_content;
    }

    @OneToOne
    @JoinColumn(name = "note_comment_user_id",nullable = false)
    public User getNote_comment_user() {
        return note_comment_user;
    }

    public void setNote_comment_user(User note_comment_user) {
        this.note_comment_user = note_comment_user;
    }


    @Column(name = "comment_date")
    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    @Column(name = "comment_good_num",columnDefinition = "INT default 0")
    public int getComment_good_num() {
        return comment_good_num;
    }

    public void setComment_good_num(int comment_good_num) {
        this.comment_good_num = comment_good_num;
    }
    @Column(name = "second_comment_num",columnDefinition = "INT default 0")
    public int getSecond_comment_num() {
        return second_comment_num;
    }

    public void setSecond_comment_num(int second_comment_num) {
        this.second_comment_num = second_comment_num;
    }

}
