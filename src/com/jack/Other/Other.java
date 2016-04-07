package com.jack.Other;

import org.apache.commons.collections.map.HashedMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

/**
 * Created by simplelist on 2016/4/7.
 */
public class Other {

    @Test
    public void test(){
        String url="http://jandan.net/";
        String selector=".indexs";
        fetchPage(url,selector);
    }

    public void fetchPage(String URL,String selector){
        Document document;
        Map<Integer,String> map=new HashedMap();
        try {
            document= Jsoup.connect(URL).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36").get();
            Elements elements=document.select(selector);

            for (Element element:elements){
                System.out.println(element.select(".comment-link").text()+">>"+element.select("h2 a").text());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
