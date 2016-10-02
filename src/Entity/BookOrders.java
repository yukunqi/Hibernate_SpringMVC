package Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 预约订单类
 */
@Entity
@Table(name = "bookorders",schema = "xinli")
public class BookOrders {

    private Long id;
    private Date book_time;
    private String description;
    private String people_call;
    private int age;
    private String gender;
    private String phonenumber;
    private User user;
    private Expert expert;


    public BookOrders() {
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

    @Column(name = "age",nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Column(name = "people_call",nullable = false)
    public String getPeople_call() {
        return people_call;
    }

    public void setPeople_call(String people_call) {
        this.people_call = people_call;
    }

    @Column(name = "gender",nullable = false)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "phonenumber",nullable = false)
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "expert_id")
    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }
}
