package ch05;

//command ���ο��� ���ڸ� �Է¹޾� �Ҽ����� �Ǻ��Ͻÿ�.

public class Exam12 {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("cmd���ο�  ���ڸ� �Է����ּ���.");
			return;
		}
		int num = Integer.parseInt(args[0]);
		int cnt = 0;
		
		for (int i = 1; i <= num; i++) {
			if (num % i==0) {
				cnt++;
			}
		}
		if (cnt == 2) {
			System.out.println(num + "�� �Ҽ��Դϴ�.");
		} else {
			System.out.println(num + "�� �Ҽ��� �ƴմϴ�.");
		}

		
	}
}
