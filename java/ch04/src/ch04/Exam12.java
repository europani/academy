package ch04;

import java.util.Scanner;

public class Exam12 {

	public static void main(String[] args) {
		System.out.println("�ﰢ���� ���̸� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();		// 3 5
		int bottom = 2 * len - 1; 	// 5 9
		int m = bottom/2;			// 2 4

		for (int i = 0; i < len; i++) {					// ��
			for (int j = 0; j < bottom; j++) {			// ĭ(ĭ���� ��ǥ, 0(����)~bottom(������) �����)
				if (m-i <= j && j <= m+i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();

		}
	}
}