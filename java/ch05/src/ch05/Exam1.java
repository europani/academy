package ch05;

import java.util.Scanner;

/*
	5�� ������ �Է¹޾� �հ�, ���, �ִ�, �ּڰ� ���ϱ�.
	������ �迭�� ����
*/
public class Exam1 {

	public static void main(String[] args) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		System.out.println("5���� ������ �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];

		for (int i = 0; i < score.length; i++) {
			score[i] = sc.nextInt();
		}

		for (int i = 0; i < score.length; i++) {
			sum += score[i];
			if (score[i] > max) {
				max = score[i];
			}
			if (score[i] < min) {
				min = score[i];
			}
		}

		System.out.println("�հ� : " + sum);
		System.out.println("��� : " +  (double)sum / score.length);
		System.out.println("�ִ����� : " + max);
		System.out.println("�ּ����� : " + min);
	}

}
