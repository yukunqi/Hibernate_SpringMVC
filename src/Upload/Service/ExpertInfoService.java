package Upload.Service;

import Entity.BookOrderInfo;
import Entity.ExpertsInfo;

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
    List<ExpertsInfo> expertsInfoList(String type);

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
    List<BookOrderInfo> bookOrderInfoList(String type, Long user_id);

}
