package ch15;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exam2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("제목을 입력하세요");
		String text = sc.nextLine();
		FileWriter file = new FileWriter(text, true);
		System.out.println("내용을 입력하세요 : (종료 : exit)");
		while (true) {
			String data = sc.nextLine();
			if (data.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			file.write(data + "\n");
		}
		file.flush();
	}
}
