package ch14_2;

import java.util.Arrays;
import java.util.List;

public class SortedEx2 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("È«±æµ¿", 1, 89, 56, 66),
				new Student("±è»ñ°«", 1, 85, 60, 80),
				new Student("ÀÌ¸ù·æ", 2, 90, 78, 95),
				new Student("ÀÓ²©Á¤", 3, 60, 56, 88));
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println("¿µ¾î °íµæÁ¡¼ø");
		list.stream().sorted((s1, s2) -> s2.getEng()-s1.getEng()).forEach(System.out::println);
		System.out.println("¼öÇÐ °íµæÁ¡¼ø");
		list.stream().sorted((s1, s2) -> s2.getMath()-s1.getMath()).forEach(System.out::println);
		System.out.println("ÃÑÁ¡ °íµæÁ¡¼ø");
		list.stream().sorted((s1, s2) -> s2.getScore()-s1.getScore()).forEach(System.out::println);
		
	}

}
