package ch05;

import java.util.Scanner;

public class Exam6 {

	public static void main(String[] args) {
		char[] data = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] h = new char[32];

		System.out.println("16������ ��ȯȰ 10������ �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int divnum = num;
		int i = 0;

		while (divnum != 0) {
			h[i++] = data[divnum % 16];
			divnum /= 16;
		}

		System.out.print(num + "�� 16������ : ");
		for (int j = i - 1; j >= 0; j--) {
			System.out.print(h[j]);
		}
	}

}
