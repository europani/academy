package ch04;

/* 피보나치수열 출력.
 * 1 1 2 3 5 8 13 21 34 ....
 * do-while문
 */

public class Exam15 {

	public static void main(String[] args) {
		int i = 1;
		int j = 1;
		int tmp = 0;

		// while
		System.out.print(i);
		while (j <= 1000) {
			System.out.print(", " + j);
			tmp = j;
			j = i + j;
			i = tmp;

		}

		System.out.println();

		// do-while
		i = 1;
		j = 1;
		tmp = 0;

		System.out.print(i);
		do {
			System.out.print(", " + j);
			tmp = j;
			j = i + j;
			i = tmp;
		} while (j <= 1000);
		
		System.out.println();
		
		// for
		i = 1;
		j = 1;
		tmp = 0;

		System.out.print(i);
		for (;j <= 1000; i = tmp) {
			System.out.print(", " + j);
			tmp = j;
			j = i + j;
				
		}
	}

}
