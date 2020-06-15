package ch04;

import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int tmp = num;
		int result = 0;
		
		while (tmp != 0) {
			result *= 10;
			result += tmp%10;
			tmp /= 10;
		}
		
		if (num == result) {
			System.out.println("대칭수");
		} else {
			System.out.println("대칭수X");
		}
		
	}

}
