package Ch03;

import java.util.Scanner;

public class Exam9 {

	public static void main(String[] args) {
		System.out.println("반지름을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int radius = sc.nextInt();
		double PI = Math.PI;
		
		System.out.println("면적 : " + (PI * radius*radius));
		System.out.println("둘레 : " + (2* PI * radius));
		
	}

}
