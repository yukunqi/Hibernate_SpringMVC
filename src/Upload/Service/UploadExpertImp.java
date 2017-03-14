package Upload.Service;

import Entity.*;
import Upload.DAO.ExpertDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 老师信息上传类
 * 状态码：2代表图片上传失败 1成功 0失败
 */
@Service
public class UploadExpertImp {

    @Autowired
    private UploadFile uploadFile;
    @Autowired
    private ExpertDAO expertdao;

    private static Logger logger=Logger.getLogger(UploadExpertImp.class.getName());

    /**
     * 上传老师信息，申请成为老师
     * @param json 老师信息JSon数据
     * @param request 文件上传流
     * @return
     */
    public int uploadExpertinfo(String json, HttpServletRequest request){
        Gson gson=new Gson();
        try {
            Expert expert=gson.fromJson(json,Expert.class);
            Map<String, String> upload = uploadFile.Upload_1(request);
            expert.setPage_picture(upload.get("file"));
            expert.getUser().setProfile(upload.get("file_1"));
            return expertdao.saveExpertData(expert);
        }catch (JsonSyntaxException e){
            logger.info("老师信息上传JSON数据解析失败......");
            e.printStackTrace();
            return 5;
        }catch (Exception e){
            logger.info("老师信息上传JSON数据实体不存在或其他内部错误......");
            e.printStackTrace();
            return 6;
        }

    }

    /**
     * 上传咨询预约订单
     * @param json Json数据
     * @return
     */
    public int uploadOrder(String json){
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        try {
            BookOrders bookOrders = gson.fromJson(json, BookOrders.class);
            return expertdao.save_chatOrderData(bookOrders);
        }catch (JsonSyntaxException e) {
            logger.info("上传咨询订单类 Json解析失败.......");
            e.printStackTrace();
            return 5;
        }catch (Exception e){
            logger.info("预约咨询订单上传JSON数据实体不存在或其他内部错误......");
            e.printStackTrace();
            return 6;
        }
    }

    /**
     * 上传老师设置咨询预约时间
     * @param json 设置预约时间Json数据
     * @return
     */
    public int uploadAppointmentSetting(String json){
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        try {
            AppointmentSetting a  = gson.fromJson(json,AppointmentSetting.class);
            return expertdao.save_AppointmentSetting(a);
        }catch (JsonSyntaxException e){
            logger.info("上传老师咨询时间JSON数据解析失败.....");
            e.printStackTrace();
            return 5;
        }catch (Exception e){
            logger.info("老师咨询时间设置上传JSON数据实体不存在或其他内部错误......");
            e.printStackTrace();
            return 6;
        }

    }

    /**
     * 更新用户头像
     * @param request 文件流
     * @param json 用户id Json数据
     * @return
     */
    public int updateUserProfile(HttpServletRequest request,String json){
        Gson gson=new Gson();
        try {
            User user = gson.fromJson(json, User.class);
            double num= (double) user.getId();
            String imageUrl = uploadFile.Upload(request);
            if (imageUrl.equals("")){
                return 2;
            }else {
                Long user_id= Math.round(num);
                return expertdao.UpdateUserProfile(imageUrl,user_id);
            }
        }catch (JsonSyntaxException e){
            logger.info("更新用户头像JSon数据解析失败......");
            e.printStackTrace();
            return 5;
        }catch (NullPointerException e){
            logger.info("更新用户头像JSon数据实体不存在......");
            e.printStackTrace();
            return 6;
        }
    }

    /**
     * 更新老师封面图片
     * @param request
     * @param user_id
     * @return
     */
    public int updateExpertPagePicture(HttpServletRequest request,long user_id){
            String imageUrl = uploadFile.Upload(request);
            if (imageUrl.equals("")){
                return 2;
            }else {
                return expertdao.UpdateExpertPagePicture(imageUrl,user_id);
            }
    }

    /**
     * 根据咨询订单id插入相应的咨询评价数据
     * @param comment
     * @return
     */
    public int uploadUserComment(UserComment comment){
        return expertdao.uploadUserComment(comment);
    }
    /**
     * 根据咨询id插入相应的老师的点评信息数据
     * @param comment
     * @return
     */
    public int uploadExpertComment(UserComment comment){
        return expertdao.uploadExpertComment(comment);
    }

    /**
     * 上传用户文章
     * @param article
     * @return
     */
    public int SaveArticle(Article article){
        article.setBuild_date(new Date());
        User user=new User();
        user.setId((long)14);
        article.setUser(user);
        article.setComment_num(0);
        article.setWatched_num(0);
        article.setGood_num(0);
        return expertdao.SaveUserArticle(article);
    }

    public int uploadPagePicture(PagePicture pagePicture,HttpServletRequest request){
        String upload = uploadFile.Upload(request);
        if ("".equals(upload)){
            return 2;
        }else {
            pagePicture.setUrl(upload);
            return expertdao.uploadPagePicture(pagePicture);
        }
    }
}
