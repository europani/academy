package ch04;

import java.util.Scanner;

public class Exam3 {

	/*
	 * 4�� ��� : ����
	 * 100�� ��� : ��� 
	 * 400�� ��� : ���� 
	 */

	public static void main(String[] args) {
		System.out.println("�⵵�� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					System.out.println("����");	// 4 & 100 & 400
				} else {
					System.out.println("���");	// 4 & 100
				}
			} else {
				System.out.println("����");		// 4
			}

		} else {
			System.out.println("���");			// 4 X

		}
	}
}
