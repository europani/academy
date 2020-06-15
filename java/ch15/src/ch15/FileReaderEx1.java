package ch15;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {

	public static void main(String[] args) throws IOException {
		FileReader fis = new FileReader("src/ch15/fileReaderEx1.java");
		System.out.println("read() �޼��带 �̿��ؼ� �б�");
		int data = 0;
		while ((data = fis.read()) != -1) {
			System.out.print((char) data);
		}

		fis = new FileReader("src/ch15/fileReaderEx1.java");
		System.out.println("read(char[] b) �޼��带 �̿��ؼ� �б�");
		char[] buf = new char[1024];
		while ((data = fis.read(buf)) != -1) {
			System.out.print(new String(buf, 0, data));
		}
		
		fis = new FileReader("src/ch15/fileReaderEx1.java");
		System.out.println("read(char[] b, int start, int len) �޼��带 �̿��ؼ� �б�");
		buf = new char[1024];
		while ((data = fis.read(buf, 0, buf.length)) != -1) {
			System.out.print(new String(buf, 0, data));
		}
	}

}
