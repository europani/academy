package Ch03;

import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) {
		int num = 0;
		
		System.out.println("�ݾ��� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		System.out.printf("500�� : %d��%n", num/500);
		System.out.printf("100�� : %d��%n", (num%500)/100);
		System.out.printf("50�� : %d��%n", (num%500%100)/50);
		System.out.printf("10�� : %d��%n", (num%500%100%50)/10);
		System.out.printf("1�� : %d��%n", (num%10));
		
	}

}
