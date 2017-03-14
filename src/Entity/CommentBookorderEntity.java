package Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 待评价的咨询订单实体类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentBookorderEntity implements Serializable {
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
    //咨询订单id
    private Long book_id;
    //被评价用户的id
    private Long user_id;
    //好评率
    private double good_comment;
    //咨询人数
    private int cousult_number;
    //聊天的姓名
    private String main_chat_name;
    //对方的聊天的姓名
    private String sub_chat_name;

    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-HH-dd HH:mm:ss");

    public CommentBookorderEntity() {
    }

    public CommentBookorderEntity(String name, String profile, String user_type, String college, Date book_time, String duration_time, Long user_id, double good_comment, int cousult_number, String main_chat_name) {
        this.name = name;
        this.profile = profile;
        this.user_type = user_type;
        this.college = college;
        this.book_time = simpleDateFormat.format(book_time);
        this.duration_time = duration_time;
        this.user_id = user_id;
        this.good_comment = good_comment;
        this.cousult_number = cousult_number;
        this.main_chat_name = main_chat_name;
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

    public String getSub_chat_name() {
        return sub_chat_name;
    }

    public void setSub_chat_name(String sub_chat_name) {
        this.sub_chat_name = sub_chat_name;
    }

    public String getMain_chat_name() {
        return main_chat_name;
    }

    public void setMain_chat_name(String main_chat_name) {
        this.main_chat_name = main_chat_name;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }
}
