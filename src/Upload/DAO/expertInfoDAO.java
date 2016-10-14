package Upload.DAO;
import Entity.*;

import java.util.List;


public interface expertInfoDAO {

    /**
     * 查询老师信息列表的接口,
     * 返回老师的所有列表需要的数据
     * @return
     */
    List<ExpertsInfo> query_experts_list();

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
     * @param expert_id
     * @return
     */
     Long get_expertArticle_num(Long expert_id);

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
     List<Expert_comment_item> get_expertComment_list(Long expert_id);

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
}
