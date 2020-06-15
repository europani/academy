package ch14_2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectEx1 {

	public static void main(String[] args) {
		Student[] stuArr = {
				new Student("이자바", 3, 34, 55, 80),
				new Student("김자바", 1, 60, 45, 90),
				new Student("안자바", 2, 80, 95, 60),
				new Student("박자바", 2, 75, 85, 70),
				new Student("소자바", 1, 65, 65, 90),
				new Student("나자바", 3, 60, 85, 50),
				new Student("감자바", 3, 40, 75, 60)
		};
		// 학생 이름만 뽑아서 List<String>에 저장
		List<String> names = Stream.of(stuArr).map(Student :: getName).collect(Collectors.toList());
		System.out.println(names);
		
		// 스트림을 배열로 변환
		Student[] stuArr2 = Stream.of(stuArr).toArray(Student[] :: new);
		for (Student s : stuArr2) {
			System.out.println(s);
		}
		
		// 스트림을 Map<String, Student>로 변환. Key : 학생이름
		Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(s -> s.getName(), p -> p));
		for (String name : stuMap.keySet()) {
			System.out.println(name + "-" + stuMap.get(name));
		}
		
		long count = Stream.of(stuArr).collect(Collectors.counting());
		int totalScore = Stream.of(stuArr).collect(Collectors.summingInt(Student::getScore));
		System.out.println("count = " + count);
		System.out.println("totalScore = " + totalScore);
		
		totalScore = Stream.of(stuArr).collect(Collectors.reducing(0, Student::getScore, Integer::sum));
		System.out.println("totalScore = " + totalScore);
		
		Optional<Student> topStudent = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore)));
		System.out.println("topStudent = " + topStudent.get());
		IntSummaryStatistics stat = Stream.of(stuArr).collect(Collectors.summarizingInt(Student::getScore));
		System.out.println(stat);
		
		String stuNames = Stream.of(stuArr).map(Student::getName).collect(Collectors.joining(",", "{", "}"));
		System.out.println(stuNames);
	
				
	}

}
