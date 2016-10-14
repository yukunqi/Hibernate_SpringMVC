package Entity;

import Tool.HibernateUtil.java.HibernateUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *
 */
public class Test1 {

    @Test
    public void Testexpert(){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {

            Expert expert=new Expert();
            expert.setBackground("心理学硕士");
            expert.setMotto("爱是治愈一切的力量");
            expert.setOthers("平时爱打球爱写作");
            expert.setQualifications("美国总统随队心理咨询师");
            expert.setStrongPoint("擅长各种被套路出现的心理问题");
            expert.setUser_id((long)3);

            User user= (User) session.get(User.class,expert.getUser_id());
            expert.setUser(user);

            session.save(expert);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
    @Test
    public void TestGson(){
        Expert expert=new Expert();
        expert.setBackground("心理士");
        expert.setMotto("爱是治愈一切的力量");
        expert.setOthers("平时爱写作");
        expert.setQualifications("美国总咨询师");
        expert.setStrongPoint("擅长各的心理问题");
        expert.setUser_id((long)18);
        Gson gson=new Gson();
        String jsonstr=gson.toJson(expert);
        System.out.println(jsonstr);
    }

    /**
     * 登录和注册的json数据生成示例
     */
    @Test
    public void Test_register(){
        Map<String,Object> map=new HashMap<>();
        User user=new User();
        user.setLogin_name("123");
        user.setPassword("454");
        Jsondata<User> jsondata=new Jsondata<>();
        jsondata.setJsondata(user);
        Gson gson=new Gson();
        String jsonstr=gson.toJson(jsondata);
        System.out.println(jsonstr);
    }

    @Test
    public void Test_ExpertsUpload(){
        Expert expert=new Expert();
        expert.setBackground("心理士");
        expert.setMotto("爱是治愈一切的力量");
        expert.setOthers("平时爱写作");
        expert.setQualifications("美国总咨询师");
        expert.setStrongPoint("擅长各的心理问题");
        expert.setUser_id((long)18);
        Jsondata<Expert> jsondata=new Jsondata<>();
        jsondata.setJsondata(expert);
        Gson gson=new Gson();
        String jsonstr=gson.toJson(jsondata);
        System.out.println(jsonstr);
        Jsondata<Expert> jsondata1=gson.fromJson(jsonstr,new TypeToken< Jsondata<Expert>>(){}.getType());
        Expert expert1=jsondata1.getJsondata();
        System.out.println(expert1.getMotto());
    }

    /**
     * 查询老师咨询好评率
     */
    @Test
    public void Test_good_comment(){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            //String sql="select new Entity.ExpertsInfo(e1.page_picture,e1.user.login_name,e1.user.college,e1.motto,e1.consult_number,e1.id) from Expert e1";
            String sql="select new Entity.Expert_percent(exc.expert.id) from Expert_comment exc";
            Query query = session.createQuery(sql);

            String sql1="select new Entity.Expert_percent(count(exc.level)) from Expert_comment exc where exc.expert.id=:expert_id";
            Query query1 = session.createQuery(sql1);

            List<Expert_percent> list1 = (List<Expert_percent>) query1.list();
            tx.commit();

            for (Expert_percent e:list1){
                System.out.println(e.getExpert_id()+"    "+e.getTotalComment());
            }
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 两个long型数字，相除保留两位小数
     */
    @Test
    public void Test_Long_change_precent(){
        Long a1= Long.valueOf(1);
        Long a2= Long.valueOf(3);
        double result=a1*1.0/a2; //不乘1.0不出正确结果
        BigDecimal b=new BigDecimal(result);
        double r1=b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(r1);
    }

    @Test
    public void Test(){
        User user=new User();
        user.setUsername("奥巴马");
        user.setEmail("123fsdf");
        user.setPhone_number("125985");
        user.setGender("1");
        Expert expert=new Expert();
        expert.setUser_id((long) 12);
        expert.setMotto("hee");
        expert.setUser(user);
        Map<String,Object> map=new HashMap<>();
        map.put("expertCardNumber","1288945");
        Jsondata<Expert> jsondata=new Jsondata<>();
        jsondata.setJsondata(expert);
        jsondata.setMap(map);
        Gson gson=new Gson();
        String str=gson.toJson(jsondata);
        System.out.println(str);
        Jsondata<Expert> jsondata1=gson.fromJson(str,new TypeToken<Jsondata<Expert>>(){}.getType());
    }
    @Test
    public void test_workpalce_json(){
        ObjectMapper mapper=new ObjectMapper();
       // mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        ExpertPersonalPage page=new ExpertPersonalPage();
        try {
            String str=mapper.writeValueAsString(page);
            System.out.println(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        BookOrders bookOrders=new BookOrders();
        bookOrders.setAge(12);
        bookOrders.setGender("男");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time;
        try {
            time = format.parse("2016-10-12 08:30:00");
            bookOrders.setBook_time(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bookOrders.setDescription("324243242fsdfs");
        bookOrders.setPeople_call("dsder3424");
        bookOrders.setPhonenumber("12569952315");
        bookOrders.setDuration_time("30");
        Expert expert=new Expert();
        User user=new User();
        expert.setId((long) 8);
        user.setId((long) 9);
        bookOrders.setExpert(expert);
        bookOrders.setUser(user);
        Gson gson=new Gson();
        String str=gson.toJson(bookOrders);
        System.out.println(str);
        BookOrders bookOrders1 = gson.fromJson(str, BookOrders.class);
        System.out.println(bookOrders1.getBook_time());
    }

    @Test
    public void test_time_compare(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取星期几
        SimpleDateFormat format_week=new SimpleDateFormat("EEEE");
        Date time1;
        Date time2;
        Date current_time=new Date();
        try {
            time1=format.parse("121-09-3 15:00:00");
            time2=format.parse("2016-10-1 14:00:00");
            System.out.println(time1.toString());
            System.out.println(time2.toString());
            System.out.println(current_time.toString());
            if(time1.before(time2)){
                System.out.println("yes time1 在time2 前面");
            }else{
                System.out.println("在后面");
            }
            String week=format_week.format(time2);
            System.out.println(week);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void time_date(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String str=format.format(date);
        System.out.println(str);
    }

    //上传老师预约时间设置的json数据
    @Test
    public void test_json_update_date(){
        Expert expert=new Expert();
        expert.setId((long) 8);
        AppointmentSetting a1=new AppointmentSetting();
        a1.setWeekday("3");
        a1.setStart_time("08:30:00");
        a1.setDuration_time("30");
        a1.setLimited_people_num(10);
        a1.setExpert(expert);

        AppointmentSetting a2=new AppointmentSetting();
        a2.setWeekday("4");
        a2.setStart_time("14:30:00");
        a2.setDuration_time("30");
        a2.setLimited_people_num(10);
        a2.setExpert(expert);

        AppointmentSetting a3=new AppointmentSetting();
        a3.setWeekday("2");
        a3.setStart_time("16:30:00");
        a3.setDuration_time("30");
        a3.setLimited_people_num(10);
        a3.setExpert(expert);

        List<AppointmentSetting> list=new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        Gson gson=new Gson();
        String str=gson.toJson(list);
        System.out.println(str);
        List<AppointmentSetting> list2=gson.fromJson(str,new TypeToken<List<AppointmentSetting>>(){}.getType());
        AppointmentSetting appointmentSetting = list2.get(0);
        System.out.println(a1.getWeekday());

    }
    @Test
    public void test_get_time_select(){
        GregorianCalendar calendar=new GregorianCalendar();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_WEEK);
        calendar.set(year,month,day,18,23,0);
        System.out.println(calendar.getTime().toString());
        calendar.add(Calendar.MINUTE,60);
        System.out.println(calendar.getTime().toString());
    }

    public GregorianCalendar getdateBy(String weekday){
        GregorianCalendar calendar=new GregorianCalendar();
        int today=calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(today);
        calendar.set(Calendar.DAY_OF_WEEK,Integer.parseInt(weekday)-today);
        System.out.println(Integer.parseInt(weekday)-today);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(day);

        calendar.set(year,month,day+1,12,12,0);
        return calendar;
    }

    @Test
    public void test_timeTranfer(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        GregorianCalendar calendar=new GregorianCalendar();
        try {
            Date date=format.parse("2016-10-12 08:29:59");//1476232200000 1476232201000
            System.out.println(date.getTime());
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE,30);
            System.out.println(calendar.getTime().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test_time_form(){

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = format.parse("2016-10-12 08:5:00");
            System.out.println(parse.toString());
            GregorianCalendar calendar=new GregorianCalendar();
            calendar.setTime(parse);
            System.out.println(calendar.getTime().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
