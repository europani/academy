package ch14_2;

import java.util.Arrays;
import java.util.List;

public class FlatMapEx1 {

	public static void main(String[] args) {
		List<String> inputlist1 = Arrays.asList("java8 lambda", "stream mapping");
		inputlist1.stream()
		.flatMap(data -> Arrays.stream(data.split(" ")))
		.forEach(word -> System.out.println(word));
		System.out.println();
		
		List<String> inputlist2 = Arrays.asList("10, 20, 30", "40, 50, 60");
		inputlist2.stream()
		.flatMapToInt(data -> {
			String[] strArr = data.split(",");
			int[] intArr = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		}).forEach(number -> System.out.println(number));
		
	}

}
