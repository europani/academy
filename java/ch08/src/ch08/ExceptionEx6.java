package ch08;

public class ExceptionEx6 {

	public static void main(String[] args) {
		try {
			badmethod();
		} catch (Exception e) {
			System.out.println("���θ޼��忡�� ���� ó��");
			e.printStackTrace();
		}
	}

	private static void badmethod() throws Exception {
		try {
			throw new Exception("���� ���� �߻�");
		} catch (Exception e) {
			System.out.println("badmethod���� ���� ó��");
			e.printStackTrace();
			throw e;
		}
	}
}
