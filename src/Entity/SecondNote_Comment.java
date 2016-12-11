package Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 帖子二次评论实体类(评论下的回复)
 */
@Entity
@Table(name = "second_Note_comment",schema = "xinli")
public class SecondNote_Comment {
    //二次评论id
    private Long id;
    //用户id
    private User user;
    //二次评论内容
    private String comment_content;
    //评论时间
    private Date comment_date;
    //被评论的评论id
    private Note_Comment note_comment;
    //帖子id
    private Note note;

    public SecondNote_Comment() {
    }

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "comment_content")
    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }
    @Column(name = "comment_date")
    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }
    @OneToOne
    @JoinColumn(name = "note_comment_id")
    public Note_Comment getNote_comment() {
        return note_comment;
    }

    public void setNote_comment(Note_Comment note_comment) {
        this.note_comment = note_comment;
    }
    @OneToOne
    @JoinColumn(name = "note_id")
    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
