package Httpclient;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

/**
 *
 */
public class HttpPost3_test {
    public static void main(String[] args) {
        HttpClient client=new HttpClient();
        PostMethod postMethod=new PostMethod("https://ia.szu.edu.cn/cas/login?service=https%3a%2f%2fauth.szu.edu.cn%3a443%2fcas.aspx%2flogin%3fservice%3dhttp%3a%2f%2fcsse.szu.edu.cn%2fCAS%2fphp.php");
        postMethod.addParameter("username","120720");
        postMethod.addParameter("password","11223619");
        try {
            client.executeMethod(postMethod);
            System.out.println(postMethod.getStatusLine());
            System.out.println(postMethod.getResponseBodyAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
