package ch15;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exam2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���");
		String text = sc.nextLine();
		FileWriter file = new FileWriter(text, true);
		System.out.println("������ �Է��ϼ��� : (���� : exit)");
		while (true) {
			String data = sc.nextLine();
			if (data.equals("exit")) {
				System.out.println("�����մϴ�.");
				break;
			}
			file.write(data + "\n");
		}
		file.flush();
	}
}
