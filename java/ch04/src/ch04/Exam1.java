package ch04;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if (num > 0) {
			System.out.println("���");
		} else if (num < 0) {
			System.out.println("����");
		} else {
			System.out.println("0�Դϴ�.");
		}
		
	}

}
