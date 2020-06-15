package ch15;

import java.io.FileInputStream;
import java.io.IOException;

public class Exam3 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("bin/ch15/Exam3.class");
		byte[] buf = new byte[fis.available()];
		int data = fis.read(buf);
		int cnt = 0;
		for (int i = 0; i < buf.length; i++) {
			if (++cnt % 16 == 0) {
				System.out.println();
			}
			System.out.printf("%02X ", buf[i]);
		}
				
				
	}

}
