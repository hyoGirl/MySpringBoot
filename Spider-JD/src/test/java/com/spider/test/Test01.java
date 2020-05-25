package com.spider.test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author XULEI
 * @ClassName Test01
 * @description TODO
 * @Date 2020/4/29 22:36
 * @Version 1.0
 */
public class Test01 {

    public static void main(String[] args) throws Exception{


            /*
             * 连接网页
             */
            URL url = new URL("http://www.haimaoba.com/catalog/3991/67284.html");
            URLConnection urlConnection = url.openConnection();

            urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            urlConnection.connect();
            //读取网页的html
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line = null;
            //正则表达式，解释如下在最少的""里面匹配到子表达式 ？相当于懒惰（匹配尽可能少）
            Pattern pattern = Pattern.compile("src=\"(.+?)\"");
            List<String> list = new ArrayList<String>();
            while((line = br.readLine()) != null) {
                Matcher m = pattern.matcher(line);
                while(m.find()) {
                    //查到之后添加list里面
                    list.add(m.group());
                }
            }
            br.close();

            //筛选src，找到jpg和png和gif结尾的（设置新格式也就是截取字符串）放到图片集合里面
            List<String> imglist = new ArrayList<String>();
            for(String xString : list) {
                if(xString.endsWith(".jpg\"") || xString.endsWith(".png\"") || xString.endsWith(".gif\"")) {
                    //截取字符串的一部分也就是图片的地址
                    String partString = xString.substring(5,xString.length() - 1);
                    imglist.add(partString);
                }
            }

            //开始下载
            Date beginDate = new Date();
            for(String xString : imglist) {
                Date partbeginDate = new Date();
                URL partUrl;
                if(!xString.startsWith("http:")) {
                    partUrl = new URL("http:"+xString);
                    if(!("http:"+xString).startsWith("http://")) {
                        continue;
                    }
                }else {
                    partUrl = new URL(xString);
                }
                System.out.println(partUrl);
                String nameString = xString.substring(xString.lastIndexOf("/") + 1,xString.length());
                File file = new File("E:\\图片下载\\"+nameString);
                InputStream is = partUrl.openStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

                System.out.println("开始下载" + xString);
                int len = 0;
                while((len = bis.read()) != -1){
                    bos.write(len);
                }
                System.out.println("下载完成");
                Date partendDate = new Date();
                double ti = (partendDate.getTime() - partbeginDate.getTime()) / 1000;
                System.out.println("用时" + String.format("%.8f", ti) + "s");
                bis.close();
                bos.close();
            }
            Date endDate = new Date();
            double ti = (endDate.getTime() - beginDate.getTime() ) / 1000;
            System.out.println("全部下载完成");
            System.out.println("总用时" + String.format("%.8f", ti) + "s");

        }


}
