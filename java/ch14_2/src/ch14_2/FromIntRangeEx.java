package ch14_2;

import java.util.stream.IntStream;

public class FromIntRangeEx {
	public static int sum;

	public static void main(String[] args) {
		IntStream.rangeClosed(1, 100).forEach(a -> sum+= a);
		System.out.println("รัวี : " + sum);
	}

}
