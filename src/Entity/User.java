package Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 普通实体类
 */
@Entity
@Table(name = "user",schema = "xinli")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    private Long id;
    //登录名
    private String login_name;
    //密码
    private String password;
    //头像
    private String profile;
    //昵称
    private String username;
    //性别
    private String gender;
    //简介
    private String introduction;
    //学校名称
    private String school_name;
    //学院
    private String college;
    //邮箱
    private String email;
    //电话号码
    private String phone_number;
    //权限
    private int authority;
    //年级
    private String grade;
    //微信号
    private String wechat;
    //用户类型
    private UserType userType;

    public User() {
    }

    public User(Long id, String username, String profile, String gender, String introduction, String school_name, String college) {
        this.id = id;
        this.username = username;
        this.profile = profile;
        this.gender = gender;
        this.introduction = introduction;
        this.school_name = school_name;
        this.college = college;
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String login_name) {
        this.login_name = login_name;
    }

    public User(String login_name, String password) {
        this.login_name = login_name;
        this.password = password;
    }


    public User(String login_name, String password,Long id) {
        this.id = id;
        this.login_name = login_name;
        this.password = password;
    }

    public User(String login_name, String password, Long id, UserType userType) {
        this.login_name = login_name;
        this.password = password;
        this.id = id;
        this.userType = userType;
    }

    public User(String login_name, String password, String username, Long id,UserType userType) {
        this.login_name = login_name;
        this.password = password;
        this.username = username;
        this.id = id;
        this.userType = userType;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "login_name",nullable = false)
    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "profile")
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Column(name = "school_name")
    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    @Column(name = "college")
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone_number")
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Column(name = "authority")
    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    @Column(name = "grade")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    @Column(name = "wechat")
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @OneToOne
    @JoinColumn(name = "user_type")
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
