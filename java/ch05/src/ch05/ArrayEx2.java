package ch05;

public class ArrayEx2 {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		for(int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
		System.out.println();
		
		int[] arr2 = {10, 20, 30};
		for(int i : arr2) {
			System.out.print(i + ", ");	
		}
	}

}
