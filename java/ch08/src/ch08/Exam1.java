package ch08;

public class Exam1 {

	public static void main(String[] args) {
		method();
	}
	
	private static void method() {
		try {
			throw new MyException("Exam1.method() ���� ���� �߻�");
		} catch (Exception e) {
			System.out.println("����ó�� �Ϸ�");
		}
	}

}

class MyException extends Exception {
	MyException(String msg) {
		super(msg);
	}
}
