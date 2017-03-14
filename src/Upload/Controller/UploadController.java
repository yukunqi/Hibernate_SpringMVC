package Upload.Controller;


import Entity.*;
import Upload.Service.ExpertInfoService;
import Upload.Service.UploadExpertImp;
import Upload.Service.UploadFile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *成功返回1，失败返回0
 */
@Controller
public class UploadController {

    @Autowired
    private UploadFile uploadFile;
    @Autowired
    private UploadExpertImp uploadExpertImp;
    @Autowired
    private ExpertInfoService expertInfoService;

    private static Logger logger=Logger.getLogger(UploadController.class.getName());

    @ResponseBody
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    public Map<String,Object> uploadImage(@RequestParam(value = "editormd-image-file",required = false)MultipartFile file){
            Map<String,Object> map=new HashMap<>();
            String url=uploadFile.UploadMultipartFile(file);
                if (url.equals("")){
                    map.put("success",0);
                }else {
                map.put("success",1);
                map.put("message","image upload success");
                }
                map.put("url",url);
                return map;
    }

    /**
     * 老师信息上传接口
     * @param request
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadExpertinfo",method = RequestMethod.POST)
    public Map<String,Object> uploadExpertinfo(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        int result=uploadExpertImp.uploadExpertinfo(request.getParameter("jsonExpert"),request);
        map.put("StatusCode",result);
        return map;
    }

    /**
     * 老师信息列表获取接口
     * @param list_type  获取的排序形式
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/ExpertsInfo/{Type}/{user_type_id}",method = RequestMethod.GET)
    public Map<String,Object> getExpertsInfo(@PathVariable(value = "Type") String list_type,
                                             @PathVariable(value = "user_type_id") int user_type_id){
        System.out.println(list_type);
        Map<String,Object> map=new HashMap<>();
        List<ExpertsInfo> list=expertInfoService.expertsInfoList(list_type,user_type_id);
        if (list==null){
            map.put("StatusCode",0);
        }else {
            map.put("ExpertsInfo",list);
            map.put("StatusCode",1);
        }
        return map;
    }

    /**
     * 获取指定老师的个人页面介绍数据
     * @param expert_id 老师id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/ExpertsChatRoomInfo/{expert_id}",method = RequestMethod.GET)
    public Map<String, Object> getExpertChatRoomData(@PathVariable(value = "expert_id") Long expert_id){
        Map<String, Object> expertPersonalPage_data = expertInfoService.get_ExpertPersonalPage_Data(expert_id);
        return expertPersonalPage_data;
    }

    /**
     * 上传咨询预约订单
     * @param bookOrder_json 咨询预约相关json数据字符串
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/POST/BookOrder",method = RequestMethod.POST)
    public Map<String,Object> uploadOrderData(String bookOrder_json){
        int i = uploadExpertImp.uploadOrder(bookOrder_json);
        Map<String,Object> map=new HashMap<>();
        map.put("StatusCode",i);
        return map;
    }

    /**
     * 上传老师预约时间咨询数据
     * @param settingJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/POST/AppointmentSetting",method = RequestMethod.POST)
    public Map<String,Object> uploadAppointmentSetting(String settingJson){
        int i=uploadExpertImp.uploadAppointmentSetting(settingJson);
        Map<String,Object> map=new HashMap<>();
        map.put("StatusCode",i);
        return map;
    }
    /**
     * 获取老师设置的预约时间集合
     * @param expert_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/AppointmentSetting/{expert_id}",method = RequestMethod.GET)
    public Map<String,Object> get_expert_AppointmentSetting(@PathVariable(value = "expert_id")Long expert_id){
       return expertInfoService.get_expert_AppointmentSetting(expert_id);
    }

    /**
     * 获取用户咨询预约订单数据集合
     * @param type  订单类型
     * @param id 用户id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/getUserBookOrdersInfo/{type}/{id}",method = RequestMethod.GET)
    public Map<String,Object> getBookOrdersInfo(@PathVariable(value = "type")String type,
                                                @PathVariable(value = "id")Long id){
        Map<String,Object> map=new HashMap<>();
        if ((!type.equals("1")&&!type.equals("2")&&!type.equals("3"))){
            map.put("StatusCode",2);
            return map;
        }
        List<BookOrderInfo> bookOrderInfos = expertInfoService.bookOrderInfoList_User(type, id);
        if (bookOrderInfos==null){
            map.put("StatusCode",0);
        }else{
            map.put("StatusCode",1);
            map.put("jsondata",bookOrderInfos);
        }
        return map;
    }

    /**
     * 根据id去获取老师被预约订单集合
     * @param type 订单类型
     * @param id  用户id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/getExpertBookOrdersInfo/{type}/{id}",method = RequestMethod.GET)
    public Map<String,Object> getExpertBookOrdersInfo(@PathVariable(value = "type")String type,
                                                @PathVariable(value = "id")Long id){
        Map<String,Object> map=new HashMap<>();
        if ((!type.equals("1")&&!type.equals("2")&&!type.equals("3"))){
            map.put("StatusCode",2);
            return map;
        }
        List<BookOrderInfo> expertBookOrderInfos = expertInfoService.bookOrderInfoList_Expert(type, id);
        if (expertBookOrderInfos==null){
            map.put("StatusCode",0);
        }else{
            map.put("StatusCode",1);
            map.put("jsondata",expertBookOrderInfos);
        }
        return map;
    }

    /**
     * 根据设置的时间的id去删除相应的数据库数据
     * @param deleteJson 包装id的json字符串
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/DELETE/AppointmentSetting",method = RequestMethod.POST)
    public Map<String ,Object> deleteAppointmentSetting(String deleteJson){
        Map<String,Object> map=new HashMap<>();
        Gson gson=new Gson();
        try {
            Jsondata<Long> jsondata=gson.fromJson(deleteJson,new TypeToken<Jsondata<Long>>(){}.getType());
            if (jsondata.getJsondata()==null){
                map.put("StatusCode",6);
            }else {
                map.put("StatusCode",expertInfoService.delete_expert_AppointmentSetting(jsondata.getJsondata()));
            }
        }catch (JsonSyntaxException e){
            map.put("StatusCode",5);
        }
        return map;
    }

    /**
     * 更新用户个人信息 （除了头像）
     * @param updateJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/UPDATE/updatePersonalInfo",method = RequestMethod.POST)
    public Map<String,Object> updatePersonalInfo(String updateJson){
        Gson gson=new Gson();
        Map<String,Object> map1=new HashMap<>();
        try {
            Jsondata jsondata=gson.fromJson(updateJson,new TypeToken<Jsondata>(){}.getType());
            Map map = jsondata.getMap();
            String column_name= (String) map.get("column_name");
            String data= (String) map.get("data");
            int i;
            try {
                double num= Double.parseDouble(String.valueOf(map.get("user_id")));
                if (column_name==null||data==null){
                    i=6;
                }else {
                    Long user_id= Math.round(num);
                    i=expertInfoService.updatePersonalInfo(user_id,column_name,data);
                }
            }catch (Exception e){
                i=6;
            }
            map1.put("StatusCode",i);
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            map1.put("StatusCode",5);
        }
        return map1;
    }

/*    *//**
     * 获取老师指定预约时间被预约咨询订单集合
     * @param expert_id 老师id
     * @param appointment_id 预约时间id
     * @param type 集合类型
     * @return
     *//*
    @ResponseBody
    @RequestMapping(value = "/GET/expertBookOrders/{type}/{expert_id}/{appointment_id}",method = RequestMethod.GET)
    public Map<String,Object> getExpert_BookOrders(@PathVariable(value = "expert_id") Long expert_id,
                                                   @PathVariable(value = "appointment_id") Long appointment_id,
                                                   @PathVariable(value = "type") String type){

        return expertInfoService.getExpert_BookOrders(expert_id,appointment_id,type);
    }*/

