package Entity;


import javax.persistence.*;

/**
 * 心理专家实体类
 */
@Entity
@Table(name = "Expert",schema = "xinli")
public class Expert {
    private Long id;
    private User user;
    private String qualifications;
    private String strongPoint;
    private String motto;
    private String background;
    private String others;
    private String page_picture;
    private int consult_number;

    public Expert() {
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

    @Column(name = "qualifications",nullable = false)
    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    @Column(name = "strongPoint",nullable = false)
    public String getStrongPoint() {
        return strongPoint;
    }

    public void setStrongPoint(String strongPoint) {
        this.strongPoint = strongPoint;
    }

    @Column(name = "motto",nullable = false)
    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Column(name = "background",nullable = false)
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Column(name = "others",nullable = false)
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
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
