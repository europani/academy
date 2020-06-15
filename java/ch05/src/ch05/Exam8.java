package ch05;

// command ���ο��� ���ڷ� �̷���� ���ڸ� �ΰ� �޾� ������� ���ض�.
public class Exam8 {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("cmd���ο� �ΰ��� �Ķ���͸� �Է��ϼ���.");
			System.out.println("java ch06.Exam8");
			return;
		}
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int min = (num1 > num2)? num2 : num1;
		
		System.out.println(num1 + ", " + num2 + "�� ����� : ");
		for (int i = 1; i <= min; i++) {
			if (num1 % i == 0 && num2 % i ==0) {
				System.out.print(i + ", ");
			}
		}
	}

}
