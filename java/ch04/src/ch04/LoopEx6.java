package ch04;

import java.util.Scanner;

public class LoopEx6 {
	public static void main(String[] args) {
	
		int sum = 0;
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���(����:0)");
		
		while (true) {
			int num = sc.nextInt();
			if (num == 0) {
				break;
			}
			cnt++;
			sum += num;	
		}
		
		System.out.println("�հ� : " + sum);
		System.out.println("��� : " + (double)sum/cnt);
	}
}
