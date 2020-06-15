package ch04;

import java.util.Scanner;

public class Exam12 {

	public static void main(String[] args) {
		System.out.println("삼각형의 높이를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();		// 3 5
		int bottom = 2 * len - 1; 	// 5 9
		int m = bottom/2;			// 2 4

		for (int i = 0; i < len; i++) {					// 줄
			for (int j = 0; j < bottom; j++) {			// 칸(칸내의 좌표, 0(왼쪽)~bottom(오른쪽) 진행됨)
				if (m-i <= j && j <= m+i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();

		}
	}
}