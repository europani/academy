package ch06;

import java.util.Scanner;

// ��� �Լ� : �ڽ��� �ڽ��� �޼ҵ� ȣ��

public class FactorialEx {

	public static void main(String[] args) {
		System.out.print("���ڸ� �Է����ּ���>");
		Scanner sc = new Scanner(System.in);
		int i=sc.nextInt();
		
		System.out.println(i + "! = " + factorial(i));
	}
	
	static int factorial(int i) {
		System.out.println("i = " + i);
		return (i == 1)? 1: i*factorial(i-1);
	}
}
