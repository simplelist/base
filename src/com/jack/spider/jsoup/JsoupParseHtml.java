package com.jack.spider.jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParseHtml {

	public static List<String> fetchContent(int totalPage) {
		Document document;
		List<String> aList=new ArrayList<String>();
		try {
			for (int i = 1; i <= totalPage; i++) {
				System.out.println("第"+i+"页");
				document = Jsoup.connect("http://www.qiushibaike.com/textnew/page/"+i+"/")
						.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36").get();
				Elements elements = document.select(".content");
				for (Element element : elements) {
					aList.add(element.text());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aList;
	}
}
