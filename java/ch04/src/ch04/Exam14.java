package ch04;

import java.util.Scanner;

public class Exam14 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		while (true) {
			System.out.println("\n����Ʈ�� �Է��ϼ���(0~999) [��� : 9999]");
			int point = sc.nextInt();
			if (point == 9999) {
				System.out.println("exit");
				break;
			}
			System.out.println(point + "��");
			switch (point/200) {
			case 0: System.out.println("��ǰ�� �����ϴ�."); break;
			case 4: System.out.print("����Ʈ ");
			case 3: System.out.print("�ڵ��� ");
			case 2: System.out.print("�ڵ��� ");
			case 1: System.out.print("�����"); 
			
			}
		}
	}
	
}
