package ch05;

// 5���� ����, ����, ���� ������ �л����� ����, ��� ���/ ����  ����, ���

public class Exam10 {

	public static void main(String[] args) {
		int[][] score = {
				{100, 80, 90},
				{80, 95, 100},
				{60, 65, 70},
				{85, 70, 75},
				{90, 90, 80}
		};
		int[] total = new int[3];
		
		System.out.println("\t����\t����\t����\t����\t���");
		
		for (int i = 0; i < score.length; i++) {
			int subTotal = 0;
			System.out.print(i+1 + "���л�\t");
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
				subTotal += score[i][j];
				total[j] += score[i][j];
			}
			System.out.printf("%d \t  %.2f \n" , subTotal, (double)subTotal/total.length );
		}
		
		System.out.print("�������� : ");
		for (int i = 0; i < total.length; i++) {
			System.out.printf("%d \t", total[i]);
		}
		System.out.println();
		
		System.out.print("������� : ");
		for (int i = 0; i < total.length; i++) {
			System.out.printf("%.2f \t", (double)total[i]/score.length);
		}

	}

}
