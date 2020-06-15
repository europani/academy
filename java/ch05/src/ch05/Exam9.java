package ch05;

import java.util.Scanner;

// 숫자 야구

public class Exam9 {

	public static void main(String[] args) {
		int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};		// 숫자후보
		int[] answer = new int[4];						// 정답
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		// 셔플
		for (int i = 0; i < 1000; i++) {
			int a = (int) (Math.random()*num.length);
			int b = (int) (Math.random()*num.length);
			int tmp = num[a];
			num[a] = num[b];
			num[b] = tmp;
		}
		for (int i = 0; i < answer.length; i++) {
			answer[i] = num[i];
		}
		
		// 게임진행
		int[] data = new int[4];						
		boolean right = false;							// 제출
		
		while (right == false) {
			int strike = 0;
			int ball = 0;
			
			cnt++;
			System.out.print("중복되지 않는 숫자 4자리를 입력해주세요>");
			String input = sc.next();
			// Scan->input배열
			for (int i = 0; i < data.length; i++) {
				data[i] = input.charAt(i)-'0';
			}
			// strike, ball
			for (int i = 0; i < answer.length; i++) {
				for (int j = 0; j < data.length; j++) {
					if (data[j] == answer[i]) {
						if (i==j) {
							strike++;
						} else {
							ball++;
						}
					}
				}
			}
			System.out.println("strike : " + strike + ", ball : " + ball);
			
			if (strike == 4) {
				right = !right;
			}
		}
		System.out.println("정답입니다.");
		System.out.println("도전횟수 : " + cnt);
		
		
		
		
	}

}
