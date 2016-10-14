package Upload.Controller;


import Entity.BookOrderInfo;
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

    /**
     * 老师信息列表获取接口
     * @param list_type  获取的排序形式
     * @return
     */
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

    /**
     * 获取指定老师的个人页面介绍数据
     * @param expert_id 老师id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/ExpertsChatRoomInfo/{expert_id}",method = RequestMethod.GET)
    public Map<String, Object> getExpertChatRoomData(@PathVariable(value = "expert_id") Long expert_id){
        Map<String, Object> expertPersonalPage_data = expertInfoService.get_ExpertPersonalPage_Data(expert_id);
        return expertPersonalPage_data;
    }

    /**
     * 上传咨询预约订单
     * @param bookOrder_json 咨询预约相关json数据字符串
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/POST/BookOrder",method = RequestMethod.POST)
    public Map<String,Object> uploadOrderData(String bookOrder_json){
        int i = uploadExpertImp.uploadOrder(bookOrder_json);
        Map<String,Object> map=new HashMap<>();
        map.put("StatusCode",i);
        return map;
    }

    /**
     * 上传老师预约时间咨询数据
     * @param settingJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/POST/AppointmentSetting",method = RequestMethod.POST)
    public Map<String,Object> uploadAppointmentSetting(String settingJson){
        int i=uploadExpertImp.uploadAppointmentSetting(settingJson);
        Map<String,Object> map=new HashMap<>();
        map.put("StatusCode",i);
        return map;
    }
    /**
     * 获取老师设置的预约时间集合
     * @param expert_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/AppointmentSetting/{expert_id}",method = RequestMethod.GET)
    public Map<String,Object> get_expert_AppointmentSetting(@PathVariable(value = "expert_id")Long expert_id){
       return expertInfoService.get_expert_AppointmentSetting(expert_id);
    }

    /**
     * 获取用户咨询预约订单数据集合
     * @param type  订单类型
     * @param user_id 用户id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/getBookOrdersInfo/{type}/{user_id}",method = RequestMethod.GET)
    public Map<String,Object> getBookOrdersInfo(@PathVariable(value = "type")String type,@PathVariable(value = "user_id")Long user_id){
        Map<String,Object> map=new HashMap<>();
        if (!type.equals("1")&&!type.equals("2")&&!type.equals("3")){
            map.put("StatusCode",2);
            return map;
        }
        List<BookOrderInfo> bookOrderInfos = expertInfoService.bookOrderInfoList(type, user_id);
        if (bookOrderInfos==null){
            map.put("StatusCode",0);
        }else{
            map.put("StatusCode",1);
            map.put("jsondata",bookOrderInfos);
        }
        return map;
    }
}
