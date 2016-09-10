package Upload.Controller;


import Entity.Expert;
import Entity.User;
import Upload.Service.UploadExpertImp;
import Upload.Service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *成功返回1，失败返回0
 */
@Controller
public class UploadController {


    @Autowired
    private UploadService uploadService;
    @Autowired
    private UploadExpertImp uploadExpertImp;

    @ResponseBody
    @RequestMapping(value = "/uploadImage/",method = RequestMethod.POST)
    public Map<String,Object> uploadImage(HttpServletRequest request){
            Map<String,Object> map=new HashMap<>();
            String url=uploadService.Upload(request);
                if (url.equals("")){
                    map.put("StatueCode",0);
                }else {
                map.put("StatueCode",1);
                }
            map.put("ImageUrl",url);
                return map;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadPersoninfo/",method = RequestMethod.POST)
    public Map<String,Object> uploadPersoninfo(HttpServletRequest request,String jsonExpert){

        Map<String,Object> map=new HashMap<>();
        int result=uploadExpertImp.uploadExpertinfo(jsonExpert,request);
        map.put("StatusCode",result);
        return map;

    }
}
