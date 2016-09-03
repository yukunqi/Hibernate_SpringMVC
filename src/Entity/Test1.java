package Entity;

import Tool.HibernateUtil.java.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Test1 {

    @Test
    public void Test1(){
         Session session=HibernateUtil.getSession();
         Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new User (a.login_name) from User a";
            Query query =session.createQuery(sql);
            List<User> list= (List<User>) query.list();
            for (User u:list){
                System.out.println(u.getLogin_name());
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
}
