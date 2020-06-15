package Ch03;

import java.util.Scanner;

public class Exam11 {

	public static void main(String[] args) {
		
		System.out.println("숫자를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println(num + "은 " + ((num%2==0)? "짝수" : "홀수") + "이다.");
	}

}
