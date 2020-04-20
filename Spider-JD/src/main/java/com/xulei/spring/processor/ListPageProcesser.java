package com.xulei.spring.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @Classname ListPageProcesser
 * @Description 影片名称列表获取
 * @Date 2020/4/20 10:22
 * @Created by xulei
 */
public class ListPageProcesser implements PageProcessor {

//    部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);


    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    @Override
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来  获取所有页面元素属性是class='ulink'的
        page.putField("title", page.getHtml().xpath("//a[@class='ulink']").all().toString());

    }

    @Override
    public Site getSite() {
        return site;
    }
}
