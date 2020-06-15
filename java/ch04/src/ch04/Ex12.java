package ch04;

import java.util.Scanner;

/*
 > 3
 	*	1	1
   ***	2	3
  *****	3	5
 
 */

public class Ex12 {

	public static void main(String[] args) {
		System.out.println("높이를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();	//3
		int max = 2*height - 1;			//5
		int middle = max/2;				//2
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < max; j++) {
				if (middle-i <= j && j <= middle+i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
