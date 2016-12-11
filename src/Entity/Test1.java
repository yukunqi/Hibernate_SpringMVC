package Entity;

import Tool.HibernateUtil.java.HibernateUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.mchange.v2.c3p0.stmt.GooGooStatementCache;
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
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time;
        try {
            time = format.parse("2016-10-12 08:30:00");
            bookOrders.setBook_time(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bookOrders.setDescription("324243242fsdfs");
        User expert=new User();
        User user=new User();
        expert.setId((long) 8);
        user.setId((long) 9);
        bookOrders.setExpert_user_id(expert);
        bookOrders.setUser_id(user);
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
        User expert=new User();
        Date date=new Date();
        expert.setId((long) 8);
        AppointmentSetting a1=new AppointmentSetting();

        a1.setSetting_date(date);
        a1.setDuration_time("30");
        a1.setLimited_people_num(10);
        a1.setExpert_user_id(expert);

        AppointmentSetting a2=new AppointmentSetting();

        a2.setSetting_date(date);
        a2.setDuration_time("30");
        a2.setLimited_people_num(10);
        a2.setExpert_user_id(expert);

        AppointmentSetting a3=new AppointmentSetting();

        a3.setSetting_date(date);
        a3.setDuration_time("30");
        a3.setLimited_people_num(10);
        a3.setExpert_user_id(expert);

        List<AppointmentSetting> list=new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        Gson gson=new Gson();
        String str=gson.toJson(list);
        System.out.println(str);
        List<AppointmentSetting> list2=gson.fromJson(str,new TypeToken<List<AppointmentSetting>>(){}.getType());
        AppointmentSetting appointmentSetting = list2.get(0);
        SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
        GregorianCalendar calendar=new GregorianCalendar();
        calendar.setTime(appointmentSetting.getSetting_date());
        System.out.println(format.format(appointmentSetting.getSetting_date()));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)-1);

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
        SimpleDateFormat format1=new SimpleDateFormat("HH:mm:ss");
        try {
            Date parse = format.parse("2016-10-28 8:5:00");
            System.out.println(parse.toString());
            System.out.println(format1.format(parse));
            GregorianCalendar calendar=new GregorianCalendar();
            calendar.setTime(parse);
            System.out.println(calendar.getTime().toString());
            System.out.println(calendar.get(Calendar.DAY_OF_WEEK)-1);
            System.out.println(calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
            System.out.println(calendar.get(Calendar.DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test_gson(){
        String json="{\n" +
                "    \"id\": 2\n" +
                "}";
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        try {
            User user = gson.fromJson(json, User.class);
            System.out.println(user.getId());
            System.out.println(user.getProfile());
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            System.out.println("json wrong");
        }catch (Exception e){
            System.out.println("没有这个字段");
        }
    }
    @Test
    public void test_user(){
        Jsondata<Long> jsondata=new Jsondata<>();
        jsondata.setJsondata(Long.valueOf(2));
        Gson gson=new Gson();
        String json = gson.toJson(jsondata);
        System.out.println(json);
        Jsondata<Long> j1 = gson.fromJson(json, new TypeToken<Jsondata<Long>>(){}.getType());
        System.out.println(j1.getJsondata());
    }

    @Test
    public void test_leftJoin(){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select e from Expert e inner join e.user";
            Query query = session.createQuery(sql);
            List<Expert> list = query.list();
            System.out.println(list.size());
            for (Expert e: list){
                System.out.println(e.getId());
            }
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
    public void cache_test(){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();

        Session session2=HibernateUtil.getSession();
        Transaction tx2=HibernateUtil.getTransaction();
        try {
            User u = (User) session.get(User.class, Long.valueOf(4));
            System.out.println(u.getId());
            tx.commit();
            HibernateUtil.closeSession(session);
            User u1 = (User) session2.get(User.class,Long.valueOf(4));
            System.out.println(u1.getId());
            tx2.commit();
            HibernateUtil.closeSession(session2);
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
    }
    @Test
    public void test1(){
        User user =new User();
        user.setGender("男");
        user.setCollege("传播学院");
        user.setGrade("大一");
        user.setLogin_name("2013200021");
        user.setPassword("yukunqi123");
        user.setUsername("柚子余");
        user.setPhone_number("19328399445");
        user.setWechat("uud123");
        user.setEmail("397234829@qq.com");
        Jsondata<User> jsondata=new Jsondata<>();
        jsondata.setJsondata(user);
        Gson gson=new Gson();
        String str=gson.toJson(jsondata);
        System.out.println(str);
    }
    @Test
    public void test2(){
        BookOrders bookOrders=new BookOrders();
        bookOrders.setDescription("ddsadasd");
        bookOrders.setBook_time(new Date());
        User expert_user=new User();
        expert_user.setId(Long.valueOf(1));
        bookOrders.setExpert_user_id(expert_user);
        User user=new User();
        user.setId(Long.valueOf(2));
        bookOrders.setUser_id(user);
        Gson gson=new Gson();
        String string=gson.toJson(bookOrders);
        System.out.println(string);
    }
    @Test
    public void test3(){

        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            AppointmentSetting a=new AppointmentSetting();
            a.setDuration_time("30");
            a.setLimited_people_num(5);
            a.setSetting_date(simpleDateFormat.parse("2016-12-02 15:16:00"));
            User expert=new User();
            expert.setId(Long.valueOf(2));
            a.setExpert_user_id(expert);
            Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            String string=gson.toJson(a);
            System.out.println(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test4(){

        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            BookOrders bookOrders=new BookOrders();
            bookOrders.setDescription("dsdfsdfdsf");
            Date date=simpleDateFormat.parse("2016-12-03 15:16:00");
            System.out.println(date.toString());
            bookOrders.setBook_time(date);
            User user=new User();
            user.setId(Long.valueOf(3));
            User expert=new User();
            expert.setId(Long.valueOf(4));
            bookOrders.setUser_id(user);
            bookOrders.setExpert_user_id(expert);
            Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            String string=gson.toJson(bookOrders);
            System.out.println(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
