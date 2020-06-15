package ch15;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamEx1 {

	public static void main(String[] args) throws IOException {

//		InputStream in = System.in;
		Reader in = new InputStreamReader(System.in);
		int data = 0;
		System.out.println("문자를 입력하세요");
		while ((data= in.read()) != -1) {
			System.out.println((char)data);
		}
	}

}
