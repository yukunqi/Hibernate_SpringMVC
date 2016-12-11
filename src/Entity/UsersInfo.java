package Entity;

/**
 * 老师端咨询列表中的每个学生的信息实体类(只显示咨询过此老师的学生)
 * 老师端
 */
public class UsersInfo {
    //用户id
    private long id;
    //用户昵称
    private String name;
    //用户机构
    private String college;
    //用户年级
    private String grade;
    //用户类型
    private String user_type;
    //用户头像
    private String profile;

    public UsersInfo() {
    }

    public UsersInfo(long id, String name, String college, String grade, String user_type, String profile) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.grade = grade;
        this.user_type = user_type;
        this.profile = profile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
