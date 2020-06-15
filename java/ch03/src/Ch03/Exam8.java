package Ch03;

import java.util.Scanner;

public class Exam8 {

	public static void main(String[] args) {
		System.out.println("10~99 사이의 자연수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
//		int decinum = (num%10 ==0)? num : (num/10*10)+10; 
		int decinum = (num%10 ==0)? num : ((num/10+1)*10);
		
		System.out.printf("%d - %d = %d", decinum, num, decinum - num);
	}

}
