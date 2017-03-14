package Upload.Service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 文件上传专用接口
 */
public interface UploadFile{
    /**
     * 存储图片到服务器，生成相应URL
     * @param request
     * @return  图片URL
     */
    /**
     * 需要传递请求参数的精确上传 可以多个或者单个
     * @param request
     * @return
     */
    Map<String,String> Upload_1(HttpServletRequest request);

    /**
     * 单个文件图片上传 且不用传递相应的请求参数
     * @param request
     * @return
     */
    String Upload(HttpServletRequest request);

    String UploadMultipartFile(MultipartFile file);
}
