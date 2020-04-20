package com.xulei.spring.processor;

import com.xulei.spring.model.MovieListModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MovieParse
 * @Description 电影页面解析
 * @Date 2020/4/20 13:40
 * @Created by xulei
 */
public class MovieParse implements  HtmlParse{

//    https://www.open-open.com/jsoup/dom-navigation.htm

    @Override
    public  List<MovieListModel> getData(String html){
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("a[class=ulink]");
        List<MovieListModel> movieList=new ArrayList<>();
        MovieListModel movieListModel=null;
        for (Element element : elements){
            String href = element.attr("href");
            String text = element.text();

            movieListModel= new MovieListModel();
            movieListModel.setHref(href);
            movieListModel.setText(text);
            movieList.add(movieListModel);
        }
        return movieList;
    }
}
