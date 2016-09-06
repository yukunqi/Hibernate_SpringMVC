package Upload.Service;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  带进度条的CommonsMultipartResolver
 */
public class Myresolver extends CommonsMultipartResolver {

    @Autowired
    UploadprogressListener listener;
    @Override
    @SuppressWarnings("unchecked")
    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        String encoding=determineEncoding(request);
        FileUpload fileUpload=prepareFileUpload(encoding);
        fileUpload.setProgressListener(listener);
        try {
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
            return parseFileItems(fileItems,encoding);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return null;
    }

}
