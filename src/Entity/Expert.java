package Entity;


import javax.persistence.*;

/**
 * 心理专家实体类
 */
@Entity
@Table(name = "expert",schema = "xinli")
public class Expert {
    private Long id;
    private User user;
    //心理宣言
    private String motto;
    //封面配图
    private String page_picture;
    //咨询人数
    private int consult_number;
    //用户id
    private Long user_id;

    public Expert() {
    }

    public Expert(User user,int consult_number, String motto, String page_picture,Long id) {
        this.id = id;
        this.user = user;
        this.motto = motto;
        this.page_picture = page_picture;
        this.consult_number = consult_number;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "user_id",unique = true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }





    @Column(name = "motto",nullable = false)
    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }





    @Column(name = "page_picture")
    public String getPage_picture() {
        return page_picture;
    }

    public void setPage_picture(String page_picture) {
        this.page_picture = page_picture;
    }

    @Column(name = "consult_number",nullable = false,columnDefinition = "INT default 0")
    public int getConsult_number() {
        return consult_number;
    }

    public void setConsult_number(int consult_number) {
        this.consult_number = consult_number;
    }



}
