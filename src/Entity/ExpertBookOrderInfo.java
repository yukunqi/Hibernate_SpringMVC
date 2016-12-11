package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 老师端看到的咨询订单数据实体
 */
public class ExpertBookOrderInfo {
    //预约订单id
    private Long id;
    //预约专家的名字(也可能是用户的名字，当接口为查询老师的被预约的订单时)
    private String user_name;
    //预约开始时间
    private String start_time;
    //预约的时长
    private String duration_time;
    //专家的头像url(也可能用户的头像)
    private String user_profile;
    //专家的聊天用户名(用户的聊天名字)
    private String chat_name;

    private static SimpleDateFormat format;
    static {
        format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public ExpertBookOrderInfo() {
    }

    public ExpertBookOrderInfo(Long id, String user_name, Date start_time, String duration_time, String user_profile, String chat_name) {
        this.id = id;
        this.user_name = user_name;
        this.start_time = format.format(start_time);
        this.duration_time = duration_time;
        this.user_profile = user_profile;
        this.chat_name = chat_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getDuration_time() {
        return duration_time;
    }

    public void setDuration_time(String duration_time) {
        this.duration_time = duration_time;
    }

    public String getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(String user_profile) {
        this.user_profile = user_profile;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }
}
