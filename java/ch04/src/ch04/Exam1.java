package ch04;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if (num > 0) {
			System.out.println("양수");
		} else if (num < 0) {
			System.out.println("음수");
		} else {
			System.out.println("0입니다.");
		}
		
	}

}
