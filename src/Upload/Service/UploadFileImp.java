package Upload.Service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * 文件上传专用类
 *  成功返回1，失败返回0
 */
@Service
public class UploadFileImp implements UploadFile{

    //图片浏览地址的url前缀
    private String RPE_URL="http://119.29.199.192:8080";
    //private String RPE_URL="http://localhost:8080";
    private Logger logger=Logger.getLogger(UploadFileImp.class.getName());


    public String Upload(HttpServletRequest request){
        CommonsMultipartResolver resolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        if (resolver.isMultipart(request)){
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> iterator=multiRequest.getFileNames();
            while (iterator.hasNext()){
                int pre= (int) System.currentTimeMillis();
                 MultipartFile file=multiRequest.getFile(iterator.next());
                if (file!=null){
                   String fileName=file.getOriginalFilename();
                    //判断文件名是否为空，来判断文件是否为空
                    if (fileName.trim()!=""){
                        //生成新的唯一的文件名字
                        String NewfileName=makeFileName(fileName);
                        //指定文件的存放路径
                        String dirpath=makePath(NewfileName);
                        //生成文件，路径是存放路径+文件名
                        File localfile=new File(dirpath,NewfileName);
                        if (localfile.exists()){
                            System.out.println("文件已经存在...file is existed");
                        }
                        try {
                            file.transferTo(localfile);
                            int after= (int) System.currentTimeMillis();
                            System.out.println("上传成功.... upload success");
                            System.out.println("用时:"+(after-pre));

                            return CreateURL(NewfileName,dirpath);
                        } catch (IOException e) {
                            System.out.println("上传失败.... upload fail");
                            logger.info("上传失败.... upload fail");
                            e.printStackTrace();
                            return "";
                        }catch (MaxUploadSizeExceededException e){
                            System.out.println("超过上传限制大小....");
                            e.printStackTrace();
                            return "";
                        }
                    }
                }
            }
        }else {
            System.out.println("不是文件....");
        }
        return "";
    }

    //用UUID生成唯一文件名字
    private String makeFileName(String fileName) {
        //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
        fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
        //得到上传文件的扩展名
        //如果需要对文件类型进行限制，到时候在这里插入一个函数去判断类型
        String fileExtName=fileName.substring(fileName.lastIndexOf(".")+1);
        return UUID.randomUUID().toString()+"."+fileExtName;

    }
    //生成浏览器访问的URL，存储到数据库中
    //传入文件的名称和文件名字
    private String CreateURL(String filename,String realPath){
        String relativePath=CreateRelativePath(realPath);
        System.out.println(RPE_URL+"/"+relativePath+"/"+filename);
        return RPE_URL+"/"+relativePath+"/"+filename;
    }

    private String makePath(String saveFilename) {
        int hashcode=saveFilename.hashCode();
        //配置了Tomcat外部的访问路径，要在配置中设置虚拟路径找到把Tomcat访问
        //路径映射到这个本地磁盘的某个路径下
        // String savePath="F:/JavaProject_For_Intellij IDEA/javaProject_static/image";
        String savePath="/data/web_static/image";
        //为防止一个目录下面出现太多文件，要使用hash算法打散存储
        int dir=hashcode&0xf;
        int dir2=(hashcode&0xf0)>>4;
        String realPath=savePath+"/"+dir+"/"+dir2;
        File file=new File(realPath);
        if (!file.exists()){
            System.out.println("创建文件夹.....  make directory");
            file.mkdirs();
        }
        return realPath;
    }
    //根据绝对路径生成相应的相对路径
    private String CreateRelativePath(String absoultePath){
        //找到物理路径下的image文件夹，然后把这个路径截取后半部分
        return absoultePath.substring(absoultePath.indexOf("image"));
    }
}
