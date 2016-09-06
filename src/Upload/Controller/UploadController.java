package Upload.Controller;


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

    @ResponseBody
    @RequestMapping(value = "/upload2/",method = RequestMethod.POST)
    public Map<String,Object> upload2(HttpServletResponse response,HttpServletRequest request,Exception e){
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
}
