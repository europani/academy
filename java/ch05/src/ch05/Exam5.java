package ch05;

import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		System.out.println("8������ ��ȯȰ 10������ �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		
		int[] octal = new int[32];
		int num = sc.nextInt();
		int divnum = num;
		int i = 0;
		
		while (divnum != 0) {
			octal[i++] = divnum % 8; 
			divnum /= 8;
		}
		
		System.out.print(num + "�� 8������ : ");
		for (int j = i-1; j >=0; j--) {
			System.out.print(octal[j]);
		}
	}

}
