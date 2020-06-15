package ch04;

import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			System.out.println("점수를 입력하세요(0~999) [취소 : 9999]");
			int point = sc.nextInt();
			
			if (point == 9999) {
				System.out.println("종료합니다.");
				break;
			}
			
			System.out.print(point + "점의 상품 : ");
			switch (point/200) {
			case 0: System.out.println("없습니다.");
				break;
			case 4: System.out.print("아파트 ");
			case 3: System.out.print("자동차 ");
			case 2: System.out.print("핸드폰 ");
			case 1: System.out.print("새우깡");
				
			}
			System.out.println();
		}
	}

}
