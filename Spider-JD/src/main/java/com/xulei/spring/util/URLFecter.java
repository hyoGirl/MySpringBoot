package com.xulei.spring.util;


import com.xulei.spring.model.JdModel;
import com.xulei.spring.processor.JdParse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class URLFecter {


    public static List<JdModel> URLParser(HttpClient client, String url) throws IOException {

        List<JdModel> jdModels = new ArrayList<JdModel>();
        HttpResponse response = HTTPUtils.getRawHtml(client, url);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String entity = EntityUtils.toString(response.getEntity(), "UTF-8");
            jdModels = new JdParse().getData(entity);
            EntityUtils.consume(response.getEntity());
        } else {
            EntityUtils.consume(response.getEntity());
        }
        return jdModels;
    }


    public  String parseURL(HttpClient client, String url) throws IOException {

        HttpResponse response = HTTPUtils.getRawHtml(client, url);
        int statusCode = response.getStatusLine().getStatusCode();
        String entity =null;
        if (statusCode == 200) {

            // 在console上打印  document.charset
            entity = EntityUtils.toString(response.getEntity(), "GBK");
            EntityUtils.consume(response.getEntity());
        } else {
            EntityUtils.consume(response.getEntity());
        }
        return entity;
    }

}
