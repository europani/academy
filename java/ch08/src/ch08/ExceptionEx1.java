package ch08;

public class ExceptionEx1 {

	public static void main(String[] args) {
		try {
			System.out.println(1/0);
			System.out.print(2);
			System.out.print(3);
			System.out.print(4);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("0���� ������ ������");
		}
		System.out.println(5);
	}

}
