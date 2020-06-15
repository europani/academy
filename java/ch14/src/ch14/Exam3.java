package ch14;

import java.util.function.IntBinaryOperator;

public class Exam3 {
	private static int[] arr = new int[10];

	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*100+1);
		}
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		
		System.out.println();
		System.out.println("최대값 : " + maxOrMin((a,b) ->(a>b)? a:b));
		System.out.println("최소값 : " + maxOrMin((a,b) ->(a<b)? a:b));
	}

	private static int maxOrMin(IntBinaryOperator op) {
		int result = arr[0];
		for (int i : arr) {
			result = op.applyAsInt(result, i);
		}
		return result;
	}

}
