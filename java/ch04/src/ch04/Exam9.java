package ch04;

import java.util.Scanner;

public class Exam9 {

	public static void main(String[] args) {
		System.out.println("삼각형의 높이를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		
		for (int i = 1; i <= len ; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();		
		}
	}

}
