package ch04;

import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			System.out.println("������ �Է��ϼ���(0~999) [��� : 9999]");
			int point = sc.nextInt();
			
			if (point == 9999) {
				System.out.println("�����մϴ�.");
				break;
			}
			
			System.out.print(point + "���� ��ǰ : ");
			switch (point/200) {
			case 0: System.out.println("�����ϴ�.");
				break;
			case 4: System.out.print("����Ʈ ");
			case 3: System.out.print("�ڵ��� ");
			case 2: System.out.print("�ڵ��� ");
			case 1: System.out.print("�����");
				
			}
			System.out.println();
		}
	}

}
