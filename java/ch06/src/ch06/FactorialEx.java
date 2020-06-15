package ch06;

import java.util.Scanner;

// 재귀 함수 : 자신이 자신의 메소드 호출

public class FactorialEx {

	public static void main(String[] args) {
		System.out.print("숫자를 입력해주세요>");
		Scanner sc = new Scanner(System.in);
		int i=sc.nextInt();
		
		System.out.println(i + "! = " + factorial(i));
	}
	
	static int factorial(int i) {
		System.out.println("i = " + i);
		return (i == 1)? 1: i*factorial(i-1);
	}
}
