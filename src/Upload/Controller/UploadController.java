package Upload.Controller;

import Entity.ExpertsInfo;
import Upload.Service.ExpertInfoService;
import Upload.Service.UploadExpertImp;
import Upload.Service.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *成功返回1，失败返回0
 */
@Controller
public class UploadController {

    @Autowired
    private UploadFile uploadFile;
    @Autowired
    private UploadExpertImp uploadExpertImp;
    @Autowired
    private ExpertInfoService expertInfoService;

    @ResponseBody
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    public Map<String,Object> uploadImage(HttpServletRequest request){
            Map<String,Object> map=new HashMap<>();
            String url=uploadFile.Upload(request);
                if (url.equals("")){
                    map.put("StatueCode",0);
                }else {
                map.put("StatueCode",1);
                }
            map.put("ImageUrl",url);
                return map;
    }

    /**
     * 老师信息上传接口
     * @param request
     * @param jsonExpert
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadExpertinfo",method = RequestMethod.POST)
    public Map<String,Object> uploadExpertinfo(HttpServletRequest request,String jsonExpert){
        Map<String,Object> map=new HashMap<>();
        int result=uploadExpertImp.uploadExpertinfo(jsonExpert,request);
        map.put("StatusCode",result);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/GET/ExpertsInfo/{Type}",method = RequestMethod.GET)
    public Map<String,Object> getExpertsInfo(@PathVariable(value = "Type") String list_type){
        System.out.println(list_type);
        Map<String,Object> map=new HashMap<>();
        List<ExpertsInfo> list=expertInfoService.expertsInfoList(list_type);
        if (list.isEmpty()){
            map.put("StatusCode",0);
        }else {
            map.put("ExpertsInfo",list);
            map.put("StatusCode",1);
        }
        return map;
    }
}
