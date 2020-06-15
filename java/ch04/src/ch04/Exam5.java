package ch04;

import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		System.out.println("자연수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int fornum = num;
		int sum = 0;
		
		while (num != 0) {
			sum += num%10;	// 나머지
			num = num/10;	// 몫	
		}
		System.out.println("자리수 합 : " + sum);

		sum = 0;
		for (; fornum != 0; fornum/=10) {
			sum += fornum%10;	
		}
		System.out.println("자리수 합 : " + sum);

	}

}
