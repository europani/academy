package ch14_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortedEx4 {

	public static void main(String[] args) {
		IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
		intStream.sorted().forEach(n -> System.out.print(n + ", "));
		System.out.println();
		
		List<Student> studentList = Arrays.asList(
				new Student("È«±æµ¿", 1, 89, 56, 66),
				new Student("±è»ñ°«", 1, 85, 88, 80),
				new Student("ÀÌ¸ù·æ", 2, 90, 78, 95)
				);
		System.out.print("default : ");
		studentList.stream().sorted().forEach(s -> System.out.print(s.getScore() + ", "));
		System.out.println();
		System.out.print("reverse : ");
		studentList.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s.getScore() + ", "));
		
	}

}
