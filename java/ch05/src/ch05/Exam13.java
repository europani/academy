package ch05;

// 2차열 배열의 행 합, 열 합 구하기
public class Exam13 {

	public static void main(String[] args) {
		int[][] arr = {
				{1},
				{10, 20},
				{30, 40, 50},
				{60, 70, 80, 90},
				{60, 70, 80, 90, 100}
		};
		int[] rowTotal = new int[arr.length]; // 세로길이
		
		int maxcol = 0;
		for (int i = 0; i < arr.length; i++) {
			if (maxcol < arr[i].length) {
				maxcol = arr[i].length;
			}
		}
		int[] columnTotal = new int[maxcol];	// 가로길이
		
		// 합 구하기
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
				rowTotal[i] += arr[i][j];
				columnTotal[j] += arr[i][j];
			}
			System.out.println();
		}
		System.out.println();  
		
		// 출력
		for (int i = 0; i < rowTotal.length; i++) {
			System.out.println(i + "열의 합 : " + rowTotal[i]);
		}
		System.out.println();
		for (int i = 0; i < columnTotal.length; i++) {
			System.out.println(i + "행의 합 : " + columnTotal[i]);
		
		}
		
	}

}
