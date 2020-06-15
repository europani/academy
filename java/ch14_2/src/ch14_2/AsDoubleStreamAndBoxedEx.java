package ch14_2;

import java.util.Arrays;

public class AsDoubleStreamAndBoxedEx {

	public static void main(String[] args) {
		int[] intArr = {1, 2, 3, 4, 5};
		
		Arrays.stream(intArr).asDoubleStream().forEach(d -> System.out.println(d));
		System.out.println();
		
		Arrays.stream(intArr).boxed().forEach(d -> System.out.println(d.intValue()));
	}

}
