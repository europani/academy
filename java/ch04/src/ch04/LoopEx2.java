package ch04;

public class LoopEx2 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		
		System.out.println("for ���� �̿��ϱ�.");
		for (i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1~10������ �� : " + sum);
		
		i=0;
		sum = 0;
		System.out.println("while ���� �̿��ϱ�.");
		while (i<=10) {
			sum += i;
			i++;
		}
		System.out.println("1~10������ �� : " + sum);
	
		i=0;
		sum = 0;
		System.out.println("do-while ���� �̿��ϱ�.");
		do {
			sum += i;
			i++;
		} while (i<=10);
		System.out.println("1~10������ �� : " + sum);
	}

}
