package ch05;
 
// command ���ο��� ���ڸ� �Է¹޾� ������ ����� ���

public class Exam7 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		System.out.print(num + "�� ��� : ");
		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				System.out.print(i + ", "); 
		}
		
	}

}
