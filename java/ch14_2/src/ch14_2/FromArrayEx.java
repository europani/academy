package ch14_2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayEx {

	public static void main(String[] args) {
		String[] strArray = {"È«±æµ¿", "½Å¿ë±Ç", "±è¹Ì³ª"};
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(s -> System.out.print(s + ", "));
		System.out.println();
		
		int[] intArray = {1, 2, 3, 4, 5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(s -> System.out.print(s + ", "));
		
		
		
	}

}
