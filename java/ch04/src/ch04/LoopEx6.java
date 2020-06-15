package ch04;

import java.util.Scanner;

public class LoopEx6 {
	public static void main(String[] args) {
	
		int sum = 0;
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요(종료:0)");
		
		while (true) {
			int num = sc.nextInt();
			if (num == 0) {
				break;
			}
			cnt++;
			sum += num;	
		}
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (double)sum/cnt);
	}
}
