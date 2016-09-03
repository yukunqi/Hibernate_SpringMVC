package Httpclient;


import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *commons-codec-1.6 commons-httpclient-3.1
 */
public class HttpPost_test {
    public static void main(String[] args) {
        HttpClient client=new HttpClient();
        /**
         * 初始化一个postMethod
         */
        PostMethod postMethod=new PostMethod("http://www.yu.com.ngrok.cc/login/userlogin");
        Map<String,Object> map=new HashMap<>();


        /**
         * 初始化一个json的字符串
         */
        map.put("name","123");
        map.put("password","456");
        Gson gson=new Gson();
        String json=gson.toJson(map);
        /**
         * 加入到post方法中去。这里的name是key，后面是你传的任何数据。
         * 后台根据你的key来找到相应的数据
         */
        postMethod.addParameter("name",json);

        try {
            /**
             * 执行post方法
             */
            client.executeMethod(postMethod);
            System.out.println(postMethod.getStatusLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
