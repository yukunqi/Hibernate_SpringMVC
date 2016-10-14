package Upload.DAO;

import Entity.AppointmentSetting;
import Entity.BookOrders;
import Entity.Expert;
import Entity.User;
import Tool.HibernateUtil.java.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

/**
 * 老师信息存储DAO
 */
@Repository
public class ExpertDAO {

    private Logger logger=Logger.getLogger(ExpertDAO.class.getName());

    public int saveExpertData(Expert expert){
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new User(u1.id) from User u1 where u1.id=:user_id ";
            Query query = session.createQuery(sql);
            query.setLong("user_id",expert.getUser_id());
            List<User> list= (List<User>) query.list();
            User user=list.get(0);
            String sql1="update User u set u.email =:email ,u.phone_number=:phone_number,u.gender=:gender,u.username=:username where u.id=:user_id";
            Query query1 = session.createQuery(sql1);
            query1.setString("email",expert.getUser().getEmail());
            query1.setString("username",expert.getUser().getUsername());
            query1.setString("gender",expert.getUser().getGender());
            query1.setString("phone_number",expert.getUser().getPhone_number());
            query1.setLong("user_id",expert.getUser_id());
            query1.executeUpdate();
            expert.setUser(user);
            session.save(expert);
            tx.commit();
            return 1;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("存储老师信息失败....");
            if (tx!=null){
                tx.rollback();
            }
            return 0;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    public int save_chatOrderData(BookOrders bookOrders){
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        GregorianCalendar calendar=new GregorianCalendar();
        try {
            Date date=bookOrders.getBook_time();
            calendar.setTime(date);
            int weekday=calendar.get(Calendar.DAY_OF_WEEK)-1;
            String start_time=format.format(date);
            String sql="select new AppointmentSetting(a.id,a.limited_people_num,a.ordered_people_num) from AppointmentSetting a where a.expert.id=:expert_id and a.weekday=:weekday and a.start_time=:start_time";
            Query query = session.createQuery(sql);
            System.out.println(bookOrders.getExpert().getId());
            System.out.println(weekday);
            System.out.println(start_time);
            query.setLong("expert_id",bookOrders.getExpert().getId());
            query.setInteger("weekday",weekday);
            query.setString("start_time",start_time);
            AppointmentSetting a = (AppointmentSetting) query.uniqueResult();
            if (a.getOrdered_people_num()>=a.getLimited_people_num()){
                logger.info("老师Id为"+bookOrders.getExpert().getId()+"预约次数达到上限");
                return 3;//预约次数达到上限
            }else {
                    String sql2="select new BookOrders(book.id) from BookOrders book where book.book_time=:book_time and book.expert.id=:expert_id and book.user.id=:user_id";
                    Query query2 = session.createQuery(sql2);
                    query2.setLong("expert_id",bookOrders.getExpert().getId());
                    String str=format1.format(bookOrders.getBook_time());
                    query2.setString("book_time",str);
                    query2.setLong("user_id",bookOrders.getUser().getId());
                    Object o = query2.uniqueResult();
                    if (o!=null){
                        logger.info("用户id为"+bookOrders.getUser().getId()+"的用户已经在"+str+"这个时间段预约过了");
                        return 2;//相同用户在相同老师同一时间段预约多次
                    }

                session.save(bookOrders);
                String sql3="update AppointmentSetting a set a.ordered_people_num=:order_people_num where a.id=:id";
                Query query1 = session.createQuery(sql3);
                query1.setLong("id",a.getId());
                query1.setInteger("order_people_num",a.getOrdered_people_num()+1);
                query1.executeUpdate();
                tx.commit();
                return 1;//预约成功
            }
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("存储咨询订单信息失败....");
            if (tx!=null){
                tx.rollback();
            }
            return 0;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    public int save_AppointmentSetting(List<AppointmentSetting> list){
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            for(int i=0;i<list.size();i++){
                session.save(list.get(i));
                if (i%20==0){
                    session.flush();
                    session.clear();
                }
            }
            tx.commit();
            return 1;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("存储老师预约时间设置失败....");
            if (tx!=null){
                tx.rollback();
            }
            return 0;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
}
