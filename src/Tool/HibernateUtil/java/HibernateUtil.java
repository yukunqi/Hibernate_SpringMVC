package Tool.HibernateUtil.java;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.logging.Logger;


/**
 * 创建sessionFactory的工具类
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static  Session session;

    static {
        sessionFactory=getSessionFactory();
    }

    private static SessionFactory buildSessionFactory(){
        try {
            Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder serviceRegistryBuilder=new StandardServiceRegistryBuilder();
            ServiceRegistry serviceRegistry=serviceRegistryBuilder.applySettings(cfg.getProperties()).build();
            return cfg.buildSessionFactory(serviceRegistry);
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return null;
    }
    public static SessionFactory getSessionFactory(){
        if (sessionFactory==null){
            sessionFactory=buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSession(Session session){
        if (session!=null){
            if (session.isOpen()){
                session.close();
            }
        }
    }

    public static Session getSession(){
        session=sessionFactory.openSession();
        if (session!=null){
            return session;
        }else {
            Logger logger=Logger.getLogger(HibernateUtil.class.getName());
            logger.info("session is null HibernateUtil");
            return null;
        }
    }
    public static Transaction getTransaction(){
        Transaction tx=session.beginTransaction();
        if (tx!=null){
            return tx;
        }else {
            Logger logger=Logger.getLogger(HibernateUtil.class.getName());
            logger.info("Transaction is null HibernateUtil maybe you don't open the session first");
            return null;
        }
    }
}
