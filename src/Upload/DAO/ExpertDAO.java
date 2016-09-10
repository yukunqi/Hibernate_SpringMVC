package Upload.DAO;

import Entity.Expert;
import Entity.User;
import Tool.HibernateUtil.java.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

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
            expert.setUser(list.get(0));
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
}
