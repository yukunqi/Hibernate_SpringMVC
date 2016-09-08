package Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户身份识别加密token实体类
 */
@Entity
@Table(name = "usertoken",schema = "xinli")
public class UserToken implements Serializable {
    private User user;
    private String Token;

    public UserToken() {
    }

    public UserToken(String token) {
        Token = token;
    }

    @Id
    @OneToOne
    @JoinColumn(name = "user_id",unique = true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "user_token")
    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    @Override
    public int hashCode() {
        int result = (int) (user.getId() ^ (user.getId() >>> 32));
        result = 31 * result + (Token != null ? Token.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserToken that = (UserToken) o;

        if (user.getId() != that.user.getId()) return false;
        if (Token != null ? !Token.equals(that.Token) : that.Token != null) return false;

        return true;
    }
}
