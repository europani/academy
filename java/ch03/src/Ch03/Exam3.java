package Ch03;

import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) {
		int num = 0;
		
		System.out.println("금액을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		System.out.printf("500원 : %d개%n", num/500);
		System.out.printf("100원 : %d개%n", (num%500)/100);
		System.out.printf("50원 : %d개%n", (num%500%100)/50);
		System.out.printf("10원 : %d개%n", (num%500%100%50)/10);
		System.out.printf("1원 : %d개%n", (num%10));
		
	}

}
