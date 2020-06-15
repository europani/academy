package ch15;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class FileOutputStreamEx2 {

	public static void main(String[] args) {
		firstMethod();
	}

	private static void firstMethod() {
		secondMethod();
	}

	private static void secondMethod() {
		try {
			throw new Exception("파일에 예외 메시지 저장");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				FileOutputStream fos = new FileOutputStream("src/ch15/error.log", true);
				fos.write(e.getMessage().getBytes());
				fos.write(("===================\n\n" + (new Date()) + "\n\n").getBytes());
				e.printStackTrace(new PrintStream(fos));
				fos.write("===================\n\n".getBytes());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
