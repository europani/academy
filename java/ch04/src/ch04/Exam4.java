package ch04;

public class Exam4 {

	public static void main(String[] args) {
		
		for (int i = 2; i <= 9; i++) {
			System.out.print(i + "´Ü :\t");
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + " * " + j + " = " + (i*j) + "\t");
			}
			System.out.println();
		}
		System.out.println();
		for (int j = 1; j <= 9 ; j++) {
			for (int i = 2; i <= 9; i++) {
				System.out.printf("%d * %d = %2d\t", i, j, (i*j));
//				System.out.print(i + " * " + j + " = " + (i*j) + " ");
			}
			System.out.println();
		}
	}

}
