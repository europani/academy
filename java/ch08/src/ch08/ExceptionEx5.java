package ch08;

public class ExceptionEx5 {

	public static void main(String[] args) {
		try {
			throw new Exception("���� ���� �߻�");
		} catch (Exception e) {
			System.out.println("���� �޽��� : " + e.getMessage());
			e.printStackTrace();
		}
	}

}
