package Ch03;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		int num = 0;
		String result;
		
		System.out.println("숫자를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		if (num > 0) {
			System.out.println("양수 입니다.");
		}
		else if (num < 0) {
			System.out.println("음수 입니다.");
		}
		else {
			System.out.println("0 입니다.");
		}
		
		result = (num > 0)? "양수" : (num < 0)? "음수" : "0"; 
		System.out.println(result + " 입니다.");
		
	}

}
