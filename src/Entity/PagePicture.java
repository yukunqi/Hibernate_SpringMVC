package Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * 封面轮播图实体类
 */
@Entity
@Table(name = "page_picture",schema = "xinli")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagePicture {

    long id;

    String url;

    String description;

    public PagePicture() {
    }

    public PagePicture(long id, String url, String description) {
        this.id = id;
        this.url = url;
        this.description = description;
    }

    public PagePicture(long id, String url) {
        this.id = id;
        this.url = url;
    }

    @GeneratedValue
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
