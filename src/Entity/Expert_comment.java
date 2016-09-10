package Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 咨询师评价实体类
 */
@Entity
@Table(name = "expert_comment",schema = "xinli")
public class Expert_comment {
    private Long id;
    private User user;
    private String comment;
    private int level;
    private Date comment_time;
    private Expert expert;

    public Expert_comment() {
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "user_id",unique = true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "comment",nullable = false)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "level",nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Column(name = "comment_time",nullable = false)
    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    @OneToOne
    @JoinColumn(name = "expert_id",unique = true)
    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }
}
