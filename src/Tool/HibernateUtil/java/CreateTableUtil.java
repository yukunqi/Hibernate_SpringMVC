package Tool.HibernateUtil.java;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * 生成表结构
 * hibernate会根据你的注解去生成相应的表在数据库中
 */
public class CreateTableUtil {

    @Test
    public void Create_Table(){
        Configuration configuration=new Configuration().configure();
        SchemaExport schemaExport=new SchemaExport(configuration);
        schemaExport.create(true,true);
    }
}
