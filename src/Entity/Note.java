package Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 帖子实体类
 */
@Entity
@Table(name = "note",schema = "xinli")
public class Note {

    private Long note_id;
    private User user;
    private String note_content;
    private Date note_buildtime;
    private int note_reply_num;
    private String note_title;
    private int note_anonymous;
    private int note_good_num;

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
}
