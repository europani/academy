package ch04;

public class LoopEx5 {
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i++) {
			System.out.println();
			System.out.println(i + "´Ü");
			for (int j = 1; j <= 9; j++) {
				if(j==5) break;
				if(j==5) continue;
				System.out.printf("%d * %d = %2d\n" , i, j, (i*j));
//				System.out.println(i + " * " + j + " = " + (i*j));
			}
		}
	}
}
