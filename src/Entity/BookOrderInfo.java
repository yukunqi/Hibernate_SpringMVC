package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class BookOrderInfo {
    //预约订单id
    private Long id;
    //预约专家的名字
    private String expert_name;
    //预约开始时间
    private String start_time;
    //预约的时长
    private String duration_time;
    //专家的头像url
    private String expert_profile;

    private static SimpleDateFormat format;
    static {
        format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public BookOrderInfo() {
    }

    public BookOrderInfo(Long id, String expert_name, Date start_time, String duration_time, String expert_profile) {
        this.id = id;
        this.expert_name = expert_name;
        this.start_time = format.format(start_time);
        this.duration_time = duration_time;
        this.expert_profile = expert_profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpert_name() {
        return expert_name;
    }

    public void setExpert_name(String expert_name) {
        this.expert_name = expert_name;
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

    public String getExpert_profile() {
        return expert_profile;
    }

    public void setExpert_profile(String expert_profile) {
        this.expert_profile = expert_profile;
    }
}
