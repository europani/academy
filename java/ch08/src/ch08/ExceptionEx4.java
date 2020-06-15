package ch08;

public class ExceptionEx4 {

	public static void main(String[] args) {
		first();
	}

	private static void first() {
		second();

	}

	private static void second() throws RuntimeException {
		System.out.println("second 메서드");
		System.out.println(Integer.parseInt("abc")); // NumberFormatException 발생
	}

}
