package Entity;

import Tool.HibernateUtil.java.HibernateUtil;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;


/**
 *
 */
public class Test1 {

    @Test
    public void Test1(){

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
        expert.setBackground("心理士");
        expert.setMotto("爱是治愈一切的力量");
        expert.setOthers("平时爱写作");
        expert.setQualifications("美国总咨询师");
        expert.setStrongPoint("擅长各的心理问题");
        expert.setUser_id((long)18);
        Gson gson=new Gson();
        String jsonstr=gson.toJson(expert);
        System.out.println(jsonstr);
    }

    /**
     * 登录和注册的json数据生成示例
     */
    @Test
    public void Test_register(){
        Map<String,Object> map=new HashMap<>();
        User user=new User();
        user.setLogin_name("123");
        user.setPassword("454");
        Jsondata<User> jsondata=new Jsondata<>();
        jsondata.setJsondata(user);
        Gson gson=new Gson();
        String jsonstr=gson.toJson(jsondata);
        System.out.println(jsonstr);
    }

    @Test
    public void Test_ExpertsUpload(){
        Expert expert=new Expert();
        expert.setBackground("心理士");
        expert.setMotto("爱是治愈一切的力量");
        expert.setOthers("平时爱写作");
        expert.setQualifications("美国总咨询师");
        expert.setStrongPoint("擅长各的心理问题");
        expert.setUser_id((long)18);
        Jsondata<Expert> jsondata=new Jsondata<>();
        jsondata.setJsondata(expert);
        Gson gson=new Gson();
        String jsonstr=gson.toJson(jsondata);
        System.out.println(jsonstr);
        Jsondata<Expert> jsondata1=gson.fromJson(jsonstr,new TypeToken< Jsondata<Expert>>(){}.getType());
        Expert expert1=jsondata1.getJsondata();
        System.out.println(expert1.getMotto());
    }

    /**
     * 查询老师咨询好评率
     */
    @Test
    public void Test_good_comment(){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            //String sql="select new Entity.ExpertsInfo(e1.page_picture,e1.user.login_name,e1.user.college,e1.motto,e1.consult_number,e1.id) from Expert e1";
            String sql="select new Entity.Expert_percent(exc.expert.id) from Expert_comment exc";
            Query query = session.createQuery(sql);

            String sql1="select new Entity.Expert_percent(count(exc.level)) from Expert_comment exc where exc.expert.id=:expert_id";
            Query query1 = session.createQuery(sql1);

            List<Expert_percent> list1 = (List<Expert_percent>) query1.list();
            tx.commit();

            for (Expert_percent e:list1){
                System.out.println(e.getExpert_id()+"    "+e.getTotalComment());
            }
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 两个long型数字，相除保留两位小数
     */
    @Test
    public void Test_Long_change_precent(){
        Long a1= Long.valueOf(1);
        Long a2= Long.valueOf(3);
        double result=a1*1.0/a2; //不乘1.0不出正确结果
        BigDecimal b=new BigDecimal(result);
        double r1=b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(r1);
    }
}
