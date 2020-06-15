package ch15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) throws IOException {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("화면에 파일명을 입력하세요");
		String s = sc.next();
		FileInputStream fis = new FileInputStream(s);
		int data = 0;
		byte[] buf = new byte[fis.available()];
		while ((data=fis.read(buf)) != -1) {
			System.out.println(new String(buf, 0, data));
		}
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일 없음");
		}
	}

}
