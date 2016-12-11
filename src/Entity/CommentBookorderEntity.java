package Entity;

import java.text.SimpleDateFormat;

/**
 * 评价的咨询订单实体类
 */
public class CommentBookorderEntity {
    //名字
    private String name;
    //头像
    private String profile;
    //用户类型
    private String user_type;
    //用户机构(可能学院 或者其他)
    private String college;
    //订单创建时间
    private String book_time;
    //咨询时长
    private String duration_time;
    //被评价用户的id
    private Long user_id;
    //好评率
    private double good_comment;
    //咨询人数
    private int cousult_number;

    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-HH-dd HH:mm:ss");

    public UncommentBookorderEntity() {
    }

    public UncommentBookorderEntity(String name, String profile, String user_type, String college, String book_time, String duration_time, Long user_id, double good_comment, int cousult_number) {
        this.name = name;
        this.profile = profile;
        this.user_type = user_type;
        this.college = college;
        this.book_time = book_time;
        this.duration_time = duration_time;
        this.user_id = user_id;
        this.good_comment = good_comment;
        this.cousult_number = cousult_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getBook_time() {
        return book_time;
    }

    public void setBook_time(String book_time) {
        this.book_time = book_time;
    }

    public String getDuration_time() {
        return duration_time;
    }

    public void setDuration_time(String duration_time) {
        this.duration_time = duration_time;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public double getGood_comment() {
        return good_comment;
    }

    public void setGood_comment(double good_comment) {
        this.good_comment = good_comment;
    }

    public int getCousult_number() {
        return cousult_number;
    }

    public void setCousult_number(int cousult_number) {
        this.cousult_number = cousult_number;
    }
}
