package Ch03;

import java.util.Scanner;

public class Exam7 {

	public static void main(String[] args) {
		
		System.out.println("������ �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		System.out.println((score>=90)? "A����" : (score>=80)? "B����" : (score>=70)? "C����" : (score>=60)? "D����" : "F����");
	}

}
