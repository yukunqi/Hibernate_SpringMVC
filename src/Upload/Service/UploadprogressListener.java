package Upload.Service;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class UploadprogressListener implements ProgressListener {
    @Override
    public void update(long l, long l1, int i) {
        System.out.println("文件总大小:"+l1+"   "+"当前字节数:"+l+"这是第"+i+"个文件..");
    }
}
