package ch08;

import java.util.Scanner;

public class ExceptionEx7 {

	public static void main(String[] args) {
		try {
		String id = "hong";
		String pw = "1234";
		Scanner sc = new Scanner(System.in);
		System.out.println("ID를 입력해주세요.");
		String inputId = sc.nextLine();
		System.out.println("PW를 입력해주세요.");
		String inputPw = sc.nextLine();
		
		if (id.equals(inputId) && pw.equals(inputPw)) {
			System.out.println("로그인 성공!!");
		} else if (!inputId.equals(id)) {
			throw new LoginFailException("아이디가 틀렸습니다. 다시 로그인 해주세요.");
		} else {
			throw new LoginFailException("비밀번호가 틀렸습니다. 다시 로그인 해주세요.");
		} 
		} catch (LoginFailException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
}

}

class LoginFailException extends Exception {

	LoginFailException(String msg) {
		super(msg);
		
	}
	
	
}
