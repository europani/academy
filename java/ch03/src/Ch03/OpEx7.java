package Ch03;

import java.util.Scanner;

public class OpEx7 {

	public static void main(String[] args) {
		System.out.println("������ �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		
		Double score = sc.nextDouble();
		String result = (score >=60)? "�հ�": "���հ�";
		System.out.println(score + "���� " + result + "�Դϴ�.");
		System.out.println(score + "���� " +((score%2==0)? "¦��" : "Ȧ��") + "�Դϴ�." );
	
		result = (score%2==1)? "Ȧ��" : (score > 0)? "¦��" : "0";
		System.out.println(score + "���� " + result + "�Դϴ�.");
		
		String r;
		if (score>=60) {
			r = "�հ�";
		} else {
			r = "���հ�";
		}
		System.out.println(r);
	}

}
