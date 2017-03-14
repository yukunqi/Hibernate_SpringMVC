package ChatLogs.Controller;

import ChatLogs.Service.ChatLogsService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 聊天记录Controller层
 */
@Controller
public class ChatLogsController {

    private static Logger logger=Logger.getLogger(ChatLogsController.class.getName());
    @Autowired
    private ChatLogsService chatLogsService;

    @RequestMapping(value = "/POST/getUserChatLogs",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getUserChatLogs(String chatlogsJson){
        Map<String,Object> map=new HashMap<>();
        try {
            Gson gson=new Gson();
            Map<String,Object> map1=gson.fromJson(chatlogsJson,Map.class);
            String sender= (String) map1.get("sender");
            String receiver= (String) map1.get("receiver");
            int page_num= Integer.parseInt((String) map1.get("page_num"));
            map.put("StatusCode",1);
            map.put("jsondata",chatLogsService.getUserChatLogs_HibernateUtil(sender,receiver,page_num));
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            map.put("StatusCode",5);
        }catch (Exception e){
            e.printStackTrace();
            map.put("StatusCode",6);
        }
        return map;
    }

    @RequestMapping(value = "/GET/test_insert/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> insert(@PathVariable(value = "id") String id){
        System.out.println(id);
        Map<String,Object> map=new HashMap<>();
        //map.put("jsondata",chatLogsService.insert());
        map.put("jsondata",chatLogsService.list_insert());
        return map;
    }
}
