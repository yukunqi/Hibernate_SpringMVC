package Entity;

import Tool.HibernateUtil.java.HibernateUtil;
import com.google.gson.Gson;
import org.apache.commons.httpclient.util.DateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Test1 {

    @Test
    public void Test1(){
         String name1="sdfdf";
        int code=name1.hashCode();
        int result=code&0xf;
        System.out.println(code);
        System.out.println(result);
    }
    @Test
    public void Testexpert(){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {

            Expert expert=new Expert();
            expert.setBackground("心理学硕士");
            expert.setMotto("爱是治愈一切的力量");
            expert.setOthers("平时爱打球爱写作");
            expert.setQualifications("美国总统随队心理咨询师");
            expert.setStrongPoint("擅长各种被套路出现的心理问题");
            expert.setUser_id((long)3);

            User user= (User) session.get(User.class,expert.getUser_id());
            expert.setUser(user);

            session.save(expert);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
    @Test
    public void TestGson(){
        Expert expert=new Expert();
        expert.setBackground("心理学硕士");
        expert.setMotto("爱是治愈一切的力量");
        expert.setOthers("平时爱打球爱写作");
        expert.setQualifications("美国总统随队心理咨询师");
        expert.setStrongPoint("擅长各种被套路出现的心理问题");
        expert.setUser_id((long)3);
        Gson gson=new Gson();
        String jsonstr=gson.toJson(expert);
        System.out.println(jsonstr);
    }
}
