package ch04;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		System.out.println("�Ѱ��� ���ڸ� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);

		if ('a' <= ch && ch <= 'z') {
			System.out.println("�ҹ���");
		} else if ('A' <= ch && ch <= 'Z') {
			System.out.println("�빮��");
		} else if ('0' <= ch && ch <= '9') {
			System.out.println("����");
		} else {
			System.out.println("�׿�");
		}
	}

}
