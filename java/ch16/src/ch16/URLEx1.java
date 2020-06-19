package ch16;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class URLEx1 {

	public static void main(String[] args) throws IOException {
		URL url1 = null, url2 = null;
		url1 = new URL("http://www.google.com");
		url2 = new URL("file", "", -1, "src/ch16/aaa.txt");
		System.out.println("protocol : " + url1.getProtocol() + "," + url2.getProtocol());
		System.out.println("host : " + url1.getHost() + "," + url2.getHost());
		System.out.println("port : " + url1.getPort() + "," + url2.getPort());
		System.out.println("file : " + url1.getFile() + "," + url2.getFile());
		
		int data = 0;
		Reader is = new InputStreamReader(url1.openStream());
		while ((data = is.read()) != -1) {
			System.out.print((char)data);
		}
		System.out.println();
		System.out.println("==========================");
		data = 0;
		is = new InputStreamReader(url2.openStream());
		while ((data = is.read()) != -1) {
			System.out.print((char)data);
		}
		System.out.println();
	}

}
