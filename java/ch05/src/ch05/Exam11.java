package ch05;

import java.util.Scanner;

// ������ ������ ���� �����ؼ� �ݾ��� �������� �����ϱ�

public class Exam11 {

	public static void main(String[] args) {
		int[] coinUnit = { 500, 100, 50, 10, 5, 1 };
		int[] cnt = { 5, 5, 5, 5, 5, 5 };

		System.out.print("�ݾ��� �Է����ּ��� >");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		if (money <= (500 + 100 + 50 + 10 + 5 + 1) * 5) {
			for (int i = 0; i < coinUnit.length; i++) {
				int coin = money / coinUnit[i];
				if (coin > cnt[i]) {
					money -= (coinUnit[i] * cnt[i]);
					coin = cnt[i];
					cnt[i] = 0;
				} else {
					money %= coinUnit[i];
					cnt[i] -= coin;
				}
				System.out.println(coinUnit[i] + "�� : " + coin);

				if (money > 0) {
					continue;
				}
			}
		} else {
			System.out.println("������ �����մϴ�.");
		}

		System.out.println("\n���� �������� : ");
		for (int i = 0; i < cnt.length; i++) {
			System.out.print(coinUnit[i] + "�� : " + cnt[i] + ", ");
		}
	}

}
