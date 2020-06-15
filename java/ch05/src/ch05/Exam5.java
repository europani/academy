package ch05;

import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		System.out.println("8진수로 변환활 10진수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		
		int[] octal = new int[32];
		int num = sc.nextInt();
		int divnum = num;
		int i = 0;
		
		while (divnum != 0) {
			octal[i++] = divnum % 8; 
			divnum /= 8;
		}
		
		System.out.print(num + "의 8진수는 : ");
		for (int j = i-1; j >=0; j--) {
			System.out.print(octal[j]);
		}
	}

}
