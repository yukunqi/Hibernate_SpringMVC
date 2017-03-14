package Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 老师实体类的全部字段数据
 * 用于编辑老师的个人信息
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpertPersonalData {

    private long user_id;

    private String page_picture;

    private String motto;

    private long id;

    private String college;

    private String gender;

    private String grade;

    private String introduction;

    private String login_name;

    private String profile;

    private String school_name;

    private String username;

    private String email;

    private String phone_number;

    private String wechat;

    private long user_type;

    public ExpertPersonalData() {
    }
    /*
     用于老师个人资料编辑
     */
    public ExpertPersonalData(long id, String motto, String page_picture, long user_id, String college, String gender, String grade, String introduction, String login_name, String profile, String school_name, String username, String email, String phone_number, String wechat, long user_type) {
        this.id = id;
        this.motto = motto;
        this.page_picture = page_picture;
        this.user_id = user_id;
        this.college = college;
        this.gender = gender;
        this.grade = grade;
        this.introduction = introduction;
        this.login_name = login_name;
        this.profile = profile;
        this.school_name = school_name;
        this.username = username;
        this.email = email;
        this.phone_number = phone_number;
        this.wechat = wechat;
        this.user_type = user_type;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getPage_picture() {
        return page_picture;
    }

    public void setPage_picture(String page_picture) {
        this.page_picture = page_picture;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public long getUser_type() {
        return user_type;
    }

    public void setUser_type(long user_type) {
        this.user_type = user_type;
    }
}
