package ch08;

import java.util.Scanner;

public class ExceptionEx7 {

	public static void main(String[] args) {
		try {
		String id = "hong";
		String pw = "1234";
		Scanner sc = new Scanner(System.in);
		System.out.println("ID�� �Է����ּ���.");
		String inputId = sc.nextLine();
		System.out.println("PW�� �Է����ּ���.");
		String inputPw = sc.nextLine();
		
		if (id.equals(inputId) && pw.equals(inputPw)) {
			System.out.println("�α��� ����!!");
		} else if (!inputId.equals(id)) {
			throw new LoginFailException("���̵� Ʋ�Ƚ��ϴ�. �ٽ� �α��� ���ּ���.");
		} else {
			throw new LoginFailException("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �α��� ���ּ���.");
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
