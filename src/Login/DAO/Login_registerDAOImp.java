package Login.DAO;


import Entity.User;
import Entity.UserToken;
import Tool.HibernateUtil.java.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.logging.Logger;

/**
 * Login_registerDAO实现类
 * 状态码：1成功 0失败
 */
@Repository
public class Login_registerDAOImp implements Login_registerDAO  {

    private Logger logger=Logger.getLogger(Login_registerDAOImp.class.getName());

    @Override
    public int SaveUserData(String name, String password) {
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            User user=new User();
            user.setLogin_name(name);
            user.setPassword(password);
            session.save(user);

            String sql="select new User(u1.id) from User u1 where u1.login_name=:name";
            Query query = session.createQuery(sql);
            query.setString("name",name);
            List<User> list= (List<User>) query.list();
            User u1=list.get(0);
            UserToken token=new UserToken();
            token.setUser(u1);
            token.setToken(UUID.randomUUID().toString());
            session.save(token);

            tx.commit();
            return 1;
        }catch (HibernateException e){
            logger.info("用户已经存在...不能注册");
            return 0;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public String GetUserToken(Long userId) {
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new UserToken (t.token) from UserToken t where t.id=:user_id";
            Query query = session.createQuery(sql);
            query.setLong("user_id",userId);
            List<UserToken> list= (List<UserToken>) query.list();
            if (!list.isEmpty()){
                UserToken token=list.get(0);
                return token.getToken();
            }else {
                return "";
            }
        }catch (HibernateException e){
            e.printStackTrace();
            return "";
        }catch (NullPointerException e){
            return "";
        }
    }

    @Override
    public Map<String,Object> query_user_login(String name, String password) {
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        Map<String,Object> map=new HashMap<>();
        try {
            String sql="select new User(a.login_name,a.password,a.id) from User a WHERE a.login_name=:name and a.password=:password";
            Query query = session.createQuery(sql);
            query.setString("name",name);
            query.setString("password",password);
            List<User> list= (List<User>) query.list();

            if (list.isEmpty()){
              logger.info("没有 "+name+" 这个用户...");
            }else {
                User user=list.get(0);
                map.put("user_id",user.getId());
            }

            tx.commit();
            return map;
        }catch (HibernateException e){
            e.printStackTrace();
            return map;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
}
