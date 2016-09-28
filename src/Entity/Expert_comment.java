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
    //评论内容
    private String comment;
    //好坏程度
    private int level;
    //评论时间
    private Date comment_time;
    private Expert expert;
    //咨询师id
    private Long expert_id;
    //用户id
    private Long user_id;

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
    @JoinColumn(name = "user_id")
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
    @JoinColumn(name = "expert_id")
    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    @Transient
    public Long getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(Long expert_id) {
        this.expert_id = expert_id;
    }

    @Transient
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
