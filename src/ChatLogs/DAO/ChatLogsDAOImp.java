package ChatLogs.DAO;


import Entity.ChatLogs;

import Tool.HibernateUtil.java.HibernateUtil;
import org.hibernate.*;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 聊天记录查询DAO层实现
 */
@Repository
public class ChatLogsDAOImp implements ChatLogsDAO {

    private static Logger logger=Logger.getLogger(ChatLogsDAOImp.class.getName());
    private  List<ChatLogs> chatLogsList=new ArrayList<>();
    private static int PAGE_SIZE=15;

    private static String driver="org.logicalcobwebs.proxool.ProxoolDriver";
    private static String url="jdbc:mysql://localhost:3306/xinli?rewriteBatchedStatements=true";
    private static String user="yukunqi_leap";
    private static String password="yukunqi123";
    private static Connection connection;

    /**
     * 根据用户的发送人和接收人 页数来查询聊天记录  默认单页展示15条数据
     * @param sender 发送人
     * @param receiver 接受人
     * @param page_num 页数
     * @return
     */
    public List<Object []> getUserChatLogs_HibernateUtil(String sender, String receiver,int page_num){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            page_num--;
            page_num=page_num*PAGE_SIZE;
            //    String sql="select new ChatLogs(ch.message_id) from ChatLogs ch";
            String sql="select content as CONTENT,sender as SENDER from of_chatlogs where (sender='"+sender+"' and receiver='"+receiver+"') or (sender='"+receiver+"' and receiver='"+sender+"') ORDER BY createDate ASC limit "+page_num+",15";
            System.out.println(sql);
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            return sqlQuery.list();
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("用户 "+sender+"和用户 "+receiver+" 的聊天记录查询失败..");
            if (tx!=null){
                tx.rollback();
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("hhhhhhhhhhhhhhhhhh");
            return null;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
   // INSERT INTO `xinli`.`test_chatlogs` (`session_jid`, `sender`, `receiver`, `createDate`, `length`, `content`, `detail`, `state`, `message_id`) VALUES (NULL, 'sgsdfg', 'sdfgsdfg', 'sfgsfgs', '11', 'fgsfgsdg', 'sfgsdfgsdfg', '1', NULL);

    public boolean insert(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=getConnection();
            //关闭connection默认的自动提交 ,默认一条语句提交一次.
            connection.setAutoCommit(false);

            String sql="INSERT INTO `xinli`.`test_chatlogs` (`session_jid`, `sender`, `receiver`, `createDate`, `length`, `content`, `detail`, `state`) VALUES (?,?,?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            int i=1;
            preparedStatement.setString(i++,"fdddd");
            preparedStatement.setString(i++,"me");
            preparedStatement.setString(i++,"you");
            preparedStatement.setString(i++,"201010123123");
            preparedStatement.setInt(i++,20);
            preparedStatement.setString(i++,"fsdfsdfsdfsd");
            preparedStatement.setString(i++,"fsdfsdfsdf3rw");
            preparedStatement.setInt(i++,2);

            int flag=preparedStatement.executeUpdate();
            System.out.println(flag);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (Exception e) {
                   e.printStackTrace();
                }
            }
        }
    }

    /**
     * 批量插入聊天记录测试
     * @return
     */
    public boolean list_insert(){
        ChatLogs entity=new ChatLogs();
        entity.setSession_jid("fdddd");
        entity.setSender("me");
        entity.setReceiver("you");
        entity.setCreateDate("201010123123");
        entity.setLength(20);
        entity.setContent("sdggsdgsdfgsdfgsdgsdgsdfgsdfgsfdgfsdgsdfgsfsdggsdgsdfgsdfgsdgsdgsdfgsdfgsfdgfsdgsdfgsf7867876sdggsdgsdfgsdfgsdgsdgsdfgsdfgsfdgfsdgsdfgsfsdggsdgsdfgsdfgsdgsdgsdfgsdfgsfdgfsdgsdfgsf876sdggsdgsdfgsdfgsdgsdgsdfgsdfgsfdgfsdgsdfgsf");
        entity.setDetail("sdgdfgsdgsdfgsdfgsdgsdgsdfgsdfgsfdggsdgsdfgsdfgsdgsdgsdfgsdfgsfdggsdgsdfgsdfgsdgsdgsdfgsdfgsfdggsdgsdfgsdfgsdgsdgsdfgsdfgsfdggsggsdgsdfgsdfgsdgsdgsdfgsdfgsfdg");
        entity.setState(1);
        chatLogsList.add(entity);
        System.out.println("现在list集合中存在"+chatLogsList.size()+" 条数据    "+Thread.currentThread().getName());
        if (chatLogsList.size()>=20){
            System.out.println("开启线程批量插入数据");
            //开启一条线程去执行批量数据插入
            Mythread mythread=new Mythread(chatLogsList);
            new Thread(mythread).start();
            System.out.println("清空list集合   "+Thread.currentThread().getName());
            chatLogsList=new ArrayList<>();
        }
        return true;
    }
    public synchronized boolean batch_insert(List<ChatLogs> list){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        System.out.println("开始插入  当前线程为 :"+Thread.currentThread().getName());
        try {
            connection=getConnection();
            //关闭connection默认的自动提交 ,默认一条语句提交一次.
            connection.setAutoCommit(false);
            String sql="INSERT INTO `xinli`.`test_chatlogs` (`session_jid`, `sender`, `receiver`, `createDate`, `length`, `content`, `detail`, `state`) VALUES (?,?,?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            for (int j=0;j<list.size();j++){
                System.out.println(j);
                ChatLogs chatLogs=list.get(j);
                int i=1;
                preparedStatement.setString(i++,chatLogs.getSession_jid());
                preparedStatement.setString(i++,chatLogs.getSender());
                preparedStatement.setString(i++,chatLogs.getReceiver());
                preparedStatement.setString(i++,chatLogs.getCreateDate());
                preparedStatement.setInt(i++,chatLogs.getLength());
                preparedStatement.setString(i++,chatLogs.getContent());
                preparedStatement.setString(i++,chatLogs.getDetail());
                preparedStatement.setInt(i++,chatLogs.getState());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);
            Connection connection= DriverManager.getConnection("proxool.DBPool");
            if (!connection.isClosed()){
                System.out.println("success connected..   "+Thread.currentThread().getName());
            }
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    class Mythread implements Runnable{

        private List<ChatLogs> list;

        public Mythread(List<ChatLogs> list) {
            this.list = list;
        }
        @Override
        public void run() {
            long start=System.currentTimeMillis();
            batch_insert(list);
            long end=System.currentTimeMillis();
            System.out.println("执行用时:   "+(end-start)/1000f+"秒  ");
        }
    }
}