    /**
     * 更新用户头像
     * @param request 文件流
     * @param updateJson 用户JSON数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/UPDATE/userProfile",method = RequestMethod.POST)
    public Map<String,Object> updateUserProfile(HttpServletRequest request,String updateJson){
        int i = uploadExpertImp.updateUserProfile(request, updateJson);
        Map<String,Object> map=new HashMap<>();
        map.put("StatusCode",i);
        return map;
    }

    /**
     * 更新老师封面图片
     * @param request
     * @param updateJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/UPDATE/expertPagePicture",method = RequestMethod.POST)
    public Map<String,Object> UpdateExpertPagePicture(HttpServletRequest request,String updateJson){
        Map<String,Object> map=new HashMap<>();
        map.put("StatusCode",uploadExpertImp.updateExpertPagePicture(request,Long.parseLong(updateJson)));
        return map;
    }

    /**
     * 取消未开始订单
     * @param deleteJson json数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/DELETE/BookOrder",method = RequestMethod.POST)
    public Map<String,Object> deleteBookOrder(String deleteJson){
        Gson gson=new Gson();
        Map<String,Object> map=new HashMap<>();
        try {
            Jsondata<Long> jsondata=gson.fromJson(deleteJson,new TypeToken<Jsondata<Long>>(){}.getType());
            int i = expertInfoService.deleteBookOrder(jsondata.getJsondata());
            map.put("StatusCode",i);
        }catch (JsonSyntaxException e){
            logger.info("取消订单Json数据解析失败.....");
            e.printStackTrace();
            map.put("StatusCode",5);
        }catch (Exception e){
            logger.info("取消订单Json数据实体不存在或者其他错误.....");
            e.printStackTrace();
            map.put("StatusCode",6);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/GET/UserPersonalPage/{user_id}",method = RequestMethod.GET)
    public Map<String,Object> getUserPersonalPage(@PathVariable(value = "user_id") Long user_id){
        Map<String,Object> map=new HashMap<>();
        UserPersonalPage userPersonalPage = expertInfoService.getUserPersonalPage(user_id);
        if (userPersonalPage!=null){
            map.put("StatusCode",1);
            map.put("jsondata",userPersonalPage);
        }else{
            map.put("StatusCode",0);
            map.put("jsondata","");
        }
        return map;
    }

    /**
     * 根据用户id去获取相应的待评价信息列表
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/CommentBookordersEntityList/{user_id}",method = RequestMethod.GET)
    public Map<String,Object> getCommentBookordersEntityList(@PathVariable(value = "user_id") Long user_id){
        Map<String,Object> map=new HashMap<>();
        List<CommentBookorderEntity> list = expertInfoService.getCommentBookordersEntityList(user_id);
        if (list!=null){
            map.put("StatusCode",1);
            map.put("jsondata",list);
        }else{
            map.put("StatusCode",0);
        }
        return map;
    }

    /**
     * 根据用户id去获取相应的已评价信息列表
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/CommentedBookordersEntityList/{user_id}",method = RequestMethod.GET)
    public Map<String,Object> getCommentedBookordersEntityList(@PathVariable(value = "user_id") Long user_id){
        Map<String,Object> map=new HashMap<>();
        List<CommentedBookorderEntity> list = expertInfoService.getCommentedBookordersEntityList(user_id);
        if (list!=null){
            map.put("StatusCode",1);
            map.put("jsondata",list);
        }else{
            map.put("StatusCode",0);
        }
        return map;
    }

    /**
     * 上传用户的咨询评价数据
     * @param userCommentJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/POST/userComment",method = RequestMethod.POST)
    public Map<String,Object> uploadUserComment(String userCommentJson){
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Map<String,Object> map=new HashMap<>();
        try {
            UserComment comment=gson.fromJson(userCommentJson,UserComment.class);
            int i=uploadExpertImp.uploadUserComment(comment);
            map.put("StatusCode",i);
        }catch (JsonSyntaxException e){
            logger.info("咨询评价Json数据解析失败.....");
            e.printStackTrace();
            map.put("StatusCode",5);
        }catch (Exception e){
            logger.info("咨询评价Json数据实体不存在或者其他错误.....");
            e.printStackTrace();
            map.put("StatusCode",6);
        }
        return map;
    }

    /**
     * 根据咨询id插入相应的老师的点评信息数据
     * @param userCommentJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/POST/ExpertComment",method = RequestMethod.POST)
    public Map<String,Object> uploadExpertComment(String userCommentJson){
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        Map<String,Object> map=new HashMap<>();
        try {
            UserComment comment=gson.fromJson(userCommentJson,UserComment.class);
            int i=uploadExpertImp.uploadExpertComment(comment);
            map.put("StatusCode",i);
        }catch (JsonSyntaxException e){
            logger.info("咨询评价Json数据解析失败.....");
            e.printStackTrace();
            map.put("StatusCode",5);
        }catch (Exception e){
            logger.info("咨询评价Json数据实体不存在或者其他错误.....");
            e.printStackTrace();
            map.put("StatusCode",6);
        }
        return map;
    }

    /**
     * 根据用户Id去获取相应的老师个人被评价列表
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/UserCommentInfoList/{user_id}",method = RequestMethod.GET)
    public Map<String,Object> getUserCommentInfoList(@PathVariable(value = "user_id") long user_id){
        Map<String,Object> map = expertInfoService.getUserCommentInfoList(user_id);
        if (map!=null){
            map.put("StatusCode",1);
        }else{
            map.put("StatusCode",0);
        }
        return map;
    }

    /**
     * 根据老师id和类型id去查询咨询过的学生列表(老师端)
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/UsersInfoList/{type_id}/{user_id}",method = RequestMethod.GET)
    public Map<String,Object> getUsersInfoList(@PathVariable(value = "user_id") long user_id,
                                               @PathVariable(value = "type_id") long type_id){
        Map<String,Object> map=new HashMap<>();
        List<UsersInfo> usersInfoList = expertInfoService.getUsersInfoList(user_id,type_id);
        if (usersInfoList!=null){
            map.put("StatusCode",1);
            map.put("jsondata",usersInfoList);
        }else{
            map.put("StatusCode",0);
        }
        return map;
    }
    /**
     * 获取老师端学生的个人页面信息(在列表点击进去之后)
     * 老师端
     * @param user_id 用户id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/UserPageInfo/{user_id}",method = RequestMethod.GET)
    public Map<String,Object> getUserPageInfo(@PathVariable(value = "user_id") long user_id){
        Map<String,Object> map=new HashMap<>();
        UserPersonalPage userPageInfo = expertInfoService.getUserPageInfo(user_id);
        if (userPageInfo!=null){
            map.put("StatusCode",1);
            map.put("jsondata",userPageInfo);
        }else{
            map.put("StatusCode",0);
        }
        return map;
    }

    /**
     * 聊天结束后,更新咨询订单状态为待评价
     * @param bookJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/UPDATE/BookorderStatus",method = RequestMethod.POST)
    public Map<String,Object> updateBookorderStatus(String bookJson){
        Map<String,Object> map=new HashMap<>();
        Gson gson=new Gson();
        try {
            BookOrders bookOrders=gson.fromJson(bookJson,BookOrders.class);
            map.put("StatusCode",expertInfoService.updateBookorderStatus(bookOrders));
        }catch (JsonSyntaxException e){
            logger.info("咨询评价Json数据解析失败.....");
            e.printStackTrace();
            map.put("StatusCode",5);
        }catch (Exception e){
            logger.info("咨询评价Json数据实体不存在或者其他错误.....");
            e.printStackTrace();
            map.put("StatusCode",6);
        }
        return map;
    }

    /**
     * 根据老师用户id去获取相应的已点评信息列表
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/CommentedBookordersExpertList/{user_id}",method = RequestMethod.GET)
    public Map<String,Object> getCommentedBookordersExpertList(@PathVariable(value = "user_id") Long user_id){
        Map<String,Object> map=new HashMap<>();
        List<CommentedBookorderEntity> list = expertInfoService.getCommentedBookordersExpertList(user_id);
        if (list!=null){
            map.put("StatusCode",1);
            map.put("jsondata",list);
        }else{
            map.put("StatusCode",0);
        }
        return map;
    }

    /**
     * 根据老师用户id去获取相应的待点评信息列表
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/CommentBookordersExpertList/{user_id}",method = RequestMethod.GET)
    public Map<String,Object> getCommentBookordersExpertList(@PathVariable(value = "user_id") Long user_id){
        Map<String,Object> map=new HashMap<>();
        List<CommentBookorderEntity> list = expertInfoService.getCommentBookordersExpertList(user_id);
        if (list!=null){
            map.put("StatusCode",1);
            map.put("jsondata",list);
        }else{
            map.put("StatusCode",0);
        }
        return map;
    }

    /**
     * 用户上传文章
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/POST/NewArticle",method = RequestMethod.POST)
    public Map<String,Object> publishArticle(@RequestBody Article article){

        int start=article.getArticle_content().indexOf("<img src=");
        String pic="";
        if (start!=-1){
            int end=article.getArticle_content().indexOf("\"",start+10);
            pic=article.getArticle_content().substring(start+10,end);
        }
        article.setArticle_picture(pic);
        System.out.println(article.getArticle_picture());
        Map<String,Object> map=new HashMap<>();
        map.put("statusCode",uploadExpertImp.SaveArticle(article));
        map.put("statusCode",1);
        return map;
    }

    /**
     * 根据页码请求文章列表
     * @param page_num 页数  移动端
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/ArticleList/{page_num}",method = RequestMethod.GET)
    public Map<String,Object> getArticleList(@PathVariable(value = "page_num") int page_num){
        Map<String,Object> map=new HashMap<>();
        List<ArticleInfo> articleList = expertInfoService.getArticleList(page_num);
        if (articleList!=null){
            map.put("StatusCode",1);
            map.put("jsondata",articleList);
        }else {
            map.put("StatusCode",0);
        }
        return map;
    }

    /**
     * PC端请求全部文章
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/PC/AllArticleList",method = RequestMethod.GET)
    public Map<String,Object> getAllArticleList(){
        Map<String,Object> map=new HashMap<>();
        List<ArticleInfo> articleList = expertInfoService.getAllArticleList();
        if (articleList!=null){
            map.put("StatusCode",1);
            map.put("jsondata",articleList);
        }else {
            map.put("StatusCode",0);
        }
        return map;
    }

    /**
     * 根据文章id去获取文章内容
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/ArticleDetail",method = RequestMethod.POST)
    public Map<String,Object> getArticleDetail(@RequestBody Map<String,Object> map){
        String id=String.valueOf(map.get("article_id"));
        ArticleInfo article_info = expertInfoService.getArticleDetail(Long.valueOf(id));
        Map<String,Object> map1=new HashMap<>();
        if (article_info!=null){
            map1.put("StatusCode",1);
            map1.put("jsondata",article_info);
        }else {
            map1.put("StatusCode",0);
        }
        return map1;
    }

    /**
     * 获取文章的markdown内容进行文章的内容编辑
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/ArticleMarkdown",method = RequestMethod.POST)
    public Map<String,Object> getArticleMarkdown(@RequestBody Map<String,Object> map){
        String id=String.valueOf(map.get("article_id"));
        ArticleInfo article_info = expertInfoService.getArticleMarkdown(Long.valueOf(id));
        Map<String,Object> map1=new HashMap<>();
        if (article_info!=null){
            map1.put("StatusCode",1);
            map1.put("jsondata",article_info);
        }else {
            map1.put("StatusCode",0);
        }
        return map1;
    }

    /**
     * 根据文章id删除文章
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete/Article",method = RequestMethod.POST)
    public Map<String,Object> deleteArticle(@RequestBody Map<String,Object> map){
        String id=String.valueOf(map.get("article_id"));
        Map<String,Object> map1=new HashMap<>();
        map1.put("StatusCode",expertInfoService.DeleteArticle(Long.valueOf(id)));
        return map1;
    }

    /**
     * 根据页码获取相应的老师用户个人信息管理列表
     * @param page_num 页数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/ExpertList/{user_type}/{page_num}",method = RequestMethod.GET)
    public Map<String,Object> getExpertList(@PathVariable(value = "page_num") int page_num,
                                            @PathVariable(value = "user_type") long par_id){
        return expertInfoService.getExpertList(page_num,par_id);
    }

    /**
     * 根据用户id去获取相应的个人数据进行编辑
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/ExpertPersonalData",method = RequestMethod.GET)
    public Map<String,Object> getExpertPersonalData(long user_id){
        ExpertPersonalData expert= expertInfoService.getExpertPersosnalData(user_id);
        Map<String,Object> map=new HashMap<>();
        if (expert!=null){
            map.put("jsondata",expert);
            map.put("StatusCode",1);
        }else {
            map.put("StatusCode",0);
        }
        return map;
    }

    /**
     * 更新老师个人信息数据
     * @param map1
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/UPDATE/ExpertPersonalData",method = RequestMethod.POST)
    public Map<String,Object> UpdateExpertPersonalData(@RequestBody Map<String,Object> map1){
        Gson gson=new Gson();
        Map<String,Object> map=new HashMap<>();
        try {
            Expert expert = gson.fromJson(String.valueOf(map1.get("jsonexpert")), Expert.class);
            map.put("StatusCode",expertInfoService.UpdateExpertPersonalData(expert));
        }catch (JsonSyntaxException e){
            logger.info("更新老师信息JSON数据解析失败......");
            e.printStackTrace();
            map.put("StatusCode",5);
        }catch (Exception e){
            logger.info("更新老师信息JSON数据实体不存在或其他内部错误......");
            e.printStackTrace();
            map.put("StatusCode",6);
        }
        return map;
    }

    /**
     * 获取应用程序封面轮播图集合
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/PagePictureList",method = RequestMethod.GET)
    public Map<String,Object> getPagePictureList(){
        Map<String,Object> map=new HashMap<>();
        List<PagePicture> pagePictureList = expertInfoService.getPagePictureList();
        if (pagePictureList!=null){
            map.put("StatusCode",1);
            map.put("jsondata",pagePictureList);
        }else {
            map.put("StatusCode",0);
        }
        return map;
    }

    /**
     * 上传封面轮播图片
     * @param request
     * @param jsondata
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/POST/PagePicture",method = RequestMethod.POST)
    public Map<String,Object> uploadPagePicture(HttpServletRequest request,String jsondata){
        Gson gson=new Gson();
        Map<String,Object> map=new HashMap<>();
        try {
            PagePicture page=gson.fromJson(jsondata,PagePicture.class);
            map.put("StatusCode",uploadExpertImp.uploadPagePicture(page,request));
        }catch (JsonSyntaxException e){
            logger.info("更新老师信息JSON数据解析失败......");
            e.printStackTrace();
            map.put("StatusCode",5);
        }catch (Exception e){
            logger.info("更新老师信息JSON数据实体不存在或其他内部错误......");
            e.printStackTrace();
            map.put("StatusCode",6);
        }
        return map;
    }

    /**
     * 根据par_id 去获取相应的子类（用户类型）数据集合
     * @param par_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/GET/UserTypeList/{par_id}",method = RequestMethod.GET)
    public Map<String,Object> getUserTypeList(@PathVariable(value = "par_id") long par_id){
        Map<String,Object> map=new HashMap<>();
        if (par_id==1||par_id==2){
            List<UserType> userTypeList = expertInfoService.getUserTypeList(par_id);
            if (userTypeList!=null){
                map.put("StatusCode",1);
                map.put("jsondata",userTypeList);
            }else {
                map.put("StatusCode",0);
            }
        }else {
            map.put("StatusCode",2);
        }
        return map;
    }
}
