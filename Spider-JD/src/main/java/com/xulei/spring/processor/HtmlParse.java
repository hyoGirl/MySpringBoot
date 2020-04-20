package com.xulei.spring.processor;

import java.util.List;

/**
 * @Classname HtmlParse
 * @Description 解析Html
 * @Date 2020/4/20 13:57
 * @Created by xulei
 */
public interface HtmlParse {

    List<?> getData(String html);
}
