package ch14_2;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapEx3 {

	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of(
				new String[] {"abc", "def", "jkl"},
				new String[] {"ABC", "DEF", "JKL"}
				);
		
		Stream<String> stream = strArrStrm.flatMap(Arrays :: stream);
		stream.forEach(s -> System.out.println(s));
		
	}

}
