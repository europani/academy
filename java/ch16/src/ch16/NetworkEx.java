package ch16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx {

	public static void main(String[] args) throws Exception {
		String address = "https://finance.naver.com/news/news_read.nhn?mode=mainnews&office_id=008&article_id=0004424909";
		String line = "";
		URL url = new URL(address);
		InputStreamReader isr = new InputStreamReader(url.openStream());
		BufferedReader input = new BufferedReader(isr);
		
		while ((line = input.readLine()) != null) {
			System.out.println(line);
		}
	}

}
