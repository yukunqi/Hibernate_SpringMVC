package Login.Controller;

import Login.Service.Login_registerService;
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

    @RequestMapping(value = "/userRegister/POST/",method = RequestMethod.POST)
    public Map<String,Object> User_register(@RequestParam String name,
                                            @RequestParam String password){
        Map<String, Object> map = login_registerService.register_data(name, password);
        return map;
    }
    @RequestMapping(value = "userLogin/POST/",method = RequestMethod.POST)
    public Map<String,Object> User_login(@RequestParam String name,
                                         @RequestParam String password){
        return login_registerService.login_data(name, password);
    }
}
