package ch04;

import java.util.Scanner;

public class Exam3 {

	/*
	 * 4의 배수 : 윤년
	 * 100의 배수 : 평년 
	 * 400의 배수 : 윤년 
	 */

	public static void main(String[] args) {
		System.out.println("년도를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					System.out.println("윤년");	// 4 & 100 & 400
				} else {
					System.out.println("평년");	// 4 & 100
				}
			} else {
				System.out.println("윤년");		// 4
			}

		} else {
			System.out.println("평년");			// 4 X

		}
	}
}
