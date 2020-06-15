package ch04;

import java.util.Scanner;

public class IfEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		int score = sc.nextInt();
		
		if (score >= 60) {
			System.out.println("합격을 축하합니다.");
		} else {
			System.out.println("불합격입니다.");
		}
		
		if (score >=90) {
			System.out.println("A학점 입니다.");
		} else if (score >= 80) {
			System.out.println("B학점 입니다.");
		} else if (score >= 70) {
			System.out.println("C학점 입니다.");
		} else if (score >= 60) {
			System.out.println("D학점 입니다.");
		} else {
			System.out.println("F학점 입니다.");
		}
	}
}
