package ch14_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MappingEx1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("È«±æµ¿Àü", "ÃáÇâÀü", "±¸¿î¸ù", "Àü¿ìÄ¡Àü", "»ç¾¾³²Á¤±â");

		IntStream is = list.stream().mapToInt(String :: length);
//		is.forEach((n) -> System.out.println(n));
		is.forEach(System.out :: println);
		System.out.println();
		
		list.stream().mapToInt(s -> s.length()).forEach(System.out :: println);

	}

}
