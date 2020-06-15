package ch14_2;


import java.util.Arrays;
import java.util.stream.Stream;

public class FilterEx3 {

	public static void main(String[] args) {
		Stream<String[]> strArrStrm = Stream.of(
				new String[] {"abc", "def", "jkl"},
				new String[] {"ABC", "DEF", "JKL"}
				);
		
//		strArrStrm.flatMap((t) -> Arrays.stream(t));
		Stream<String> stream = strArrStrm.flatMap(Arrays :: stream);
		stream.filter(s -> s.compareTo("a")>0)
		.forEach(s -> System.out.println(s));
		
		
	}

}
