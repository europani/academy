package ch08;

public class Exam2 {

	public static void main(String[] args) {
		method();
	}

	private static void method() {
		throw new MyException1("Exam1.method() ���� ���� �߻�");
	}

}

class MyException1 extends RuntimeException {
	MyException1(String msg) {
		super(msg);
	}
}
