package ch08;

public class ExceptionEx5 {

	public static void main(String[] args) {
		try {
			throw new Exception("예외 강제 발생");
		} catch (Exception e) {
			System.out.println("에러 메시지 : " + e.getMessage());
			e.printStackTrace();
		}
	}

}
