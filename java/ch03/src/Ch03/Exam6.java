package Ch03;

import java.util.Scanner;

public class Exam6 {

	public static void main(String[] args) {

		System.out.println("사과 갯수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println("필요한 상자의 갯수 : " + ((num%10 > 0)? num/10+1 :num/10));
		
	}

}
