package Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPersonalPage {

    //用户昵称
    private String name;
    //用户学院
    private String college;
    //用户学校
    private String school_name;
    //用户头像
    private String profile;
    //用户性别
    private String gender;
    //用户简介
    private String introduction;
    //评价实体
    private Expert_comment_item item;
    //用户id
    private Long id;
    //用户年级
    private String grade;
    //用户email
    private String email;
    //用户电话号码
    private String phone_number;
    //用户微信
    private String wechat;


    public UserPersonalPage() {
    }

    /*
      用于普通学生用户的资料编辑
    */
    public UserPersonalPage(Long id, String name, String college, String grade, String gender, String profile, String school_name, String introduction, String email, String phone_number, String wechat) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.grade = grade;
        this.gender = gender;
        this.profile = profile;
        this.school_name = school_name;
        this.introduction = introduction;
        this.email = email;
        this.phone_number = phone_number;
        this.wechat = wechat;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public UserPersonalPage(Expert_comment_item item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Expert_comment_item getItem() {
        return item;
    }

    public void setItem(Expert_comment_item item) {
        this.item = item;
    }
}
