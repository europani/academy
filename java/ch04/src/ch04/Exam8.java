package ch04;

public class Exam8 {

	public static void main(String[] args) {
		int sum = 0;
		int lastNum = 10;
		
		for (int i = 1; i <= lastNum; i++) {
			System.out.print("(");
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
				sum += j;
				if (j != i) {
					System.out.print("+");
				}
			}
			System.out.print(")");
			if (i != lastNum) {
				System.out.print(" + ");
			} else {
				System.out.print("=" + sum);
			}
		}
	}

}
