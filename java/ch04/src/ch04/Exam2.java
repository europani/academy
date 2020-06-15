package ch04;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		System.out.println("한개의 문자를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);

		if ('a' <= ch && ch <= 'z') {
			System.out.println("소문자");
		} else if ('A' <= ch && ch <= 'Z') {
			System.out.println("대문자");
		} else if ('0' <= ch && ch <= '9') {
			System.out.println("숫자");
		} else {
			System.out.println("그외");
		}
	}

}
