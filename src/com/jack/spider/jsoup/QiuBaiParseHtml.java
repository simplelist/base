package com.jack.spider.jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jack.entity.QiuBai;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class QiuBaiParseHtml {

	public static List<QiuBai> fetchContent(int totalPage) {
		Document document;
		List<QiuBai> aList=new ArrayList<QiuBai>();
		try {
			for (int i = 1; i <= totalPage; i++) {
				System.out.println("第"+i+"页");
				document = Jsoup.connect("http://www.qiushibaike.com/textnew/page/"+i+"/")
						.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36").get();
				Elements elements = document.select(".article.block.untagged.mb15");

				for (Element element : elements) {
					QiuBai q=new QiuBai();
					q.setContent(element.select(".content").text());
					q.setAuthor(element.select(".author.clearfix a h2").text());
					q.setComments(Integer.valueOf(element.select(".stats-vote .number").text()));
					aList.add(q);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aList;
	}
}
