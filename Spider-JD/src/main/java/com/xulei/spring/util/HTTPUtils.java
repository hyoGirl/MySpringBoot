package com.xulei.spring.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HTTPUtils {


    public static HttpResponse getRawHtml(HttpClient client, String url) throws IOException {

        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);

        return response;
    }
}