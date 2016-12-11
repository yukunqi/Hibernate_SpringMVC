package Entity;

/**
 * 已评价的咨询订单实体类
 */
public class CommentedBookorderEntity {

    //名字
    private String name;
    //头像
    private String profile;
    //用户类型
    private String user_type;
    //用户机构(可能学院 或者其他)
    private String college;
    //订单中预约咨询的时间
    private String book_time;
    //咨询持续时间
    private String duration_time;
    //评价时间
    private String comment_time;
    //被评价用户的id
    private Long user_id;
    //好评率
    private double good_comment;
    //咨询人数
    private int cousult_number;
    //点评id
    private Long comment_id;
    //好坏程度
    private String level;
    //点评内容
    private String comment_content;
    //聊天的姓名
    private String main_chat_name;
    //对方的聊天的姓名
    private String sub_chat_name;

    public CommentedBookorderEntity() {
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

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
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

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getMain_chat_name() {
        return main_chat_name;
    }

    public void setMain_chat_name(String main_chat_name) {
        this.main_chat_name = main_chat_name;
    }

    public String getSub_chat_name() {
        return sub_chat_name;
    }

    public void setSub_chat_name(String sub_chat_name) {
        this.sub_chat_name = sub_chat_name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }
}
