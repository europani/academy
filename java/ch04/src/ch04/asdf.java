package ch04;

import java.util.Scanner;

public class asdf {

	public static void main(String[] args) {
		System.out.println("1~100������ �ڿ����� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int input;
		int ans = (int)(Math.random()*100+1);
		int cnt = 0;
		
		do {
			input = sc.nextInt();
			if (input > ans) {
				System.out.println("�� ���� �� �Դϴ�.");
			} else if (input < ans) {
				System.out.println("�� ū �� �Դϴ�.");
			} else {
				System.out.println("�����Դϴ�.");
				System.out.println("����Ƚ�� : " + cnt);
				break;
			}
			cnt++;
		} while(true);
	}

}
