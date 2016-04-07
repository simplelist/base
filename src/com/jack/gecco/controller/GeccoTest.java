package com.jack.gecco.controller;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by jackshi on 16/4/7.
 */
@Gecco(matchUrl = "http://www.qiushibaike.com/textnew/page/{index}", pipelines = "consolePipeline")
public class GeccoTest implements HtmlBean {

    private static final long serialVersionUID = -7127412585200687225L;

    @RequestParameter("index")
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Text
    @HtmlField(cssPath = ".content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        GeccoEngine.create()
                .classpath("com.jack.gecco.controller")
                .start("http://www.qiushibaike.com/textnew/")
                .thread(1)
                .interval(2000)
                .loop(true)
                .mobile(false)
                .run();
    }
}
