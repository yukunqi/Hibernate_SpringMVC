package Entity;

/**
 * 用户咨询评价实体类
 */
public class UserCommentInfo {
    //用户昵称
    private String name;
    //用户头像
    private String profile;
    //评价的好坏程度
    private String level;
    //评价内容
    private String content;
    //评价时间
    private String date;
    //是否匿名
    private int anonymous;
    //用户id
    private long id;

    public UserCommentInfo() {
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(int anonymous) {
        this.anonymous = anonymous;
    }
}
