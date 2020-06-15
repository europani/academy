package ch05;

import java.util.Scanner;

// 동전의 종류와 갯수 지정해서 금액을 동전으로 변경하기

public class Exam11 {

	public static void main(String[] args) {
		int[] coinUnit = { 500, 100, 50, 10, 5, 1 };
		int[] cnt = { 5, 5, 5, 5, 5, 5 };

		System.out.print("금액을 입력해주세요 >");
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
				System.out.println(coinUnit[i] + "원 : " + coin);

				if (money > 0) {
					continue;
				}
			}
		} else {
			System.out.println("동전이 부족합니다.");
		}

		System.out.println("\n남은 동전갯수 : ");
		for (int i = 0; i < cnt.length; i++) {
			System.out.print(coinUnit[i] + "원 : " + cnt[i] + ", ");
		}
	}

}
