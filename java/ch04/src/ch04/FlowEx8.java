package ch04;

import java.util.Scanner;

public class FlowEx8 {

	public static void main(String[] args) {
		int menu = 0;
		int num = 0;
		Scanner sc = new Scanner(System.in);
		
		outer : while (true) {
			System.out.println("1. square");
			System.out.println("2. square root");
			System.out.println("3. log");
			System.out.println("���ϴ� �޴�(1~3)�� �����ϼ���. [���� : 0]");
			String tmp = sc.next();
			menu = Integer.parseInt(tmp);
			
			if (menu == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else if (!(1 <= menu && menu <= 3)) {
				System.out.println("�޴��� �߸� �����Ͽ����ϴ�. �ٽ� �����ϼ���");
				continue;
			}
			
			while(true) {
				System.out.println("����� ���� �Է����ּ���. [�ʱ� �޴� : 99, ���� : 0]");
				tmp = sc.next();
				num = Integer.parseInt(tmp);
				
				if (num == 99) {
					break;
				} else if (num == 0) {
					System.out.println("���α׷��� �����մϴ�.");
					break outer;
				}
				
				switch (menu) {
				case 1:
					System.out.println("result = " + num * num);
					break;
				case 2:
					System.out.println("result = " + Math.sqrt(num));
					break;
				case 3:
					System.out.println("result = " + Math.log(num));
					break;
				default:
					break;
				}
			
			}
		}
			
	}

}
