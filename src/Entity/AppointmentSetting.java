package Entity;

import javax.persistence.*;

/**
 * 老师预约时间实体类
 */
@Entity
@Table(name = "appointment",schema = "xinli")
public class AppointmentSetting {

    private Long id;
    private String weekday;
    private String start_time;
    private String duration_time;
    private int limited_people_num;
    private int ordered_people_num;
    private Expert expert;

    public AppointmentSetting() {
    }

    public AppointmentSetting(String weekday, String start_time, String duration_time) {
        this.weekday = weekday;
        this.start_time = start_time;
        this.duration_time = duration_time;
    }

    public AppointmentSetting(Long id,int limited_people_num, int ordered_people_num) {
        this.id=id;
        this.limited_people_num = limited_people_num;
        this.ordered_people_num = ordered_people_num;
    }

    public AppointmentSetting(String weekday, String start_time, String duration_time, int limited_people_num) {
        this.weekday = weekday;
        this.start_time = start_time;
        this.duration_time = duration_time;
        this.limited_people_num = limited_people_num;
    }

    public AppointmentSetting(String weekday, String start_time, String duration_time, int limited_people_num, int ordered_people_num) {
        this.weekday = weekday;
        this.start_time = start_time;
        this.duration_time = duration_time;
        this.limited_people_num = limited_people_num;
        this.ordered_people_num = ordered_people_num;
    }

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "weekday")
    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    @Column(name = "start_time")
    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    @Column(name = "duration_time")
    public String getDuration_time() {
        return duration_time;
    }

    public void setDuration_time(String duration_time) {
        this.duration_time = duration_time;
    }

    @OneToOne
    @JoinColumn(name = "expert_id",nullable = false)
    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    @Column(name = "limited_people_num")
    public int getLimited_people_num() {
        return limited_people_num;
    }

    public void setLimited_people_num(int limited_people_num) {
        this.limited_people_num = limited_people_num;
    }

    @Column(name = "ordered_people_num")
    public int getOrdered_people_num() {
        return ordered_people_num;
    }

    public void setOrdered_people_num(int ordered_people_num) {
        this.ordered_people_num = ordered_people_num;
    }
}
