package Ch03;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		int num = 0;
		
		System.out.println("세자리 정수를 입력하세요");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		System.out.println((num/100)*100);
		System.out.println(num-(num%100));
	}

}
