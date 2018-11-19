package com.ktds.traffic.scrapy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawl {
	public static void main(String[] args) throws Exception {
		String URL = "http://openapi.seoul.go.kr:8088/5756504e7567616c383349484c7641/xml/AccInfo/1/5/";
		Document doc = Jsoup.connect(URL).get();
			Elements elem = doc.select("acc_info");
			Elements elem2 = doc.select("grs80tm_x");
			Elements elem3 = doc.select("grs80tm_y");
			for(int i = 0; i< elem.size(); i++) {
				System.out.println(elem.eq(i).text() 
									+"$"+ elem2.eq(i).text()
									+"$"+ elem3.eq(i).text());
			}
	}
}
