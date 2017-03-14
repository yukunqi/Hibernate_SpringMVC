package Upload.DAO;
import Entity.*;

import java.util.List;


public interface expertInfoDAO {

    /**
     * 查询老师信息列表的接口,
     * 返回老师的所有列表需要的数据
     * @return
     */
    List<ExpertsInfo> query_experts_list(int user_type_id);

    /**
     * 根据指定的id获取它的评论总数
     * @param expert_id
     * @return
     */
     Long getExpert_totalComment(Long expert_id);

    /**
     * 根据指定的id获取它的好评总数
     * @param  expert_id
     * @return
     */
     Long getExpert_goodComment(Long expert_id);

    /**
     * 根据老师id去查询咨询评价总数
     * @param expert_id
     * @return
     */
     Long get_expertComment_num(Long expert_id);

    /**
     * 根据id去查询指定用户发布的文章总数
     * @param user_id
     * @return
     */
     Long get_expertArticle_num(Long user_id);

    /**
     * 根据老师id去查询老师的咨询页面封面配图、个人简介、咨询人数等信息
     * @param expert_id
     * @return
     */
     ExpertPersonalPage get_ExpertchatRoominfo(Long expert_id);

    /**
     * 根据id去查询老师的咨询评价集合
     * @param expert_id
     * @return
     */
     Expert_comment_item get_expertComment_list(Long expert_id);

    /**
     * 根据用户id去查询相应的文章集合
     * @param user_id
     * @return
     */
    List<ArticleInfo> get_userArticle_list(Long user_id);

    /**
     * 根据老师id去查询老师设置的咨询预约时间集合
     * @param expert_id
     * @return
     */
    List<AppointmentSetting> get_expert_AppointmentSetting(Long expert_id);

    /**
     * 根据用户的id去查询咨询订单集合
     * @param user_id
     * @return
     */
     List<BookOrderInfo> get_User_All_BookOrders(Long user_id);
    /**
     * 根据老师id去查询相应的咨询订单集合
     * @param expert_id
     * @return
     */
     List<BookOrderInfo> get_Expert_All_BookOrders(Long expert_id);
    /**
     * 根据时间设置的id来删除相应的设置的时间的数据
     * @param appointment_id 设置的时间的id
     * @return
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
     * @return list 集合
     *//*
    List<ExpertBookOrderInfo> getExpert_BookOrders(Long expert_id,Long appointment_id);*/
    /**
     * 根据咨询订单id去取消未开始的咨询预约订单
     * @param bookOrder_id 订单id
     * @return
     */
     int deleteBookOrder(Long bookOrder_id);
    /**
     * 根据用户id去查询这个用户的最近一篇文章数据
     * @param user_id 用户id
     * @return
     */
     ArticleInfo getRecentUserArticle(Long user_id);
/*
    /**
     * 根据用户的id去查询最近的一次问答记录
     * @param user_id 用户id
     * @return

     NoteInfo getRecentNoteInfo(Long user_id);
*/

    /**
     * 根据用户Id去查询用户的基本个人资料(用户id 用户昵称 用户学院 用户性别 用户学校 用户个人签名 用户头像)
     * @param user_id 用户id
     * @return
     */
    UserPersonalPage getUserPersonalInfo(Long user_id);
    /**
     * 根据用户的id去获取用户的待评价列表数据
     * @param user_id
     * @return
     */
    List<Object []> getCommentBookordersEntityList(long user_id);
    /***
     * 根据传入的两个参数计算出百分比，保留两位小数.
     * @param goodComment
     * @param totalComment
     * @return
     */
    double get_precent(Long goodComment,Long totalComment);
    /**
     * 根据用户的id去查询相应的已评价信息列表
     * @param user_id
     * @return
     */
    List<Object []> getCommentedBookordersEntityList(long user_id);
    /**
     * 根据用户Id去查询相应的咨询评价信息列表(老师的个人信息页面中)
     * @param user_id
     * @return
     */
    List<Object []> getUserCommentInfoList(long user_id);
    /**
     * 根据老师id和类型id去查询咨询过的学生列表
     * (老师端)
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
    List<Object []> getUserPageInfo(long user_id);
    /**
     * 聊天结束，改变订单的状态为待评价
     * @param book
     * @return
     */
    int updateBookorderStatus(BookOrders book);
    /**
     * 获取老师用户的id去获取相应的老师待点评学生的列表数据
     * @return
     */
    List<Object []> getCommentBookordersExpertList(long user_id);
    /**
     * 根据老师用户的id去获取相应的老师已点评学生的列表数据
     * @param user_id
     * @return
     */
    List<Object []> getCommentedBookordersExpertList(long user_id);
    /**
     * 获取文章列表
     * @param page_num 页数 一页5条数据
     * @return
     */
    List<Object []> getArticleList(int page_num);
    /**
     *
     * 获取全部文章列表 PC端
     * @return
     */
    List<Object []> getAllArticleList();
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
     * 根据页码获取相应的咨询老师的个人数据集合
     * @param page_num
     * @return
     */
    List<Object[]> getExpertList(int page_num,long par_id);
    /**
     * 获取老师用户数据的总页数
     * @return 用总数据个数/一页展示个数
     */
    int getExpertPageAmount(long par_id);
    /**
     * 根据用户id去获取相应的个人数据进行编辑
     * @param user_id
     * @return
     */
    ExpertPersonalData getExpertPesonalData(long user_id);
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
    /**
     * 根据父类id去获取所有的子类数据集合
     * @param par_id 父类id
     * @return
     */
    List<UserType> getUserTypeList(long par_id);
}
