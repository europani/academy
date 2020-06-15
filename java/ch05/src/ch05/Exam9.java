package ch05;

import java.util.Scanner;

// ���� �߱�

public class Exam9 {

	public static void main(String[] args) {
		int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};		// �����ĺ�
		int[] answer = new int[4];						// ����
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		// ����
		for (int i = 0; i < 1000; i++) {
			int a = (int) (Math.random()*num.length);
			int b = (int) (Math.random()*num.length);
			int tmp = num[a];
			num[a] = num[b];
			num[b] = tmp;
		}
		for (int i = 0; i < answer.length; i++) {
			answer[i] = num[i];
		}
		
		// ��������
		int[] data = new int[4];						
		boolean right = false;							// ����
		
		while (right == false) {
			int strike = 0;
			int ball = 0;
			
			cnt++;
			System.out.print("�ߺ����� �ʴ� ���� 4�ڸ��� �Է����ּ���>");
			String input = sc.next();
			// Scan->input�迭
			for (int i = 0; i < data.length; i++) {
				data[i] = input.charAt(i)-'0';
			}
			// strike, ball
			for (int i = 0; i < answer.length; i++) {
				for (int j = 0; j < data.length; j++) {
					if (data[j] == answer[i]) {
						if (i==j) {
							strike++;
						} else {
							ball++;
						}
					}
				}
			}
			System.out.println("strike : " + strike + ", ball : " + ball);
			
			if (strike == 4) {
				right = !right;
			}
		}
		System.out.println("�����Դϴ�.");
		System.out.println("����Ƚ�� : " + cnt);
		
		
		
		
	}

}
