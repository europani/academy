package Ch03;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		int num = 0;
		
		System.out.println("계산할 초를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		int h = num/3600;
		int m = (num%3600)/60; 
		int s = num%60;
		
		System.out.printf("결과 : %d시 %d분 %d초", h, m, s);
		
	}

}
