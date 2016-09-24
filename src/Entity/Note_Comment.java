package Entity;

import javax.persistence.*;

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
    //帖子评论内容
    private String note_comment_content;
    //帖子评论者id
    private User note_comment_user;
    //帖子被评论者id
    private User note_commented_user;

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

    @OneToOne
    @JoinColumn(name = "note_commented_user_id")
    public User getNote_commented_user() {
        return note_commented_user;
    }

    public void setNote_commented_user(User note_commented_user) {
        this.note_commented_user = note_commented_user;
    }
}
