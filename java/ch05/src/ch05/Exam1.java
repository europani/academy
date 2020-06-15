package ch05;

import java.util.Scanner;

/*
	5개 점수를 입력받아 합계, 평균, 최댓값, 최솟값 구하기.
	점수는 배열에 저장
*/
public class Exam1 {

	public static void main(String[] args) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		System.out.println("5명의 점수를 입력하세요.");
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

		System.out.println("합계 : " + sum);
		System.out.println("평균 : " +  (double)sum / score.length);
		System.out.println("최대점수 : " + max);
		System.out.println("최소점수 : " + min);
	}

}
