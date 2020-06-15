package ch04;

import java.util.Scanner;

public class LoopEx4 {

	public static void main(String[] args) {
		int ans = (int)(Math.random() * 100 + 1);
		int input;
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1~100사이의 자연수를 입력해주세요.");
			input = sc.nextInt();
			if (ans > input) {
				System.out.println("더 큰 수 입니다.");
			} else if (ans < input) {
				System.out.println("더 작은 수 입니다.");	
			} else {
				System.out.println("정답입니다.");
			}
			cnt++;
		} while (ans != input);
			
		System.out.println("횟수는 " + cnt + "번 입니다.");
	}
		
}
