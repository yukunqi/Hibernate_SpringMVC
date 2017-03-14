package Entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户类型实体类
 */
@Entity
@Table(name = "user_type",schema = "xinli")
public class UserType {

    private Long id;

    private String type_name;

    private long par_id;

    public UserType(Long id, String type_name) {
        this.id = id;
        this.type_name = type_name;
    }

    public UserType() {
    }

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

    @Column(name = "par_id")
    public long getPar_id() {
        return par_id;
    }

    public void setPar_id(long par_id) {
        this.par_id = par_id;
    }
}
