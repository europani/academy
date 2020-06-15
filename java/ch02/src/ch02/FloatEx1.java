package ch02;

public class FloatEx1 {

	public static void main(String[] args) {
		float f = 9.12345678901234567890f;
		float f2 = 1.2345678901234567890f;
		double d = 9.12345679801234567890d;
		
		System.out.printf("      12345678901234567890123%n");
		System.out.printf("1.f  : %f%n", f);
		System.out.printf("2.f  : %22.20f%n", f);
		System.out.printf("3.f2 : %22.20f%n", f2);
		System.out.printf("4.d  : %22.20f%n", d);
		
	}
}
