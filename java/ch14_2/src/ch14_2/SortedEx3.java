package ch14_2;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortedEx3 {

	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of( 
				new Student("È«±æµ¿", 1, 89, 56, 66),
				new Student("±è»ñ°«", 1, 85, 88, 80),
				new Student("ÀÌ¸ù·æ", 2, 90, 78, 95),
				new Student("ÀÓ²©Á¤", 3, 60, 56, 88),
				new Student("ÀÓ²©Á¤", 1, 90, 72, 72)
				);
				
		studentStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder()))
		.forEach(System.out::println);
		
	}

}
