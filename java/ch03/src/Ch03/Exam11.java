package Ch03;

import java.util.Scanner;

public class Exam11 {

	public static void main(String[] args) {
		
		System.out.println("���ڸ� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println(num + "�� " + ((num%2==0)? "¦��" : "Ȧ��") + "�̴�.");
	}

}
