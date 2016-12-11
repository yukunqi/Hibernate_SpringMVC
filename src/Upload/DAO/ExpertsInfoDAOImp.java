package Upload.DAO;
import Entity.*;
import Tool.HibernateUtil.java.HibernateUtil;
import com.google.gson.Gson;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Transformer;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * 查询列表信息
 */
@Repository
public class ExpertsInfoDAOImp implements expertInfoDAO{

    private Logger logger=Logger.getLogger(ExpertsInfoDAOImp.class.getName());
    /**
     * 返回整个老师的所有信息
     * 包括了好评率
     */
    public List<ExpertsInfo> query_experts_list(int user_type_id){
        List<ExpertsInfo> expertsAllinfos = getExpertsAllinfos(user_type_id);
        if (expertsAllinfos!=null){
            return get_ExpertsComment_number(expertsAllinfos);
        }else {
            return null;
        }

    }

    /**
     * 获取所有专家的好评率
     * 好评率=好评数/总评数
     * 分别根据id去获取好评数和总评数
     * 然后计算出好评率之后放进对象
     * @return
     */
    private List<ExpertsInfo> get_ExpertsComment_number(List<ExpertsInfo> experts){
         for (ExpertsInfo e:experts){
             Long good=getExpert_goodComment(e.getUser_id());
             Long total=getExpert_totalComment(e.getUser_id());
             e.setGood_comment(get_precent(good,total));
         }
        return experts;
    }

