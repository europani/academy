package ch04;

import java.util.Scanner;

public class Exam6 {

	public static void main(String[] args) {
		System.out.println("���ڿ��� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i)-48;
		}
		System.out.println("�ڸ��� �� : " + sum);
	}

}
