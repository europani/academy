package ch04;

public class LoopEx1 {

	public static void main(String[] args) {
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
		System.out.print(4);
		System.out.println(5);
		System.out.println("for �������� 1~5���� ����ϱ�");
		for (int i = 1; i <= 5; i++) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println("while �������� 1~5���� ����ϱ�");
		int i=1;
		do {
			System.out.print(i);
			i++;
		} while (i<=5);	
		System.out.println();
	}		
}