package Ch03;

import java.util.Scanner;

public class Exam9 {

	public static void main(String[] args) {
		System.out.println("�������� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int radius = sc.nextInt();
		double PI = Math.PI;
		
		System.out.println("���� : " + (PI * radius*radius));
		System.out.println("�ѷ� : " + (2* PI * radius));
		
	}

}
