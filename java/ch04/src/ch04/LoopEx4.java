package ch04;

import java.util.Scanner;

public class LoopEx4 {

	public static void main(String[] args) {
		int ans = (int)(Math.random() * 100 + 1);
		int input;
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1~100������ �ڿ����� �Է����ּ���.");
			input = sc.nextInt();
			if (ans > input) {
				System.out.println("�� ū �� �Դϴ�.");
			} else if (ans < input) {
				System.out.println("�� ���� �� �Դϴ�.");	
			} else {
				System.out.println("�����Դϴ�.");
			}
			cnt++;
		} while (ans != input);
			
		System.out.println("Ƚ���� " + cnt + "�� �Դϴ�.");
	}
		
}
