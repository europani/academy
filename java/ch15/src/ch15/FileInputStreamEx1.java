package ch15;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/ch15/InputStreamEx1.java");
		System.out.println("read() 메서드를 이용해서 읽기");
		int data = 0;
		while ((data = fis.read()) != -1) {		// 문자를 int로 리턴
			System.out.print((char) data);
		}

		System.out.println("read(byte[] b) 메서드를 이용해서 읽기");
		fis = new FileInputStream("src/ch15/FileInputStreamEx1.java");
		byte[] buf = new byte[fis.available()];			// 문자수만큼 배열 생성
		while ((data = fis.read(buf)) != -1) {			// 문자수 리턴
			System.out.println(new String(buf, 0, data));
			System.out.println("================");
		}
		
		System.out.println("read(byte[] b, int start, int len) 메서드를 이용해서 읽기");
		fis = new FileInputStream("src/ch15/FileInputStreamEx1.java");
		buf = new byte[fis.available()];			// 문자수만큼 배열 생성
		while ((data = fis.read(buf, 0, buf.length)) != -1) {	// 문자수 리턴
			System.out.println(new String(buf, 0, data));
		}
	}

}
