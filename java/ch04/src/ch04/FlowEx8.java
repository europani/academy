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
			System.out.println("원하는 메뉴(1~3)를 선택하세요. [종료 : 0]");
			String tmp = sc.next();
			menu = Integer.parseInt(tmp);
			
			if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (!(1 <= menu && menu <= 3)) {
				System.out.println("메뉴를 잘못 선택하였습니다. 다시 선택하세요");
				continue;
			}
			
			while(true) {
				System.out.println("계산할 값을 입력해주세요. [초기 메뉴 : 99, 종료 : 0]");
				tmp = sc.next();
				num = Integer.parseInt(tmp);
				
				if (num == 99) {
					break;
				} else if (num == 0) {
					System.out.println("프로그램을 종료합니다.");
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
