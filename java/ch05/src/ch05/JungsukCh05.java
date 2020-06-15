package ch05;

import java.util.Scanner;

public class JungsukCh05 {

	public static void main(String[] args) {
//	[5-4]
		int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };
		int total = 0;
		double average = 0;
		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
				cnt++;
			}
		}
		average = (double) total / cnt;
		System.out.println("total=" + total);
		System.out.println("average=" + average);
		System.out.println();

//	[5-6]
		int[] coinUnit = { 500, 100, 50, 10 };
		int money = 2680;
		int tmp = money;

		System.out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			int a = tmp / coinUnit[i];
			tmp %= coinUnit[i];
			System.out.print(coinUnit[i] + "원 : " + a + "\n");
		}
		System.out.println();

//	[5-9]
		char[][] star = { { '*', '*', ' ', ' ', ' ' }, { '*', '*', ' ', ' ', ' ' }, { '*', '*', '*', '*', '*' },
				{ '*', '*', '*', '*', '*' } };
		char[][] result = new char[star[0].length][star.length];
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				int x = j;
				int y = star.length - 1 - i;
				result[x][y] = star[i][j];
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		System.out.println();

//	[5-10]
		char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[',
				']', '{', '}', ';', ':', ',', '.', '/' };
		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

		String src = "abc123";
		String result2 = "";

		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			if ('a' <= ch && ch <= 'z') {
				result2 += abcCode[ch - 'a'];
			}
			if ('0' <= ch && ch <= '9') {
				result2 += numCode[ch - '0'];
			}
		}

		System.out.println("src:" + src);
		System.out.println("result2:" + result2);
		System.out.println();

//	[5-11]
		int[][] score = { { 100, 100, 100 }, { 20, 20, 20 }, { 30, 30, 30 }, { 40, 40, 40 }, { 50, 50, 50 } };
		int[][] result3 = new int[score.length + 1][score[0].length + 1];
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				result3[i][j] = score[i][j];
				result3[i][score[i].length] += score[i][j]; // 가로합
				result3[score.length][j] += score[i][j]; // 세로합
				result3[score.length][score[i].length] += score[i][j]; // 전체합
			}
		}
		for (int i = 0; i < result3.length; i++) {
			for (int j = 0; j < result3[i].length; j++) {
				System.out.printf("%4d", result3[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
//	[5-13]
		String[] words = { "television", "computer", "mouse", "phone" };
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray();
	
			for (int j = 0; j < 1000; j++) {
				int a = (int) (Math.random() * question.length);
				int b = (int) (Math.random() * question.length);

				char tmp2 = question[a];
				question[a] = question[b];
				question[b] = (char) tmp2;
			}

			System.out.printf("Q%d. %s 의 정답을 입력하세요>", i + 1, new String(question));
			String answer = scanner.nextLine();

			if (words[i].equals(answer.trim())) {
				System.out.printf("맞았습니다.%n%n");
			} else
				System.out.printf("틀렸습니다.%n%n");
		}

	}

}
