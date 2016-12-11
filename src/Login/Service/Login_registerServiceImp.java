package Login.Service;
import Entity.User;
import Login.DAO.Login_registerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.support.SaxResourceUtils;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 状态码3：字符转码错误  4 token为空 1成功 0失败
 */
@Service
public class Login_registerServiceImp implements Login_registerService{

    @Autowired
    private Login_registerDAO login_registerDAO;
    private  Logger logger=Logger.getLogger(Login_registerServiceImp.class.getName());

    @Override
    public Map<String, Object> register_data(User user) {
        /**
         * 浏览器默认编码是 ISO-8859-1,转成我们需要的utf-8。
         * 把传过来的数据转成中文字符
         */
        Map<String,Object> map=new HashMap<>();
        String password=user.getPassword();
        String name=user.getUsername();
        try {
            //name=new String(name.getBytes("ISO-8859-1"),"utf-8");
            password=new String(password.getBytes("ISO-8859-1"),"utf-8");
            int i = login_registerDAO.SaveUserData(user);
            map.put("StatusCode",i);
            return map;
        } catch (UnsupportedEncodingException e) {
            logger.info("字符转换失败....");
            e.printStackTrace();
            map.put("StatusCode",0);
            return map;
        }
    }

    @Override
    public Map<String, Object> login_data(String name, String password) {

        Map<String,Object> map=null;
        try {
            //name=new String(name.getBytes("ISO-8859-1"),"utf-8");
            password=new String(password.getBytes("ISO-8859-1"),"utf-8");
            map=login_registerDAO.query_user_login(name,password);
            if (map.isEmpty()){
                map.put("StatusCode",0);
                map.put("user_id","");
                map.put("user_token","");
                map.put("user_type","");
            }else {
                String token=login_registerDAO.GetUserToken((Long) map.get("user_id"));
                if (token.equals("")){
                    logger.info("token为空，查询不到这个id的token....");
                    map.put("StatusCode",0);
                }
                map.put("user_token",token);
                map.put("StatusCode",1);
            }
            return map;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return map;
        }
    }
}
