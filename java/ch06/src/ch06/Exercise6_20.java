package ch06;

public class Exercise6_20 {

	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
	
	static int[] shuffle(int[] original) {
		for (int i = 0; i < original.length; i++) {
			int a = (int) (Math.random()*original.length);
			int b = (int) (Math.random()*original.length);
			
			int tmp = original[a];
			original[a] = original[b];
			original[b] = tmp;
		}
		
		return original;
		
		
	}

}