    /**
     * 根据指定的id获取被评论者的评论总数
     * @param expert_id
     * @return
     */
    public Long getExpert_totalComment(Long expert_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select count(user.level) from UserComment user where user.sub_user_id=:expert_id";
            Query query = session.createQuery(sql);
            query.setLong("expert_id",expert_id);
            return (Long) query.uniqueResult();
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("老师总评论数查询失败......");
            if (tx!=null){
                tx.rollback();
            }
            return Long.valueOf(0);
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据指定的id获取被评论者的好评总数
     * @param  expert_id
     * @return
     */
    public Long getExpert_goodComment(Long expert_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select count(user.level) from UserComment user where user.sub_user_id=:expert_id and user.level.id=1";
            Query query = session.createQuery(sql);
            query.setLong("expert_id",expert_id);
            return (Long) query.uniqueResult();
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("老师好评数查询失败......");
            if (tx!=null){
                tx.rollback();
            }
            return Long.valueOf(0);
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 查询除好评率以外的全部老师信息集合
     * @return
     */
    private List<ExpertsInfo> getExpertsAllinfos(int user_type_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        List<ExpertsInfo> list;
        try {
            String sql="select new Entity.ExpertsInfo(e1.page_picture,e1.user.username,e1.user.college,e1.motto,e1.consult_number,e1.user.userType.type_name,e1.user.id) from Expert e1  where e1.user.userType.id=:user_type_id order by e1.consult_number desc";
            Query query = session.createQuery(sql);
            query.setLong("user_type_id",Long.valueOf(user_type_id));
            list=(List<ExpertsInfo>) query.list();
            tx.commit();
            return list;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询老师信息集合失败....");
            if (tx!=null){
                tx.rollback();
            }

            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /***
     * 根据传入的两个参数计算出百分比，保留两位小数.
     * @param goodComment
     * @param totalComment
     * @return
     */
    public   double get_precent(Long goodComment,Long totalComment){
        try {
            double result=goodComment*1.0/totalComment; //不乘1.0不出正确结果
            BigDecimal b=new BigDecimal(result);
            return b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        }catch (NumberFormatException e){
            return 0;
        }
    }

    /**
     * 根据老师id去查询咨询评价总数
     * @param expert_id
     * @return
     */
    public Long get_expertComment_num(Long expert_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select count (user_comment.id) from UserComment user_comment where user_comment.sub_user_id.id=:expert_id";
            Query query = session.createQuery(sql);
            query.setLong("expert_id",expert_id);
            List<Long> list = query.list();
            Long aLong = list.get(0);
            return aLong;
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
            return (long) -1;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据id去查询指定用户发布的文章总数
     * @param user_id
     * @return
     */
    public Long get_expertArticle_num(Long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select count (art.id) from Article art where art.user.id=:user_id";
            Query query = session.createQuery(sql);
            query.setLong("user_id",user_id);
            List<Long> list = query.list();
            Long aLong = list.get(0);
            return aLong;
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
            return (long) -1;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据老师id去查询老师的咨询页面封面配图、个人简介、咨询人数等信息
     * @param expert_id
     * @return
     */
    public ExpertPersonalPage get_ExpertchatRoominfo(Long expert_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new Entity.ExpertPersonalPage(exp.user.introduction,exp.page_picture,exp.consult_number,exp.user.id) from Expert exp where exp.user.id=:expert_id";
            Query query = session.createQuery(sql);
            query.setLong("expert_id",expert_id);
            ExpertPersonalPage page = (ExpertPersonalPage) query.uniqueResult();
            if (page==null){//查询不到记录
                page=new ExpertPersonalPage();
                page.setComment_total_number(Long.valueOf(0));
                page.setPage_picture("");
                page.setIntroduction("");
                page.setConsult_number(0);
                page.setGood_comment_num(Long.valueOf(0));
                page.setUser_id(Long.valueOf(0));
            }
            return page;
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据id去查询老师的咨询评价集合
     * @param expert_id
     * @return
     */
    public List<Expert_comment_item> get_expertComment_list(Long expert_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new Entity.Expert_comment_item(user_comment.main_user_id.username,user_comment.comment,user_comment.main_user_id.profile,user_comment.comment_date,user_comment.level.level_type_name,user_comment.main_user_id.id) from UserComment user_comment where user_comment.sub_user_id=:expert_id order by user_comment.id desc ";
            Query query = session.createQuery(sql);
            query.setLong("expert_id",expert_id);
            return (List<Expert_comment_item>) query.list();
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
            System.out.println("null");
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据用户id去查询相应的文章集合
     * @param user_id
     * @return
     */
    public List<ArticleInfo> get_userArticle_list(Long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new Entity.ArticleInfo(art.id,art.article_title,art.build_date,art.article_picture,art.watched_num,art.good_num) from Article art where art.user.id=:user_id order by art.user.id desc ";
            Query query = session.createQuery(sql);
            query.setLong("user_id",user_id);
            return (List<ArticleInfo>) query.list();
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据老师id去查询老师设置的咨询预约时间集合
     * @param expert_user_id
     * @return
     */
    public List<AppointmentSetting> get_expert_AppointmentSetting(Long expert_user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new AppointmentSetting(a1.id,a1.weekday,a1.start_time,a1.duration_time,a1.limited_people_num,a1.ordered_people_num) from AppointmentSetting a1 where a1.expert_user_id.id=:expert_user_id";
            Query query = session.createQuery(sql);
            query.setLong("expert_user_id",expert_user_id);
            return query.list();
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据学生的id去查询咨询订单集合
     * @param user_id
     * @return
     */
    public List<BookOrderInfo> get_User_All_BookOrders(Long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new Entity.BookOrderInfo(book.id,book.expert_user_id.username,book.book_time,book.duration_time,book.expert_user_id.profile,book.expert_user_id.login_name) from BookOrders book where book.user_id.id=:user_id";
            Query query = session.createQuery(sql);
            query.setLong("user_id",user_id);
            return query.list();
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询用户id为"+user_id+"预约订单数据集合失败.....");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据老师id去查询相应的咨询订单集合
     * @param user_id
     * @return
     */
    public List<BookOrderInfo> get_Expert_All_BookOrders(Long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new Entity.BookOrderInfo(book.id,book.user_id.username,book.book_time,book.duration_time,book.user_id.profile,book.user_id.login_name) from BookOrders book where book.expert_user_id.id=:user_id";
            System.out.println(sql);
            Query query = session.createQuery(sql);
            query.setLong("user_id",user_id);
            return query.list();
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询老师id为"+user_id+"预约订单数据集合失败.....");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据时间设置的id来删除相应的设置的时间的数据
     * @param appointment_id 设置的时间的id
     * @return 成功删除1 查询不到0  语句执行失败2
     */
    public int delete_expert_AppointmentSetting(Long appointment_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="delete from AppointmentSetting a where a.id=:appointment_id";
            Query query = session.createQuery(sql);
            query.setLong("appointment_id",appointment_id);
            int i = query.executeUpdate();
            tx.commit();
            return i;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询时间实体id为"+appointment_id+"的数据删除失败.....");
            if (tx!=null){
                tx.rollback();
            }
            return 2;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据用户的id 用户想要更新的字段 更新的数据 一起进行数据库的数据的更新
     * @param user_id 用户id
     * @param column_name  用户要更新的字段的名字
     * @param data  更新的数据
     * @return  1成功 0失败 2执行语句错误
     */
    public int updatePersonalInfo(Long user_id,String column_name,String data){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            if (column_name.equals("profile")){
                return 2;
            }
            String sql="update User u set u."+column_name+"=:user_"+column_name+" where u.id=:user_id";
            Query query = session.createQuery(sql);
            query.setLong("user_id",user_id);
            query.setString("user_"+column_name,data);
            int i = query.executeUpdate();
            tx.commit();
            return i;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询用户实体id为"+user_id+"的数据更新失败.....");
            if (tx!=null){
                tx.rollback();
            }
            return 2;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据老师的id和设置的预约时间id去查询相应的被预约咨询订单集合
     * @param expert_user_id 老师id
     * @param appointment_id  预约时间id
     * @return list 集合
     */
    public List<ExpertBookOrderInfo> getExpert_BookOrders(Long expert_user_id,Long appointment_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        List<ExpertBookOrderInfo> list=null;
        try {
            String sql="select new Entity.ExpertBookOrderInfo(book.id,book.user_id.username,book.book_time,book.duration_time,book.user_id.profile,book.user_id.login_name) from BookOrders  book where book.appointmentSetting.id=:appointment_id and book.expert_user_id.id=:expert_user_id";
            Query query = session.createQuery(sql);
            query.setLong("expert_user_id",expert_user_id);
            query.setLong("appointment_id",appointment_id);
            list=query.list();
            tx.commit();
            return list;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询专家Id为"+expert_user_id+"  预约时间段Id为"+appointment_id+"的请求失败........");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据咨询订单id去取消未开始的咨询预约订单
     * @param bookOrder_id 订单id
     * @return
     */
    public int deleteBookOrder(Long bookOrder_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int i=0;
        try {
            String sql="select new BookOrders (book.id,book.book_time,book.duration_time) from BookOrders  book where book.id=:bookOrder_id";
            Query query = session.createQuery(sql);
            query.setLong("bookOrder_id",bookOrder_id);
            BookOrders b = (BookOrders) query.uniqueResult();
            if (b==null){
                return 2;//没有这个id的订单存在
            }else {
                String start_time=format.format(b.getBook_time());
                String duration_time=b.getDuration_time();
                int result=IsTime_In_TimeZones(start_time,duration_time);
                if (result==2){
                    String sql1="delete from BookOrders b where b.id=:b_id";
                    Query query1 = session.createQuery(sql1);
                    query1.setLong("b_id",b.getId());
                    query1.executeUpdate();
                    i=1;//取消订单成功
                }else {
                    i=3;//这个id的订单已经开始或者结束，不能取消
                }
            }
            tx.commit();
            return i;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("取消咨询预约订单有误....");
            if (tx!=null){
                tx.rollback();
            }
            return i;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据用户id去查询这个用户的最近一篇文章数据
     * @param user_id 用户id
     * @return
     */
    public ArticleInfo getRecentUserArticle(Long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new Entity.ArticleInfo(art.id,art.article_title,art.build_date,art.article_picture,art.watched_num,art.good_num) from Article art where art.user.id=:user_id and art.build_date=(select max (build_date) from Article)";
            Query query = session.createQuery(sql);
            query.setLong("user_id",user_id);
            ArticleInfo artInfo = (ArticleInfo) query.uniqueResult();
            tx.commit();
            return artInfo;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询不到id为  "+user_id+"  的最近一篇文章记录");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
/*
    /**
     * 根据用户的id去查询最近的一次问答记录
     * @param user_id 用户id
     * @return

    public NoteInfo getRecentNoteInfo(Long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new Entity.NoteInfo(note.id,note.note_title,comment.note_comment_content,comment.comment_date,comment.second_comment_num,comment.comment_good_num) from Note note,Note_Comment comment where  note.id=comment.note.id and comment.note_comment_user.id=:user_id and comment.comment_date=(select max (comment_date) from Note_Comment )";
            Query query = session.createQuery(sql);
            query.setLong("user_id",user_id);
            NoteInfo noteInfo = (NoteInfo) query.uniqueResult();
            tx.commit();
            return noteInfo;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询不到id为  "+user_id+"  的最近一篇问答记录");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
*/
    /**
     * 根据用户Id去查询用户的基本个人资料(用户id 用户昵称 用户学院 用户性别 用户学校 用户个人签名 用户头像)
     * @param user_id 用户id
     * @return
     */
    public User getUserPersonalInfo(Long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new User(u.id,u.username,u.profile,u.gender,u.introduction,u.school_name,u.college) from User  u where u.id=:user_id";
            Query query = session.createQuery(sql);
            query.setLong("user_id",user_id);
            User user = (User) query.uniqueResult();
            tx.commit();
            return user;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询不到id为  "+user_id+"  的个人资料");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据用户的id去获取用户的待评价列表数据
     * @param user_id
     * @return
     */
    public List<Object []> getCommentBookordersEntityList(long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {

            //select u1.id,type.type_name,book.comment_id,book.duration_time,comment.comment_date,u1.username,u1.profile,u1.college,ex.consult_number,u1.login_name as name1,u2.login_name as name2,sum(case when comment.level=1 then 1 else 0 end) as num1,count(comment.id) as num2  from bookorders book left join user u1 on book.expert_user_id=u1.id left join user u2 on book.user_id=u2.id left join expert ex on ex.user_id=book.expert_user_id,user_type type,user_comment comment where type.id=u1.user_type AND book.comment_id!=0 AND u2.id=3 and comment.sub_user_id=book.expert_user_id group by book.id
            String sql="select u1.id,type.type_name,book.comment_id,book.duration_time,book.book_time,u1.username,u1.profile,u1.college,ex.consult_number,u1.login_name as name1,u2.login_name as name2,sum(case when comment.level=1 then 1 else 0 end) as num1,count(comment.id) as num2,book.id as bid from bookorders book left join user u1 on book.expert_user_id=u1.id left join user u2 on book.user_id=u2.id left join expert ex on ex.user_id=book.expert_user_id,user_type type,user_comment comment where type.id=u1.user_type AND book.id!=comment.book_id AND u2.id="+user_id+" and comment.sub_user_id=book.expert_user_id group by book.id order by book.book_time desc";
            System.out.println(sql);
            SQLQuery sqlQuery = session.createSQLQuery(sql);
           // sqlQuery.addScalar("name", StandardBasicTypes.STRING);
          //  sqlQuery.setResultTransformer(Transformers.aliasToBean(CommentBookorderEntity.class));
            List<Object []> list = sqlQuery.list();
            return list;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询用户id为"+user_id+"的待评价订单列表数据失败.....");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据用户的id去查询相应的已评价信息列表
     * @param user_id
     * @return
     */
    public List<Object []> getCommentedBookordersEntityList(long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select u1.id,type.type_name,comment.id,book.duration_time,book.book_time,u1.username,u1.profile,u1.college,ex.consult_number,u1.login_name as name1,u2.login_name as name2,sum(case when comment.level=1 then 1 else 0 end) as num1,count(comment.id) as num2,comment.comment_date,ltype.level_type_name,comment.comment  from bookorders book left join user u1 on book.expert_user_id=u1.id left join user u2 on book.user_id=u2.id left join expert ex on ex.user_id=book.expert_user_id,user_type type,user_comment comment,level_type ltype where ltype.id=comment.level and type.id=u1.user_type AND book.id=comment.book_id AND u2.id="+user_id+" and comment.sub_user_id=book.expert_user_id group by book.id order by comment.comment_date desc";
            System.out.println(sql);
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            List<Object []> list = sqlQuery.list();
            return list;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询用户id为"+user_id+"的已评价订单列表数据失败.....");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据用户Id去查询相应的咨询评价信息列表(老师的个人信息页面中)
     * @param user_id
     * @return
     */
    public List<Object []> getUserCommentInfoList(long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select u2.id,u2.username,u2.profile,type.level_type_name,comment.comment_date,comment.comment,comment.anonymous from user_comment comment,user u1,user u2,level_type type where type.id=comment.level and comment.sub_user_id=u1.id and comment.main_user_id=u2.id and u1.id="+user_id;
            System.out.println(sql);
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            List<Object []> list = sqlQuery.list();
            return list;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询用户id为"+user_id+"的咨询评价数据失败.....");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 根据老师id去查询咨询过的学生列表
     * (老师端)
     * @param user_id
     * @return
     */
    public List<UsersInfo> getUsersInfoList(long user_id,long type_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select distinct new Entity.UsersInfo(u.id,u.username,u.college,u.grade,u.userType.type_name,u.profile) from BookOrders book,User u,UserType type where book.expert_user_id=:user_id and book.user_id.id=u.id and u.userType.id=type.id and type.id=:type_id";
            Query query = session.createQuery(sql);
            query.setLong("user_id",user_id);
            query.setLong("type_id",type_id);
            return (List<UsersInfo>) query.list();
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询老师用户id为"+user_id+"的咨询过的学生信息列表数据失败.....");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 获取老师端学生的个人页面信息(在列表点击进去之后)
     * 老师端
     * @param user_id
     * @return
     */
    public List<Object []> getUserPageInfo(long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select u2.username as uname,u2.profile as uprofile,u2.introduction,u1.username as ename,u1.profile as eprofile,comment.comment,comment.comment_date,type.level_type_name,u1.id from user_comment comment,user u1,user u2,level_type type where comment.level=type.id and comment.main_user_id=u1.id and comment.sub_user_id=:user_id and comment.sub_user_id=u2.id order by comment.comment_date desc limit 1";
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.setLong("user_id",user_id);
            return (List<Object []>) sqlQuery.list();
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询用户id为"+user_id+"的咨询过的学生信息个人页面数据失败.....");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
    /**
     * 根据用户的起始时间和持续时间，判断当前时间是否在这个时间段内
     * @param time 起始时间
     * @param duration_time 持续时间
     * @return
     */
    private int IsTime_In_TimeZones(String time, String duration_time){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        GregorianCalendar calendar=new GregorianCalendar();
        Date now_date=new Date();
        try {
            Date start_date=format.parse(time);
            System.out.println(start_date.toString());
            calendar.setTime(start_date);
            calendar.add(Calendar.MINUTE,Integer.parseInt(duration_time));
            Date end_date=calendar.getTime();
            calendar.setTime(now_date);
            System.out.println(now_date.toString());
            long now_time = now_date.getTime();
            long start_time=start_date.getTime();
            long end_time=end_date.getTime();

            if(now_time>=start_time&&now_time<=end_time){
                return 1;//现在时间在目标时间之间
            }else if (now_time<start_time){
                return 2;//现在时间在目标时间之前
            }else{
                return 3;//现在时间在目标时间之后
            }
        } catch (ParseException e) {
            e.printStackTrace();
            logger.info("时间计算有误....");
            return 0;
        }
    }
    @Test
    public void test(){
        List<Object[]> userPageInfo = getUserPageInfo(6);
        for (Object [] objects : userPageInfo){
            System.out.println(String.valueOf(objects[0]));
        }
    }

}
