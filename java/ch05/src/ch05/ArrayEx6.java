package ch05;

public class ArrayEx6 {

	public static void main(String[] args) {
		int[][] arr = new int[3][2];
		arr[0][0] = 10;		arr[0][1] = 20;
		arr[1][0] = 30;		arr[1][1] = 40;
		arr[2][0] = 50;		arr[2][1] = 60;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print("arr[" + i + "][" + j + "] = " + arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("°´Ã¼ º¯°æ");
		int[] arr2 = {1, 2, 3, 4, 5};
		arr[1] = arr2;		arr2[3]=5000;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print("arr[" + i + "][" + j + "] = " + arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
