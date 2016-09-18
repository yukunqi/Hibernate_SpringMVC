package Login.Controller;


import Entity.Jsondata;
import Entity.User;
import Login.Service.Login_registerService;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 *
 */
@RestController
public class LoginController {

    @Autowired
    private Login_registerService login_registerService;

    @RequestMapping(value = "/userRegister/POST",method = RequestMethod.POST)
    public Map<String,Object> User_register(String UserRegisterJson){
         Gson gson=new Gson();
         Jsondata<User> jsondata=gson.fromJson(UserRegisterJson,new TypeToken<Jsondata<User>>(){}.getType());
         User user=jsondata.getJsondata();
         return login_registerService.register_data(user.getLogin_name(),user.getPassword());
    }
    @RequestMapping(value = "userLogin/POST",method = RequestMethod.POST)
    public Map<String,Object> User_login(String UserLoginJson){
        Gson gson=new Gson();
        Jsondata<User> jsondata=gson.fromJson(UserLoginJson,new TypeToken<Jsondata<User>>(){}.getType());
        User user=jsondata.getJsondata();
        return login_registerService.login_data(user.getLogin_name(),user.getPassword());
    }
}
