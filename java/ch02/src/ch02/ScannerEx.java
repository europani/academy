package ch02;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���ڸ� ������ �Է����ּ���.");
		
		String input = sc.nextLine();
		int num = Integer.parseInt(input);
		
		System.out.println("input : " + input);
		System.out.printf("num = %d", num);
	}
}
