package Upload.DAO;
import Entity.ExpertsInfo;
import Tool.HibernateUtil.java.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
    private Long getExpert_totalComment(Long expert_id){
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
    private Long getExpert_goodComment(Long expert_id){
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
            logger.info("查询失败....");
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

    @Test
    public void test(){
        List<ExpertsInfo> list = query_experts_list();
        for (ExpertsInfo e:list){
            System.out.println(e.getConsult_number());
        }
    }
}