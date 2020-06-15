package ch05;

public class ArrayEx1 {

	public static void main(String[] args) {
		int[] arr1 = new int[5];
		int arr2[] = new int[5];
		
		arr1[0] = 10;	arr1[1] = 20; 	arr1[2] = 30;
		
		arr2 = arr1;
		
		arr2[4] = 50;
		
		System.out.println("arr1 : ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1["+ i + "] = " + arr1[i]);
		}
		System.out.println("arr2 : ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("arr2["+ i + "] = " + arr2[i]);
		}
		
		// Çâ»ó µÈ for
		for (int i : arr1) {
			System.out.println(i);
		}
	}

}
