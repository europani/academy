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
			System.out.println("command ���ο� �Ķ���͸� �Է��ϼ���.");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("command ���ο� �Ķ���͸� �Է��ϼ���.");
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("0���� ������ ������.");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Null �Դϴ�.");
		} catch (RuntimeException e) {
			System.out.println("1. �����߻� : �������");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("2. �����߻� : �������");
			e.printStackTrace();
		} 
		
	}

}
