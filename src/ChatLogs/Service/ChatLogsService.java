package ChatLogs.Service;

import Entity.ChatLogsEntity;

import java.util.List;

/**
 * 聊天记录 Service层 接口
 */
public interface ChatLogsService {

    /**
     * 自己的HibernateUtil测试 Service 层
     * @param sender
     * @param receiver
     * @param page_num
     * @return
     */
    List<ChatLogsEntity> getUserChatLogs_HibernateUtil(String sender,String receiver,int page_num);

    boolean insert();

    boolean list_insert();
}
