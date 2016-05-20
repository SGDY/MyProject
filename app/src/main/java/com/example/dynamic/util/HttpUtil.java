package com.example.dynamic.util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/24
 */
public class HttpUtil {

    public static String getResult(String serverURL) {
        HttpGet httpRequest = new HttpGet(serverURL);// 建立http get联机
        String result = null;
        try {
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);// 发出http请求

            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(httpResponse.getEntity());// 获取相应的字符串
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String postResult(String serverURL,StringEntity stringEntity) {
        HttpPost httpRequest = new HttpPost(serverURL);   //建立HTTP POST联机
        String result = null;
        try {
            httpRequest.setEntity(stringEntity);   //发出http请求
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);   //取得http响应
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(httpResponse.getEntity());   //获取字符串
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
