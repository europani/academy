package Ch03;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		int num = 0;
		String result;
		
		System.out.println("���ڸ� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		if (num > 0) {
			System.out.println("��� �Դϴ�.");
		}
		else if (num < 0) {
			System.out.println("���� �Դϴ�.");
		}
		else {
			System.out.println("0 �Դϴ�.");
		}
		
		result = (num > 0)? "���" : (num < 0)? "����" : "0"; 
		System.out.println(result + " �Դϴ�.");
		
	}

}
