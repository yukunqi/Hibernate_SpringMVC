package Upload.DAO;

import Entity.*;
import Tool.HibernateUtil.java.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
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

    /**
     * 存储老师数据
     * @param expert 老师实体类
     * @return
     */
    public int saveExpertData(Expert expert){
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new User(u1.id) from User u1 where u1.id=:user_id ";
            Query query = session.createQuery(sql);
            query.setLong("user_id",expert.getUser_id());
            User user = (User) query.uniqueResult();
            if (user==null){
                logger.info("id为"+expert.getUser_id()+"的用户不存在，申请成为老师失败......");
                return 3;
            }
            String sql1="update User u set u.email =:email ,u.phone_number=:phone_number,u.gender=:gender,u.username=:username,u.authority=:authority where u.id=:user_id";
            Query query1 = session.createQuery(sql1);
            query1.setString("email",expert.getUser().getEmail());
            query1.setString("username",expert.getUser().getUsername());
            query1.setString("gender",expert.getUser().getGender());
            query1.setString("phone_number",expert.getUser().getPhone_number());
            query1.setLong("user_id",expert.getUser_id());
            query1.setInteger("authority",2);
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

    /**
     * 存储咨询预约订单数据
     * @param bookOrders 咨询预约订单实体类
     * @return
     */
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
            String sql="select new AppointmentSetting(a.id,a.duration_time,a.limited_people_num,a.ordered_people_num) from AppointmentSetting a where a.expert_user_id.id=:expert_user_id and a.weekday=:weekday and a.start_time=:start_time";
            Query query = session.createQuery(sql);
            System.out.println(bookOrders.getExpert_user_id().getId());
            System.out.println(weekday);
            System.out.println(start_time);
            query.setLong("expert_user_id",bookOrders.getExpert_user_id().getId());
            query.setInteger("weekday",weekday);
            query.setString("start_time",start_time);
            AppointmentSetting a = (AppointmentSetting) query.uniqueResult();
            if (a==null){
                return 4;//没有这个时间可以预约
            }
            if (a.getOrdered_people_num()>=a.getLimited_people_num()){
                logger.info("老师Id为"+bookOrders.getExpert_user_id().getId()+"预约次数达到上限");
                return 3;//预约次数达到上限
            }else {
                    String sql2="select new BookOrders(book.id) from BookOrders book where book.book_time=:book_time and book.expert_user_id.id=:expert_id and book.user_id.id=:user_id";
                    Query query2 = session.createQuery(sql2);
                    query2.setLong("expert_id",bookOrders.getExpert_user_id().getId());
                    String str=format1.format(bookOrders.getBook_time());
                    query2.setString("book_time",str);
                    query2.setLong("user_id",bookOrders.getUser_id().getId());
                    Object o = query2.uniqueResult();
                    if (o!=null){
                        logger.info("用户id为"+bookOrders.getUser_id().getId()+"的用户已经在"+str+"这个时间段预约过了");
                        return 2;//相同用户在相同老师同一时间段预约多次
                    }
                bookOrders.setDuration_time(a.getDuration_time());
                bookOrders.setAppointmentSetting(a);
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
            return 0;//服务器内部逻辑错误
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 存储老师设置预约咨询时间数据
     * @param a 设置预约时间实体集合
     * @return
     */
    public int save_AppointmentSetting(AppointmentSetting  a){
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        GregorianCalendar calendar=new GregorianCalendar();
        try {
                calendar.setTime(a.getSetting_date());
                String start_time=format.format(a.getSetting_date());
                String weekday=String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)-1);

                String sql="select new AppointmentSetting(a.weekday,a.start_time,a.duration_time) from AppointmentSetting a where a.expert_user_id.id=:expert_user_id and a.start_time=:start_time and a.weekday=:weekday";
                Query query = session.createQuery(sql);
                query.setLong("expert_user_id",a.getExpert_user_id().getId());
                query.setString("start_time",start_time);
                query.setString("weekday",weekday);
                AppointmentSetting a1= (AppointmentSetting) query.uniqueResult();
                if (a1==null){//不重复 可以存储这条数据
                    a.setWeekday(weekday);
                    a.setStart_time(start_time);
                    session.save(a);
                }else {
                    logger.info("存储的预约时间重复...");
                   return 2;//重复的预约时间设置
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

    /**
     * 更新用户头像数据
     * @param imageUrl
     * @param user_id
     * @return
     */
    public int UpdateUserProfile(String imageUrl,Long user_id){
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="update User u set u.profile=:user_profile where u.id=:user_id";
            Query query = session.createQuery(sql);
            query.setLong("user_id",user_id);
            query.setString("user_profile",imageUrl);
            query.executeUpdate();
            tx.commit();
            return 1;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("更新用户头像失败....");
            if (tx!=null){
                tx.rollback();
            }
            return 0;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 插入用户帖子评论数据实体
     * @param comment 帖子评论
     * @return
     */
    public int saveComment(Note_Comment comment){
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            session.save(comment);
            tx.commit();
            return 1;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("用户id为  "+comment.getNote_comment_user().getId()+"  插入帖子评论失败");
            if (tx!=null){
                tx.rollback();
            }
            return 0;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据咨询订单id插入相应的咨询评价数据
     * @param userComment
     * @return
     */
    public int uploadUserComment(UserComment userComment){
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            session.save(userComment);
            tx.commit();
            return 1;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("咨询订单id为  "+userComment.getBook_id()+" 的咨询评价记录插入失败...");
            if (tx!=null){
                tx.rollback();
            }
            return 0;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
}
