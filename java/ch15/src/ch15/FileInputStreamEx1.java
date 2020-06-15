package ch15;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/ch15/InputStreamEx1.java");
		System.out.println("read() �޼��带 �̿��ؼ� �б�");
		int data = 0;
		while ((data = fis.read()) != -1) {		// ���ڸ� int�� ����
			System.out.print((char) data);
		}

		System.out.println("read(byte[] b) �޼��带 �̿��ؼ� �б�");
		fis = new FileInputStream("src/ch15/FileInputStreamEx1.java");
		byte[] buf = new byte[fis.available()];			// ���ڼ���ŭ �迭 ����
		while ((data = fis.read(buf)) != -1) {			// ���ڼ� ����
			System.out.println(new String(buf, 0, data));
			System.out.println("================");
		}
		
		System.out.println("read(byte[] b, int start, int len) �޼��带 �̿��ؼ� �б�");
		fis = new FileInputStream("src/ch15/FileInputStreamEx1.java");
		buf = new byte[fis.available()];			// ���ڼ���ŭ �迭 ����
		while ((data = fis.read(buf, 0, buf.length)) != -1) {	// ���ڼ� ����
			System.out.println(new String(buf, 0, data));
		}
	}

}
