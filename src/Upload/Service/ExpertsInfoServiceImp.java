package Upload.Service;

import Entity.*;
import Upload.DAO.expertInfoDAO;
import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * 处理咨询列表的service
 */
@Service
public class ExpertsInfoServiceImp implements ExpertInfoService {

    private static Logger logger=Logger.getLogger(ExpertsInfoServiceImp.class.getName());
    @Autowired
    private  expertInfoDAO expertsInfoDAO;

    @Override
    public List<ExpertsInfo> expertsInfoList(String type) {
            switch (type) {
                case "1":
                    return expertsInfoList1();
                case "2":
                    return expertsInfoList2();
                case "3":
                    return expertsInfoList3();
                default:
                    return new ArrayList<>();
            }
    }

    @Override
    public Map<String,Object> get_ExpertPersonalPage_Data(Long expert_id) {
        Map<String,Object> map=new HashMap<>();

        ExpertPersonalPage page=expertsInfoDAO.get_ExpertchatRoominfo(expert_id);
        if (page==null){
            map.put("StatusCode",0);
        }else {
            Long expertArticle_num = expertsInfoDAO.get_expertArticle_num(page.getUser_id());
            List<Expert_comment_item> expertComment_list = expertsInfoDAO.get_expertComment_list(expert_id);
            List<ArticleInfo> userArticle_list = expertsInfoDAO.get_userArticle_list(page.getUser_id());
            Long expertComment_num = expertsInfoDAO.get_expertComment_num(expert_id);
            Long expert_goodComment = expertsInfoDAO.getExpert_goodComment(expert_id);

            page.setGood_comment_num(expert_goodComment);
            page.setComment_total_number(expertComment_num);
            page.setArticle_total_number(expertArticle_num);
            if (!userArticle_list.isEmpty()){
                page.setArticle(userArticle_list.get(0));
            }

            if (!expertComment_list.isEmpty()){
                page.setItem(expertComment_list.get(0));
            }
            map.put("StatusCode",1);
            map.put("jsondata",page);
        }
        return map;
    }

    /**
     * 获取老师的预约时间集合
     * @param expert_id
     * @return
     */
    public Map<String,Object> get_expert_AppointmentSetting(Long expert_id){
        Map<String,Object> map_result=new HashMap<>();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE");
        List<AppointmentSetting> expert_appointmentSetting = expertsInfoDAO.get_expert_AppointmentSetting(expert_id);
        if (expert_appointmentSetting==null){
            map_result.put("StatusCode",0);
        }else if(expert_appointmentSetting.isEmpty()){
            map_result.put("StatusCode",2);
        }else{
            List<Map<String,Object>> mapList=new ArrayList<>();
            for (AppointmentSetting a1:expert_appointmentSetting){
                GregorianCalendar calendar = getdateBy(a1.getWeekday(), a1.getStart_time());
                Map<String,Object> map=new HashMap<>();
                map.put("weekday",format.format(calendar.getTime()));
                map.put("duration_time",a1.getDuration_time());
                map.put("limited_people_num",a1.getLimited_people_num());
                map.put("ordered_people_num",a1.getOrdered_people_num());
                mapList.add(map);
            }
            map_result.put("StatusCode",1);
            map_result.put("jsondata",mapList);
        }
        return map_result;
    }

    /**
     * 根据传入的类型和用户id来查询相应的预约订单数据集合
     * @param type 订单类型
     * @param user_id 用户id
     * 1.(已结束)
     * 2.(即将开始)
     * 3.(正在进行)
     * @return
     */
    public List<BookOrderInfo> bookOrderInfoList(String type,Long user_id){
        switch (type) {
            case "1":
                return bookOrderInfoList1(user_id);
            case "2":
                return bookOrderInfoList2(user_id);
            case "3":
                return bookOrderInfoList3(user_id);
            default:
                return null;
        }

    }
    /**
     * 按照咨询人数降序排序
     * @return
     */
    public List<ExpertsInfo> expertsInfoList1(){
        return expertsInfoDAO.query_experts_list();
    }

    /**
     * 按照好评率进行降序排序
     * @return
     */
    public  List<ExpertsInfo> expertsInfoList2(){
        return sort1(expertsInfoDAO.query_experts_list());
    }

    /**
     * 热门推荐，按照好评率和咨询人数权重各百分之50进行降序排序
     * 具体的推荐算法设计以后可以更加专业
     * @return
     */
    public  List<ExpertsInfo> expertsInfoList3(){
        return sort2(expertsInfoDAO.query_experts_list());
    }

    /**
     * 利用java自带的Comparable<T>接口实现排序，在需要排序的对象属性上进行
     * 重写compareTO方法
     * @param list
     * @return
     */
    public List<ExpertsInfo> sort1(List<ExpertsInfo> list){
        Collections.sort(list,new ExpertComparator2());
        return list;
    }

