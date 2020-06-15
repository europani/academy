package ch11;

import java.io.*;
import java.util.Properties;

public class PropertiesEx1 {

	public static void main(String[] args) throws IOException {
		Properties pr = new Properties();
		System.out.println(pr);
		
		FileInputStream fis = new FileInputStream("src/ch11/a.properties");
		pr.load(fis);
		System.out.println(pr);
		
		System.out.println("이름 :" + pr.get("name"));
		System.out.println("전화번호 : " + pr.getProperty("tel"));
		pr.put("subject", "컴공");
		System.out.println(pr);
		
		FileOutputStream fos = new FileOutputStream("src/ch11/b.properties");
		pr.store(fos, "#save");
		
	}

}
