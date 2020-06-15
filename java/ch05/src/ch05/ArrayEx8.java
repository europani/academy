package ch05;

public class ArrayEx8 {
	public static void main(String[] args) {
		// 배열 생성
		int[][] arr = new int[10][];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[i+1];
		}
		// 데이터 할당
		int data = 1;
		for (int j = arr.length-1; j >=0; j--) {
			for (int i = j; i < arr.length; i++) {
				arr[i][j] = data++;
			}
		}
		// 데이터 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			} System.out.println();
		}

	}
}
