package ch08;

public class ExceptionEx6 {

	public static void main(String[] args) {
		try {
			badmethod();
		} catch (Exception e) {
			System.out.println("메인메서드에서 예외 처리");
			e.printStackTrace();
		}
	}

	private static void badmethod() throws Exception {
		try {
			throw new Exception("예외 강제 발생");
		} catch (Exception e) {
			System.out.println("badmethod에서 예외 처리");
			e.printStackTrace();
			throw e;
		}
	}
}
