package Upload.DAO;
import Entity.*;
import Tool.HibernateUtil.java.HibernateUtil;
import com.google.gson.Gson;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
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
    public List<ExpertsInfo> query_experts_list(){
        List<ExpertsInfo> expertsAllinfos = getExpertsAllinfos();
        return get_ExpertsComment_number(expertsAllinfos);
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
             Long good=getExpert_goodComment(e.getExpert_id());
             Long total=getExpert_totalComment(e.getExpert_id());
             e.setGood_comment(get_precent(good,total));
         }
        return experts;
    }

    /**
     * 根据指定的id获取它的评论总数
     * @param expert_id
     * @return
     */
    public Long getExpert_totalComment(Long expert_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select count(exc.level) from Expert_comment exc where exc.expert.id=:expert_id";
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
     * 根据指定的id获取它的好评总数
     * @param  expert_id
     * @return
     */
    public Long getExpert_goodComment(Long expert_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select count(exc.level) from Expert_comment exc where exc.expert.id=:expert_id and exc.level=1";
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
    private List<ExpertsInfo> getExpertsAllinfos(){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        List<ExpertsInfo> list;
        try {
            String sql="select new Entity.ExpertsInfo(e1.page_picture,e1.user.login_name,e1.user.college,e1.motto,e1.consult_number,e1.id) from Expert e1 order by e1.consult_number desc";
            Query query = session.createQuery(sql);
            list=(List<ExpertsInfo>) query.list();
            tx.commit();
            return list;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("查询老师信息集合失败....");
            if (tx!=null){
                tx.rollback();
            }
            list=new ArrayList<>();
            return list;
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
    private double get_precent(Long goodComment,Long totalComment){
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
            String sql="select count (exc.id) from Expert_comment exc where exc.expert.id=:expert_id";
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
            String sql="select new Entity.ExpertPersonalPage(exp.user.introduction,exp.page_picture,exp.consult_number,exp.id,exp.user.id) from Expert exp where exp.id=:expert_id";
            Query query = session.createQuery(sql);
            query.setLong("expert_id",expert_id);
            return (ExpertPersonalPage) query.uniqueResult();
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
            String sql="select new Entity.Expert_comment_item(exp_comment.user.username,exp_comment.comment,exp_comment.user.profile,exp_comment.comment_time,exp_comment.level,exp_comment.user.id) from Expert_comment exp_comment where exp_comment.expert.id=:expert_id order by exp_comment.id desc ";
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
     * @param expert_id
     * @return
     */
    public List<AppointmentSetting> get_expert_AppointmentSetting(Long expert_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new AppointmentSetting(a1.weekday,a1.start_time,a1.duration_time,a1.limited_people_num,a1.ordered_people_num) from AppointmentSetting a1 where a1.expert.id=:expert_id";
            Query query = session.createQuery(sql);
            query.setLong("expert_id",expert_id);
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
     * 根据用户的id去查询咨询订单集合
     * @param user_id
     * @return
     */
    public List<BookOrderInfo> get_User_All_BookOrders(Long user_id){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new Entity.BookOrderInfo(book.id,book.user.username,book.book_time,book.duration_time,book.user.profile) from BookOrders book where book.user.id=:user_id";
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
}
