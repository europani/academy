package ch04;

import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��ϼ���.");
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
			System.out.println("��Ī��");
		} else {
			System.out.println("��Ī��X");
		}
		
	}

}
