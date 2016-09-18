package Upload.Service;

import Entity.Expert;
import Entity.Jsondata;
import Upload.DAO.ExpertDAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

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

    public int uploadExpertinfo(String json, HttpServletRequest request){
        Gson gson=new Gson();
        Jsondata<Expert> jsondata=gson.fromJson(json,new TypeToken<Jsondata<Expert>>(){}.getType());
        Expert expert=jsondata.getJsondata();
      //  Expert expert=gson.fromJson(json,Expert.class);
        String imageUrl = uploadFile.Upload(request);
        if (imageUrl.equals("")){
            return 2;
        }else {
            expert.setPage_picture(imageUrl);
            int i = expertdao.saveExpertData(expert);
            return i;
        }
    }
}
