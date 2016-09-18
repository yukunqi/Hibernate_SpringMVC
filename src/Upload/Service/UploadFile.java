package Upload.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传专用接口
 */
public interface UploadFile{
    /**
     * 存储图片到服务器，生成相应URL
     * @param request
     * @return  图片URL
     */
    public String Upload(HttpServletRequest request);

}
