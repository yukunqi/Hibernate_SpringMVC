package Upload.Service;

import Entity.*;
import Upload.DAO.ExpertsInfoDAOImp;
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
    public List<ExpertsInfo> expertsInfoList(String type,int user_type_id) {
            switch (type) {
                case "1":
                    return expertsInfoList1(user_type_id);
                case "2":
                    return expertsInfoList2(user_type_id);
                case "3":
                    return expertsInfoList3(user_type_id);
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
            List<Expert_comment_item> expertComment_list = expertsInfoDAO.get_expertComment_list(expert_id);
            Long expertComment_num = expertsInfoDAO.get_expertComment_num(expert_id);
            Long expert_goodComment = expertsInfoDAO.getExpert_goodComment(expert_id);

            page.setGood_comment_num(expert_goodComment);
            page.setComment_total_number(expertComment_num);

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
                map.put("id",a1.getId());
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
    public List<BookOrderInfo> bookOrderInfoList_User(String type,Long user_id){
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
     * 根据传入的类型和老师id来查询相应的预约订单数据集合
     * @param type 订单类型
     * @param expert_id 老师id
     * 1.(正在进行)
     * 2.(即将开始)
     * 3.(已结束)
     * @return
     */
    public List<BookOrderInfo> bookOrderInfoList_Expert(String type,Long expert_id){
        switch (type) {
            case "1":
                return getExpert_BookOrdersList(expert_id,1);
            case "2":
                return getExpert_BookOrdersList(expert_id,2);
            case "3":
                return getExpert_BookOrdersList(expert_id,3);
            default:
                return null;
        }
    }
    /**
     * 根据时间设置的id来删除相应的设置的时间的数据
     * @param appointment_id 设置的时间的id
     * @return 成功删除1 查询不到0  语句执行失败2
     */
    public int delete_expert_AppointmentSetting(Long appointment_id){
       return expertsInfoDAO.delete_expert_AppointmentSetting(appointment_id);
    }
    /**
     * 根据用户的id 用户想要更新的字段 更新的数据 一起进行数据库的数据的更新
     * @param user_id 用户id
     * @param column_name  用户要更新的字段的名字
     * @param data  更新的数据
     * @return  1成功 0失败 2执行语句错误
     */
    public int updatePersonalInfo(Long user_id,String column_name,String data){
        return expertsInfoDAO.updatePersonalInfo(user_id,column_name,data);
    }
    /**
     * 根据老师的id和设置的预约时间id去查询相应的被预约咨询订单集合
     * @param expert_id 老师id
     * @param appointment_id  预约时间id
     * @return list 集合   1正在进行    2即将开始    3已结束
     */
    public Map<String,Object> getExpert_BookOrders(Long expert_id,Long appointment_id,String type){
        Map<String,Object> map=new HashMap<>();
        List<ExpertBookOrderInfo> list;
        switch (type) {
            case "1":
                list=getExpert_BookOrdersList(expert_id,appointment_id,1);
                break;
            case "2":
                list=getExpert_BookOrdersList(expert_id,appointment_id,2);
                break;
            case "3":
                list=getExpert_BookOrdersList(expert_id,appointment_id,3);
                break;
            default:
                map.put("StatusCode",2);
                return map;

        }
        if (list==null){
            map.put("StatusCode",0);
        }else {
            map.put("StatusCode",1);
            map.put("jsondata",list);
        }
        return map;
    }

    /**
     * 根据老师的id和预约时间的id以及查询的类型去查询这个老师在这个时间段内的咨询订单集合
     * @param expert_id 老师id
     * @param appointment_id  预约时间id
     * @param type  查询类型   1正在进行    2即将开始    3已结束
     * @return
     */
    public List<ExpertBookOrderInfo> getExpert_BookOrdersList(Long expert_id,Long appointment_id,int type){
        List<ExpertBookOrderInfo> expert_bookOrders = expertsInfoDAO.getExpert_BookOrders(expert_id, appointment_id);
        List<ExpertBookOrderInfo> list=new ArrayList<>();
        for (int i=0;i<expert_bookOrders.size();i++){
            ExpertBookOrderInfo e=expert_bookOrders.get(i);
            int result = IsTime_In_TimeZones(e.getStart_time(), e.getDuration_time());
            if (result==type){
                list.add(e);
            }
        }
        return list;
    }

    /**
     * 根据老师id 和类型去查询相应的老师被预约咨询订单集合
     * @param expert_id 老师id
     * @param type 类型
     * @return
     */
    public List<BookOrderInfo> getExpert_BookOrdersList(Long expert_id,int type){
        List<BookOrderInfo> expert_bookOrders = expertsInfoDAO.get_Expert_All_BookOrders(expert_id);
        List<BookOrderInfo> list=new ArrayList<>();
        for (int i=0;i<expert_bookOrders.size();i++){
            BookOrderInfo e=expert_bookOrders.get(i);
            int result = IsTime_In_TimeZones(e.getStart_time(), e.getDuration_time());
            if (result==type){
                list.add(e);
            }
        }
        return list;
    }

    /**
     * 用户取消咨询订单
     * @param bookOrder_id  订单id
     * @return
     */
    public int deleteBookOrder(Long bookOrder_id){
        return expertsInfoDAO.deleteBookOrder(bookOrder_id);
    }

    /**
     * 根据用户id去查询用户的个人页面的资料
     * @param user_id 用户id
     * @return
     */
    public UserPersonalPage getUserPersonalPage(Long user_id){
        User userPersonalInfo = expertsInfoDAO.getUserPersonalInfo(user_id);
        UserPersonalPage page=new UserPersonalPage();

        if (userPersonalInfo!=null){

            page.setId(userPersonalInfo.getId());
            page.setProfile(userPersonalInfo.getProfile());
            page.setIntroduction(userPersonalInfo.getIntroduction());
            page.setGender(userPersonalInfo.getGender());
            page.setName(userPersonalInfo.getUsername());
            page.setCollege(userPersonalInfo.getCollege());
            page.setSchool_name(userPersonalInfo.getSchool_name());


            return page;
        }else{
            return null;
        }

    }

    /**
     * 根据用户的id去获取用户的待评价列表数据
     * @param user_id
     * @return
     */
    public List<CommentBookorderEntity> getCommentBookordersEntityList(long user_id){
        List<Object []> list=expertsInfoDAO.getCommentBookordersEntityList(user_id);
        if (list==null){
            return null;
        }
        List<CommentBookorderEntity> list1=new ArrayList<>();
        for (Object [] objects:list){
            CommentBookorderEntity entity=new CommentBookorderEntity();
            if (objects[0]==null){//被评价用户id
                entity.setUser_id((long)0);
            }else{
                entity.setUser_id(Long.parseLong(String.valueOf(objects[0])));
            }
            if (objects[1]==null){//用户类型
                entity.setUser_type("");
            }else {
                entity.setUser_type(String.valueOf(objects[1]));
            }
            if (objects[2]==null){//用户评价id
                entity.setComment_id((long)0);
            }else{
                entity.setComment_id(Long.parseLong(String.valueOf(objects[2])));
            }
            if (objects[3]==null){//咨询持续时间
                entity.setDuration_time("");
            }else {
                entity.setDuration_time(String.valueOf(objects[3]));
            }
            if (objects[4]==null){//预约时间
                entity.setBook_time("");
            }else {
                entity.setBook_time(String.valueOf(objects[4]));
            }
            if (objects[5]==null){//被评价用户昵称
                entity.setName("");
            }else {
                entity.setName(String.valueOf(objects[5]));
            }
            if (objects[6]==null){//被评价用户头像
                entity.setProfile("");
            }else {
                entity.setProfile(String.valueOf(objects[6]));
            }
            if (objects[7]==null){//用户的机构(可能是学院 也可能是其他医院等)
                entity.setCollege("");
            }else {
                entity.setCollege(String.valueOf(objects[7]));
            }
            if (objects[8]==null){//被评价的专家咨询人数
                entity.setCousult_number(0);
            }else {
                entity.setCousult_number(Integer.parseInt(String.valueOf(objects[8])));
            }
            if (objects[9]==null){//被评价用户的聊天名称
                entity.setSub_chat_name("");
            }else {
                entity.setSub_chat_name(String.valueOf(objects[9]));
            }
            if (objects[10]==null){//评价用户的聊天名称
                entity.setMain_chat_name("");
            }else {
                entity.setMain_chat_name(String.valueOf(objects[10]));
            }
            Long num1;
            Long num2;
            if (objects[11]==null){//被评价用户的好评个数
                num1=Long.valueOf(0);
            }else{
                num1=Long.valueOf(String.valueOf(objects[11]));
            }

            if (objects[12]==null){//被评价用户的总评个数
                num2=Long.valueOf(0);
            }else{
                num2=Long.valueOf(String.valueOf(objects[12]));
            }
            if (objects[13]==null){//咨询订单id
                entity.setBook_id((long)0);
            }else {
                entity.setBook_id(Long.parseLong(String.valueOf(objects[13])));
            }

            entity.setGood_comment(expertsInfoDAO.get_precent(num1,num2));
            list1.add(entity);
        }
        return list1;
    }

    /**
     * 根据用户id去获取相应的已评价列表数据
     * @param user_id
     * @return
     */
    public List<CommentedBookorderEntity>  getCommentedBookordersEntityList(long user_id){
        List<Object []> list=expertsInfoDAO.getCommentedBookordersEntityList(user_id);
        if (list==null){
            return null;
        }
        List<CommentedBookorderEntity> list1=new ArrayList<>();
        for (Object [] objects:list){
            CommentedBookorderEntity entity=new CommentedBookorderEntity();
            if (objects[0]==null){//被评价用户id
                entity.setUser_id((long)0);
            }else{
                entity.setUser_id(Long.parseLong(String.valueOf(objects[0])));
            }
            if (objects[1]==null){//用户类型
                entity.setUser_type("");
            }else {
                entity.setUser_type(String.valueOf(objects[1]));
            }
            if (objects[2]==null){//用户评价id
                entity.setComment_id((long)0);
            }else{
                entity.setComment_id(Long.parseLong(String.valueOf(objects[2])));
            }
            if (objects[3]==null){//咨询持续时间
                entity.setDuration_time("");
            }else {
                entity.setDuration_time(String.valueOf(objects[3]));
            }
            if (objects[4]==null){//预约时间
                entity.setBook_time("");
            }else {
                entity.setBook_time(String.valueOf(objects[4]));
            }
            if (objects[5]==null){//被评价用户昵称
                entity.setName("");
            }else {
                entity.setName(String.valueOf(objects[5]));
            }
            if (objects[6]==null){//被评价用户头像
                entity.setProfile("");
            }else {
                entity.setProfile(String.valueOf(objects[6]));
            }
            if (objects[7]==null){//用户的机构(可能是学院 也可能是其他医院等)
                entity.setCollege("");
            }else {
                entity.setCollege(String.valueOf(objects[7]));
            }
            if (objects[8]==null){//被评价的专家咨询人数
                entity.setCousult_number(0);
            }else {
                entity.setCousult_number(Integer.parseInt(String.valueOf(objects[8])));
            }
            if (objects[9]==null){//被评价用户的聊天名称
                entity.setSub_chat_name("");
            }else {
                entity.setSub_chat_name(String.valueOf(objects[9]));
            }
            if (objects[10]==null){//评价用户的聊天名称
                entity.setMain_chat_name("");
            }else {
                entity.setMain_chat_name(String.valueOf(objects[10]));
            }
            Long num1;
            Long num2;
            if (objects[11]==null){//被评价用户的好评个数
                num1=Long.valueOf(0);
            }else{
                num1=Long.valueOf(String.valueOf(objects[11]));
            }

            if (objects[12]==null){//被评价用户的总评个数
                num2=Long.valueOf(0);
            }else{
                num2=Long.valueOf(String.valueOf(objects[12]));
            }

            entity.setGood_comment(expertsInfoDAO.get_precent(num1,num2));

            if (objects[13]==null){//评价时间
                entity.setComment_time("");
            }else{
                entity.setComment_time(String.valueOf(objects[13]));
            }
            if (objects[14]==null){//评价程度
                entity.setLevel("好评");
            }else{
                entity.setLevel(String.valueOf(objects[14]));
            }
            if (objects[15]==null){//评价内容
                entity.setComment_content("");
            }else {
                entity.setComment_content(String.valueOf(objects[15]));
            }
            list1.add(entity);
        }
        return list1;
    }

    /**
     * 根据用户id去查询相应的咨询列表信息(老师的个人页面内)
     * @param user_id
     * @return
     */
    public Map<String,Object> getUserCommentInfoList(long user_id){
        List<Object []> list=expertsInfoDAO.getUserCommentInfoList(user_id);
        int total_good_num=0;
        if (list==null){
            return null;
        }
        List<UserCommentInfo> list1=new ArrayList<>();
        for (Object [] objects:list){
            UserCommentInfo entity=new UserCommentInfo();
            if (objects[0]==null){//用户id
                entity.setId((long)0);
            }else {
                entity.setId(Long.parseLong(String.valueOf(objects[0])));
            }
            if (objects[1]==null){//用户昵称
                entity.setName("");
            }else {
                entity.setName(String .valueOf(objects[1]));
            }
            if (objects[2]==null){//用户头像
                entity.setProfile("");
            }else {
                entity.setProfile(String.valueOf(objects[2]));
            }
            if (objects[3]==null){//好坏程度
                entity.setLevel("好评");
            }else {
                entity.setLevel(String.valueOf(objects[3]));
            }
            if (objects[4]==null){//评价时间
                entity.setDate("");
            }else{
                entity.setDate(String.valueOf(objects[4]));
            }
            if (objects[5]==null){
                entity.setContent("");
            }else {
                entity.setContent(String.valueOf(objects[5]));
            }
            if (objects[6]==null){
                entity.setAnonymous(0);
            }else{
                entity.setAnonymous(Integer.parseInt(String.valueOf(objects[6])));
            }

            if (entity.getAnonymous()==1){//用户选择匿名
                entity.setName("匿名");
            }
            list1.add(entity);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("jsondata",list1);
        map.put("total_good_num",total_good_num);
        return map;
    }
    /**
     * 根据老师id和类型id去查询咨询过的学生列表(老师端)
     * @param user_id
     * @return
     */
    public List<UsersInfo> getUsersInfoList(long user_id,long type_id){
        return expertsInfoDAO.getUsersInfoList(user_id,type_id);
    }

    /**
     * 获取老师端学生的个人页面信息(在列表点击进去之后)
     * 老师端
     * @param user_id
     * @return
     */
    public UserPersonalPage getUserPageInfo(long user_id){
        List<Object []> list=expertsInfoDAO.getUserPageInfo(user_id);
        UserPersonalPage entity=new UserPersonalPage();
        if (list==null){
            return null;
        }
        for (Object [] objects:list){

            if (objects[0]==null){//用户昵称
                entity.setName("");
            }else{
                entity.setName(String.valueOf(objects[0]));
            }
            if (objects[1]==null){//用户头像
                entity.setProfile("");
            }else{
                entity.setProfile(String.valueOf(objects[1]));
            }
            if (objects[2]==null){//用户介绍
                entity.setIntroduction("");
            }else{
                entity.setIntroduction(String.valueOf(objects[2]));
            }
            Expert_comment_item item=new Expert_comment_item();
            if (objects[3]==null){//评价用户的昵称
                item.setAuthor_name("");
            }else {
                item.setAuthor_name(String.valueOf(objects[3]));
            }
            if (objects[4]==null){//评价用户的头像
                item.setProfile("");
            }else {
                item.setProfile(String.valueOf(objects[4]));
            }
            if (objects[5]==null){//评价用户的评论
                item.setComment_content("");
            }else {
                item.setComment_content(String.valueOf(objects[5]));
            }
            if (objects[6]==null){//评价用户的评价时间
                item.setComment_time("");
            }else {
                item.setComment_time(String.valueOf(objects[6]));
            }
            if (objects[7]==null){//评价用户的好坏程度
                item.setLevel("");
            }else {
                item.setLevel(String.valueOf(objects[7]));
            }
            if (objects[8]==null){//评价用户的id
                item.setUser_id((long)0);
            }else{
                item.setUser_id(Long.parseLong(String.valueOf(objects[8])));
            }
            entity.setItem(item);
        }
        return entity;
    }
    /**
     * 按照咨询人数降序排序
     * @return
     */
    public List<ExpertsInfo> expertsInfoList1(int user_type_id){
        return expertsInfoDAO.query_experts_list(user_type_id);
    }

    /**
     * 按照好评率进行降序排序
     * @return
     */
    public  List<ExpertsInfo> expertsInfoList2(int user_type_id){
        List<ExpertsInfo> list = expertsInfoDAO.query_experts_list(user_type_id);
        if (list!=null){
            return sort1(list);
        }else {
            return null;
        }

    }

    /**
     * 热门推荐，按照好评率和咨询人数权重各百分之50进行降序排序
     * 具体的推荐算法设计以后可以更加专业
     * @return
     */
    public  List<ExpertsInfo> expertsInfoList3(int user_type_id){
        List<ExpertsInfo> list = expertsInfoDAO.query_experts_list(user_type_id);
        if (list!=null){
            return sort2(list);
        }else {
            return null;
        }
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
//        List<ExpertsInfo> list = expertsInfoDAO.query_experts_list(1);
//        for (ExpertsInfo e:list){
//            System.out.println(e.getConsult_number());
//        }
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
        List<BookOrderInfo> user_all_bookOrders  = expertsInfoDAO.get_User_All_BookOrders(user_id);
        List<BookOrderInfo> user_all_bookOrders2=new ArrayList<>();
        for (int i=0;i<user_all_bookOrders.size();i++){
            int result=IsTime_In_TimeZones(user_all_bookOrders.get(i).getStart_time(),user_all_bookOrders.get(i).getDuration_time());
            if (result==1){
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
            if (result==3){
                user_all_bookOrders2.add(user_all_bookOrders.get(i));
            }
        }
        return user_all_bookOrders2;
    }

    /**
     * 根据用户的起始时间和持续时间，判断当前时间是否在这个时间段内
     * @param time 起始时间
     * @param duration_time 持续时间
     * @return
     */
    private int IsTime_In_TimeZones(String time, String duration_time){
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
}
