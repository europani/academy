package Ch03;

import java.util.Scanner;

public class Exam6 {

	public static void main(String[] args) {

		System.out.println("��� ������ �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println("�ʿ��� ������ ���� : " + ((num%10 > 0)? num/10+1 :num/10));
		
	}

}
