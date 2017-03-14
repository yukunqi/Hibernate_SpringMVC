package ChatLogs.DAO;



import java.util.List;

/**
 * 聊天记录查询DAO层接口
 */
public interface ChatLogsDAO {



    /**
     * 自己的HibernateUtil测试
     * @param sender
     * @param receiver
     * @param page_num
     * @return
     */
    List<Object []> getUserChatLogs_HibernateUtil(String sender, String receiver,int page_num);

     boolean insert();

    boolean list_insert();
}
