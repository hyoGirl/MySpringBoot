package com.xulei.spring.processor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * @Classname MovieDetailParse
 * @Description TODO
 * @Date 2020/4/20 17:31
 * @Created by xulei
 */
public class MovieDetailParse implements  HtmlParse{


    @Override
    public List<?> getData(String html) {
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("a[thunderrestitle]");

        for(Element element:elements){
            String text = element.text();

            System.out.println(text);
        }


        return null;
    }
}
