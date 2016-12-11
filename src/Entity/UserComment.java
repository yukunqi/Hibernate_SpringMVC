package Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户评论表 实体类 包含 学生对老师 老师对学生的评价数据
 */
@Entity
@Table(name = "user_comment",schema = "xinli")
public class UserComment {
    //id
    private Long id;
    //评论创建时间
    private Date comment_date;
    //评论的好坏程度
    private Level_type level;
    //评论内容
    private String comment;
    //是否匿名
    private int anonymous;
    //主评论人
    private User main_user_id;
    //被评论人
    private User sub_user_id;
    //咨询订单id
    private BookOrders book_id;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "comment_date")
    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    @Column(name = "anonymous")
    public int getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(int anonymous) {
        this.anonymous = anonymous;
    }
    @OneToOne
    @JoinColumn(name = "main_user_id")
    public User getMain_user_id() {
        return main_user_id;
    }

    public void setMain_user_id(User main_user_id) {
        this.main_user_id = main_user_id;
    }

    @OneToOne
    @JoinColumn(name = "sub_user_id")
    public User getSub_user_id() {
        return sub_user_id;
    }

    public void setSub_user_id(User sub_user_id) {
        this.sub_user_id = sub_user_id;
    }

    @OneToOne
    @JoinColumn(name = "book_id")
    public BookOrders getBook_id() {
        return book_id;
    }

    public void setBook_id(BookOrders book_id) {
        this.book_id = book_id;
    }

    @OneToOne
    @JoinColumn(name = "level")
    public Level_type getLevel() {
        return level;
    }

    public void setLevel(Level_type level) {
        this.level = level;
    }
}
