package Entity;

import javax.persistence.*;

/**
 * 评价类型实体类
 */
@Entity
@Table(name = "level_type",schema = "xinli")
public class Level_type {

    private long id;

    private String level_type_name;

    public Level_type() {
    }
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "level_type_name")
    public String getLevel_type_name() {
        return level_type_name;
    }

    public void setLevel_type_name(String level_type_name) {
        this.level_type_name = level_type_name;
    }
}
