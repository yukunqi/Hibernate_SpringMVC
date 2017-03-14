package Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 预约订单类
 */
@Entity
@Table(name = "bookorders",schema = "xinli")
public class BookOrders {
    //id
    private Long id;
    //预约创建时间
    private Date book_time;
    //问题描述
    private String description;
    //预约的用户
    private User user_id;
    //被预约的专家用户
    private User expert_user_id;
    //咨询持续时长
    private String duration_time;
    //学生评价状态
    private int book_user_status;
    //老师评价状态
    private int book_expert_status;


    public BookOrders() {
    }

    public BookOrders(Long id,Date book_time, String duration_time) {
        this.id=id;
        this.book_time = book_time;
        this.duration_time = duration_time;
    }

    public BookOrders(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "book_time",nullable = false)
    public Date getBook_time() {
        return book_time;
    }

    public void setBook_time(Date book_time) {
        this.book_time = book_time;
    }

    @Column(name = "description",nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name = "duration_time")
    public String getDuration_time() {
        return duration_time;
    }

    public void setDuration_time(String duration_time) {
        this.duration_time = duration_time;
    }


    @OneToOne
    @JoinColumn(name = "user_id")
    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @OneToOne
    @JoinColumn(name = "expert_user_id")
    public User getExpert_user_id() {
        return expert_user_id;
    }

    public void setExpert_user_id(User expert_user_id) {
        this.expert_user_id = expert_user_id;
    }

    @Column(name = "book_user_status")
    public int getBook_user_status() {
        return book_user_status;
    }

    public void setBook_user_status(int book_user_status) {
        this.book_user_status = book_user_status;
    }

    @Column(name = "book_expert_status")
    public int getBook_expert_status() {
        return book_expert_status;
    }

    public void setBook_expert_status(int book_expert_status) {
        this.book_expert_status = book_expert_status;
    }
}
