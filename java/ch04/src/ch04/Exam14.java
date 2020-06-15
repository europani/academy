package ch04;

import java.util.Scanner;

public class Exam14 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		while (true) {
			System.out.println("\n포인트를 입력하세요(0~999) [취소 : 9999]");
			int point = sc.nextInt();
			if (point == 9999) {
				System.out.println("exit");
				break;
			}
			System.out.println(point + "점");
			switch (point/200) {
			case 0: System.out.println("상품이 없습니다."); break;
			case 4: System.out.print("아파트 ");
			case 3: System.out.print("자동차 ");
			case 2: System.out.print("핸드폰 ");
			case 1: System.out.print("새우깡"); 
			
			}
		}
	}
	
}
