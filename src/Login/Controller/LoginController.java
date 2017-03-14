package Login.Controller;


import Entity.Jsondata;
import Entity.User;
import Login.Service.Login_registerService;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 */
@RestController
public class LoginController {

    @Autowired
    private Login_registerService login_registerService;
    private static Logger logger=Logger.getLogger(LoginController.class.getName());

    /**
     * 用户注册接口
     * @param UserRegisterJson 用户注册Json数据
     * @return
     */
    @RequestMapping(value = "/userRegister/POST",method = RequestMethod.POST)
    public Map<String,Object> User_register(String UserRegisterJson){
        Gson gson=new Gson();
        try{
            Jsondata<User> jsondata=gson.fromJson(UserRegisterJson,new TypeToken<Jsondata<User>>(){}.getType());
            User user=jsondata.getJsondata();
            return login_registerService.register_data(user);
        }catch (JsonSyntaxException e){
            logger.info("用户注册JSON解析失败......");
            e.printStackTrace();
            Map<String,Object> map=new HashMap<>();
            map.put("StatusCode",5);
            return map;
        }catch (Exception e){
            logger.info("用户注册JSON数据实体不存在或其他内部错误......");
            e.printStackTrace();
            Map<String,Object> map=new HashMap<>();
            map.put("StatusCode",6);
            return map;
        }

    }

    /**
     * 用户登录接口
     * @param UserLoginJson 用户登录Json数据
     * @return
     */
    @RequestMapping(value = "userLogin/POST",method = RequestMethod.POST)
    public Map<String,Object> User_login(String UserLoginJson){
        Gson gson=new Gson();
        try {
            Jsondata<User> jsondata=gson.fromJson(UserLoginJson,new TypeToken<Jsondata<User>>(){}.getType());
            User user=jsondata.getJsondata();
            return login_registerService.login_data(user.getLogin_name(),user.getPassword());
        }catch (JsonSyntaxException e){
            logger.info("用户登录JSON解析失败......");
            e.printStackTrace();
            Map<String,Object> map=new HashMap<>();
            map.put("StatusCode",5);
            return map;
        }catch (Exception e){
            logger.info("用户登录JSON数据实体不存在或其他内部错误......");
            e.printStackTrace();
            Map<String,Object> map=new HashMap<>();
            map.put("StatusCode",6);
            return map;
        }

    }
    @RequestMapping(value = "cache/{id}",method = RequestMethod.GET)
    public String test_cache(@PathVariable(value = "id") long id){
        System.out.println(id);
        login_registerService.cache_user_test();
        return "hello";
    }
}
