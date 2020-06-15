package ch08;

public class Exam1 {

	public static void main(String[] args) {
		method();
	}
	
	private static void method() {
		try {
			throw new MyException("Exam1.method() 예외 강제 발생");
		} catch (Exception e) {
			System.out.println("예외처리 완료");
		}
	}

}

class MyException extends Exception {
	MyException(String msg) {
		super(msg);
	}
}
