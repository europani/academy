package Ch03;

import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		int num = 0;
		String str;
		
		System.out.println("���ڸ� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		char ch = str.charAt(0);
		System.out.println(('a' <= ch && ch <= 'z')? (char)(ch-32) : "�ҹ��ھƴ�");
	
	}

}
