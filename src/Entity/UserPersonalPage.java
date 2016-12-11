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

    public UserPersonalPage() {
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
