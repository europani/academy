package ch04;

import java.util.Scanner;

public class asdf {

	public static void main(String[] args) {
		System.out.println("1~100사이의 자연수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int input;
		int ans = (int)(Math.random()*100+1);
		int cnt = 0;
		
		do {
			input = sc.nextInt();
			if (input > ans) {
				System.out.println("더 작은 수 입니다.");
			} else if (input < ans) {
				System.out.println("더 큰 수 입니다.");
			} else {
				System.out.println("정답입니다.");
				System.out.println("도전횟수 : " + cnt);
				break;
			}
			cnt++;
		} while(true);
	}

}
