package Httpclient;


import com.google.gson.Gson;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  用到的包httpclient4.5 httpcore-4.4.1 commons-codec-1.9
 */
public class HttpPost2_test {

    public static void main(String[] args) {
        CloseableHttpClient closeableHttpClient= HttpClients.createDefault();
        /**
         * 初始化一个post请求
         */
        HttpPost post=new HttpPost("http://www.yu.com.ngrok.cc/login/userlogin");

        //设置json数据
        Map<String,Object> map=new HashMap<>();
        map.put("name","adadd");
        map.put("password","sdasdas");
        Gson gson=new Gson();
        String json=gson.toJson(map);
        //初始化一个键值对的list 把name key和数据放进去
        //后台根据name这个key来获取参数
        List<BasicNameValuePair> list=new ArrayList<>();
        list.add(new BasicNameValuePair("name",json));

        try {
            //初始化一个UrlEncodedFormEntity，放置list
            UrlEncodedFormEntity urlentity=new UrlEncodedFormEntity(list);
            post.setEntity(urlentity);
            //执行post请求
            CloseableHttpResponse response= closeableHttpClient.execute(post);
            System.out.println(response.getStatusLine());
            response.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
