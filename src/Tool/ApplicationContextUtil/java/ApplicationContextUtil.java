package Tool.ApplicationContextUtil.java;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextUtil {

    private static ApplicationContext context;
    static {
        context=new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static <T> T getBean(String BeanId){
        return (T) context.getBean(BeanId);
    }
}
