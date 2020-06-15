package ch08;

public class ExceptionEx2 {

	public static void main(String[] args) {
		try {
			System.out.println(args[0]);					// ArrayIndexOutOfBoundsException
			System.out.println(Integer.parseInt(args[0]));	// NumberFormatException
			System.out.println(10/Integer.parseInt(args[0]));// ArithmeticException
			String str = null;
			System.out.println(str.charAt(0));				// NullPointerException
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("command 라인에 파라미터를 입력하세요.");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("command 라인에 파라미터를 입력하세요.");
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누지 마세요.");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Null 입니다.");
		} catch (RuntimeException e) {
			System.out.println("1. 오류발생 : 연락요망");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("2. 오류발생 : 연락요망");
			e.printStackTrace();
		} 
		
	}

}
