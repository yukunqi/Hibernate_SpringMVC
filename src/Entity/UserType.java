package Entity;

import javax.persistence.*;

/**
 * 用户类型实体类
 */
@Entity
@Table(name = "user_type",schema = "xinli")
public class UserType {

    private Long id;

    private String type_name;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "type_name")
    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
