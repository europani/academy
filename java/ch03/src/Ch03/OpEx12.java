package Ch03;

import java.util.Scanner;

public class OpEx12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch = ' ';
		System.out.println("���ڸ� �ϳ� �Է����ּ���.");
		
		String input = sc.nextLine();
		ch = input.charAt(0);
		
		if ('0' <= ch && ch <= '9') {
			System.out.printf("�Է��Ͻ� ���ڴ� �����Դϴ�. \n");
		}
		
		if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
			System.out.printf("�Է��Ͻ� ���ڴ� �������Դϴ�. \n");
		}
		
	}

}
