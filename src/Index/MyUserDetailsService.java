package Index;

import Entity.User;
import Tool.HibernateUtil.java.HibernateUtil;
import org.hibernate.*;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * 作为MyUserDetail 实体类的DAO层 进行登录名认证的规则定义
 * 自定义查询数据库规则 并返回相应的实体类
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private static final String USER_BY_USERNAME_QUERY="select new User(u.login_name,u.password,u.username,u.id,u.userType) from User u where login_name=:username";
    public static final String AUTHORITIES_BY_USERNAME_QUERY = "select user_type from user where login_name=?";
    public static final String GROUP_AUTHORITIES_BY_USERNAME_QUERY = "";
    private static Logger logger=Logger.getLogger(MyUserDetailsService.class.getName());

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            Query Query = session.createQuery(USER_BY_USERNAME_QUERY);
            Query.setString("username",s);
            User u = (User) Query.uniqueResult();
            return this.createUserDetail(u.getUsername(),u.getPassword(),u.getEmail());
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询登录名为  "+s+"  用户失败...");
            if (tx!=null){
                tx.rollback();
            }
            throw new UsernameNotFoundException("用户名或密码不正确");
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    public UserDetails createUserDetail(String username,String password,String email){
        return new MyUserDetail(username,password,email,true,true,true,true, AuthorityUtils.NO_AUTHORITIES);
    }
}
