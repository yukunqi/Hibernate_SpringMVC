package Upload.Service;

import Entity.*;

import java.util.List;
import java.util.Map;

/**
 * 老师信息接口
 */
public interface ExpertInfoService {

    /**
     * 根据传入的类型进行排序
     * 一共三种类型的排序：
     * 1.按照咨询人数降序排序
     * 2.按照好评率降序排序
     * 3.按照咨询人数和好评率结合的推荐排序
     * @param type
     * @return 排序好的list集合
     */
    List<ExpertsInfo> expertsInfoList(String type,int user_type_id);

    /**
     * 根据老师id去查询相应的咨询介绍页面的数据
     * @param expert_id
     * @return
     */
    Map<String,Object> get_ExpertPersonalPage_Data(Long expert_id);
    /**
     * 获取老师的预约时间集合
     * @param expert_id
     * @return
     */
    Map<String,Object> get_expert_AppointmentSetting(Long expert_id);
    /**
     * 根据传入的类型和用户id来查询相应的预约订单数据集合
     * @param type 订单类型
     * @param user_id 用户id
     * 1.返回所有预约时间区间在服务器时间之前的订单数据集合(已结束)
     * 2.返回所有预约时间区间在服务器时间之后的数据集合(即将开始)
     * 3.返回所有预约时间区间在服务器时间之中的数据集合(正在进行)
     * @return
     */
    List<BookOrderInfo> bookOrderInfoList_User(String type, Long user_id);
    /**
     * 根据传入的类型和老师id来查询相应的预约订单数据集合
     * @param type 订单类型
     * @param expert_id 老师id
     * 1.(已结束)
     * 2.(即将开始)
     * 3.(正在进行)
     * @return
     */
     List<BookOrderInfo> bookOrderInfoList_Expert(String type,Long expert_id);
    /**
     * 根据时间设置的id来删除相应的设置的时间的数据
     * @param appointment_id 设置的时间的id
     * @return 成功删除1 查询不到0  语句执行失败2
     */
    int delete_expert_AppointmentSetting(Long appointment_id);
    /**
     * 根据用户的id 用户想要更新的字段 更新的数据 一起进行数据库的数据的更新
     * @param user_id 用户id
     * @param column_name  用户要更新的字段的名字
     * @param data  更新的数据
     * @return  1成功 0失败 2执行语句错误
     */
    int updatePersonalInfo(Long user_id,String column_name,String data);
/*    *//**
     * 根据老师的id和设置的预约时间id去查询相应的被预约咨询订单集合
     * @param expert_id 老师id
     * @param appointment_id  预约时间id
     * @return list 集合   1正在进行    2即将开始    3已结束
     *//*
    Map<String,Object> getExpert_BookOrders(Long expert_id,Long appointment_id,String type);
    *//**
     * 根据老师的id和预约时间的id以及查询的类型去查询这个老师在这个时间段内的咨询订单集合
     * @param expert_id 老师id
     * @param appointment_id  预约时间id
     * @param type  查询类型   1正在进行    2即将开始    3已结束
     * @return
     *//*
     List<ExpertBookOrderInfo> getExpert_BookOrdersList(Long expert_id, Long appointment_id, int type);*/
    /**
     * 用户取消咨询订单
     * @param bookOrder_id  订单id
     * @return
     */
     int deleteBookOrder(Long bookOrder_id);
    /**
     * 根据用户id去查询用户的个人页面的资料
     * @param user_id 用户id
     * @return
     */
    UserPersonalPage getUserPersonalPage(Long user_id);

    /**
     * 根据用户的id去获取用户的待评价列表数据
     * @param user_id
     * @return
     */
    List<CommentBookorderEntity> getCommentBookordersEntityList(long user_id);
    /**
     * 根据用户id去获取相应的已评价列表数据
     * @param user_id
     * @return
     */
    List<CommentedBookorderEntity>  getCommentedBookordersEntityList(long user_id);
    /**
     * 根据用户id去查询相应的咨询列表信息(老师的个人页面内)
     * @param user_id
     * @return
     */
    Map<String,Object> getUserCommentInfoList(long user_id);
    /**
     * 根据老师id和类型id去查询咨询过的学生列表(老师端)
     * @param user_id
     * @return
     */
    List<UsersInfo> getUsersInfoList(long user_id,long type_id);
    /**
     * 获取老师端学生的个人页面信息(在列表点击进去之后)
     * 老师端
     * @param user_id
     * @return
     */
    UserPersonalPage getUserPageInfo(long user_id);
    /**
     * 聊天结束后 ，更新咨询订单的状态为待评价
     * @param book
     * @return
     */
    int updateBookorderStatus(BookOrders book);
    /**
     *
     * 根据老师用户id去获取相应的已点评的列表数据
     * @param user_id
     * @return
     */
    List<CommentedBookorderEntity>  getCommentedBookordersExpertList(long user_id);
    /**
     *
     * 根据老师用户id去获取相应的待点评的列表数据
     * @param user_id
     * @return
     */
    List<CommentBookorderEntity> getCommentBookordersExpertList(long user_id);
    /**
     * 获取文章列表
     * @param page_num 页数
     * @return
     */
    List<ArticleInfo> getArticleList(int page_num);
    /**
     * 获取全部文章列表 PC端
     * @return
     */
    List<ArticleInfo> getAllArticleList();
    /**
     * 根据文章id获取文章内容
     * @return
     */
    ArticleInfo getArticleDetail(long article_id);
    /**
     * 获取文章的markdown内容进行文章的内容编辑
     * @param article_id
     * @return
     */
    ArticleInfo getArticleMarkdown(long article_id);
    /**
     * 根据文章Id删除文章
     * @param article_id
     * @return
     */
    int DeleteArticle(long article_id);
    /**
     * 根据页数 获取相应的老师用户个人信息管理列表
     * @param page_num
     * @return
     */
    Map<String,Object> getExpertList(int page_num,long par_id);
    /**
     * 根据用户id去获取相应的个人数据进行编辑
     * @param user_id
     * @return
     */
    ExpertPersonalData getExpertPersosnalData(long user_id);
    /**
     * 更新老师的个人信息数据
     * @param expert 老师实体类 不包括密码 头像 登录名(不可改)
     * @return
     */
    int UpdateExpertPersonalData(Expert expert);
    /**
     * 获取应用程序封面轮播图集合
     * @return
     */
    List<PagePicture> getPagePictureList();

    List<UserType> getUserTypeList(long par_id);

}
