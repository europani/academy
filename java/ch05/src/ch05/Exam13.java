package ch05;

// 2���� �迭�� �� ��, �� �� ���ϱ�
public class Exam13 {

	public static void main(String[] args) {
		int[][] arr = {
				{1},
				{10, 20},
				{30, 40, 50},
				{60, 70, 80, 90},
				{60, 70, 80, 90, 100}
		};
		int[] rowTotal = new int[arr.length]; // ���α���
		
		int maxcol = 0;
		for (int i = 0; i < arr.length; i++) {
			if (maxcol < arr[i].length) {
				maxcol = arr[i].length;
			}
		}
		int[] columnTotal = new int[maxcol];	// ���α���
		
		// �� ���ϱ�
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
				rowTotal[i] += arr[i][j];
				columnTotal[j] += arr[i][j];
			}
			System.out.println();
		}
		System.out.println();  
		
		// ���
		for (int i = 0; i < rowTotal.length; i++) {
			System.out.println(i + "���� �� : " + rowTotal[i]);
		}
		System.out.println();
		for (int i = 0; i < columnTotal.length; i++) {
			System.out.println(i + "���� �� : " + columnTotal[i]);
		
		}
		
	}

}
