package Entity;

import Tool.HibernateUtil.java.HibernateUtil;
import org.apache.commons.httpclient.util.DateUtil;
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
         String name1="sdfdf";
        int code=name1.hashCode();
        int result=code&0xf;
        System.out.println(code);
        System.out.println(result);
    }
}
