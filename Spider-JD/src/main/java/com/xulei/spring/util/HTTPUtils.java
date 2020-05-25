package com.xulei.spring.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HTTPUtils {


    public static HttpResponse getRawHtml(HttpClient client, String url) throws IOException {

        HttpGet httpGet = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        httpGet.setConfig(requestConfig);
        HttpResponse response = client.execute(httpGet);

        return response;
    }
}