    //要使用springJunitTestrunner来测试才行，否则不会加载spring的注入
    @Test
    public void Test(){
        List<ExpertsInfo> list = expertsInfoDAO.query_experts_list();
        for (ExpertsInfo e:list){
            System.out.println(e.getConsult_number());
        }
    }

    /**
     * 根据老师的好评率和咨询人数综合排序
     * @param list
     * @return
     */
    public List<ExpertsInfo> sort2(List<ExpertsInfo> list){
        Collections.sort(list,new ExpertComparator());
        return list;
    }

    /**
     * 根据开始的具体时间(14：20：00)和星期几来获得这个星期中这个星期几的具体日期
     * @param weekday 星期几
     * @param start_time  开始的具体时间
     * @return
     */
    public GregorianCalendar getdateBy(String weekday,String start_time){
        GregorianCalendar calendar=new GregorianCalendar();
        //GregorianCalendar中的星期是周日为1，周六为7 减1变成我们熟悉的周一到周日
        int today=calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println("today"+today);
        calendar.add(Calendar.DAY_OF_WEEK,Integer.parseInt(weekday)-today);
        System.out.println(Integer.parseInt(weekday)-today);

        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("year"+year);
        System.out.println("month"+month);
        System.out.println("day"+day);

        String [] result=start_time.split(":");//15:30:00
        int hour=Integer.parseInt(result[0]);//获取小时
        int minutes=Integer.parseInt(result[1]);//获取分钟
        int second=Integer.parseInt(result[2]);//获取秒数

        calendar.set(year,month,day,hour,minutes,second);
        System.out.println("date"+calendar.getTime().toString());
        return calendar;
    }

    /**
     * 返回所有预约时间区间在服务器时间之前的订单数据集合(已结束)
     * @param user_id 用户id
     * @return
     */
    private List<BookOrderInfo> bookOrderInfoList1(Long user_id){
        List<BookOrderInfo> user_all_bookOrders = expertsInfoDAO.get_User_All_BookOrders(user_id);
        List<BookOrderInfo> user_all_bookOrders2=new ArrayList<>();
        for (int i=0;i<user_all_bookOrders.size();i++){
            int result=IsTime_In_TimeZones(user_all_bookOrders.get(i).getStart_time(),user_all_bookOrders.get(i).getDuration_time());
            if (result==3){
                user_all_bookOrders2.add(user_all_bookOrders.get(i));
            }
        }
        return user_all_bookOrders2;
    }

    /**
     * 返回所有预约时间区间在服务器时间之后的数据集合(即将开始)
     * @param user_id
     * @return
     */
    private List<BookOrderInfo> bookOrderInfoList2(Long user_id){
        List<BookOrderInfo> user_all_bookOrders = expertsInfoDAO.get_User_All_BookOrders(user_id);
        List<BookOrderInfo> user_all_bookOrders2=new ArrayList<>();
        for (int i=0;i<user_all_bookOrders.size();i++){
            int result=IsTime_In_TimeZones(user_all_bookOrders.get(i).getStart_time(),user_all_bookOrders.get(i).getDuration_time());
            if (result==2){
                user_all_bookOrders2.add(user_all_bookOrders.get(i));
            }
        }
        return user_all_bookOrders2;
    }
    /**
     * 返回所有预约时间区间在服务器时间之中的数据集合(正在进行)
     * @param user_id
     * @return
     */
    private List<BookOrderInfo> bookOrderInfoList3(Long user_id){
        List<BookOrderInfo> user_all_bookOrders = expertsInfoDAO.get_User_All_BookOrders(user_id);
        List<BookOrderInfo> user_all_bookOrders2=new ArrayList<>();
        for (int i=0;i<user_all_bookOrders.size();i++){
            int result=IsTime_In_TimeZones(user_all_bookOrders.get(i).getStart_time(),user_all_bookOrders.get(i).getDuration_time());
            if (result==1){
                user_all_bookOrders2.add(user_all_bookOrders.get(i));
            }
        }
        return user_all_bookOrders2;
    }

    public int IsTime_In_TimeZones(String time,String duration_time){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        GregorianCalendar calendar=new GregorianCalendar();
        Date now_date=new Date();
        try {
            Date start_date=format.parse(time);
            System.out.println(start_date.toString());
            calendar.setTime(start_date);
            calendar.add(Calendar.MINUTE,Integer.parseInt(duration_time));
            Date end_date=calendar.getTime();
            calendar.setTime(now_date);
            System.out.println(now_date.toString());
            long now_time = now_date.getTime();
            long start_time=start_date.getTime();
            long end_time=end_date.getTime();

            if(now_time>=start_time&&now_time<=end_time){
                return 1;//现在时间在目标时间之间
            }else if (now_time<start_time){
                return 2;//现在时间在目标时间之前
            }else{
                return 3;//现在时间在目标时间之后
            }
        } catch (ParseException e) {
            e.printStackTrace();
            logger.info("时间计算有误....");
            return 0;
        }
    }

    @Test
    public void  test(){

    }
}
