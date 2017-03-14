package ChatLogs.Service;

import ChatLogs.DAO.ChatLogsDAO;
import Entity.ChatLogsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 聊天记录Service层 接口实现类
 */
@Service
public class ChatLogsServiceImp implements ChatLogsService {

    @Autowired
    private ChatLogsDAO chatLogsDAO;

    private static Logger logger=Logger.getLogger(ChatLogsServiceImp.class.getName());

    /**
     * 根据用户的发送人和接收人 页数来查询聊天记录  默认单页展示15条数据
     * @param sender 发送人
     * @param receiver 接受人
     * @param page_num 页数
     * @return
     */
    public List<ChatLogsEntity> getUserChatLogs_HibernateUtil(String sender,String receiver,int page_num){
        List<Object []> list=chatLogsDAO.getUserChatLogs_HibernateUtil(sender,receiver,page_num);
        List<ChatLogsEntity> entities=new ArrayList<>();
        for (Object [] objects:list){
            ChatLogsEntity entity=new ChatLogsEntity();
            if (objects[0]==null){//消息内容
                entity.setContent("");
            }else {
                entity.setContent(String.valueOf(objects[0]));
            }
            if (objects[1]==null){//发送者
                entity.setSender("");
            }else{
                entity.setSender(String.valueOf(objects[1]));
            }
            entities.add(entity);
        }
        return entities;
    }

    public boolean insert(){
        return chatLogsDAO.insert();
    }

    public boolean list_insert(){
        return chatLogsDAO.list_insert();
    }
}
