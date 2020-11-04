package com.geektime.learning;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.io.Serializable;


/**
 * @Title: com.geek.learning -> HttpToolkit
 * @Description: TODO
 * @Author: qiao-shen
 * @Date: 2020/10/28 15:12
 */

public class HttpToolkit implements Serializable {

    private static final long serialVersionUID = -4805542527187072094L;
    private static final OkHttpClient OKCLIENT = new OkHttpClient();
    
    private ResponseBody doGet(String url) throws IOException {
        if (null != url) {
            // 构造请求对象
            Request request = new Request.Builder().get().url(url).build();
            // 执行http请求，获得响应
            Response response = OKCLIENT.newCall(request).execute();
            // 解析响应结果
            if (response.isSuccessful()) {
                System.out.println("Http请求(GET)成功");
                return response.body();
            } else {
                System.out.println("Http请求(GET)失败");
                throw new IOException("Unexpected code " + response);
            }
        } else {
            System.out.println("需要合理的URL");
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8801";
        HttpToolkit htk = new HttpToolkit();
        ResponseBody r = htk.doGet(url);
        assert r != null;
        System.out.println(r.string());
    }

}
