package ch14_2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectEx2 {

	public static void main(String[] args) {
		Student2[] stuArr = {
				new Student2("나자바", true,  1, 1, 300),	
				new Student2("김지미", false, 1, 1, 250),	
				new Student2("김자바", true,  1, 1, 200),	
				new Student2("이지미", false, 1, 2, 150),	
				new Student2("남자바", true,  1, 2, 100),	
				new Student2("안지미", false, 1, 2,  50),	
				new Student2("황지미", false, 1, 3, 100),	
				new Student2("강지미", false, 1, 3, 150),	
				new Student2("이자바", true,  1, 3, 200),	

				new Student2("나자바", true,  2, 1, 300),	
				new Student2("김지미", false, 2, 1, 250),	
				new Student2("김자바", true,  2, 1, 200),	
				new Student2("이지미", false, 2, 2, 150),	
				new Student2("남자바", true,  2, 2, 100),	
				new Student2("안지미", false, 2, 2,  50),	
				new Student2("황지미", false, 2, 3, 100),	
				new Student2("강지미", false, 2, 3, 150),	
				new Student2("이자바", true,  2, 3, 200)	
			};
		
		System.out.println("1. 단순분할(성별)");
		Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale));
		
		List<Student2> maleStudent = stuBySex.get(true);
		List<Student2> femaleStudent = stuBySex.get(false);
		System.out.println("남자");
		for (Student2 s : maleStudent) {
			System.out.println(s);
		}
		System.out.println("여자");
		for (Student2 s : femaleStudent) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("2. 단순분할 + 통계(성별 학생수)");
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale, Collectors.counting()));
		System.out.println("남학생 수 : " + stuNumBySex.get(true));
		System.out.println("여학생 수 : " + stuNumBySex.get(false));
		System.out.println();
		
		System.out.println("3. 단순분할 + 통계(성별 1등)");
		Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale, 
				Collectors.maxBy(Comparator.comparingInt(Student2::getScore))));
		System.out.println("남학생 수 : " + topScoreBySex.get(true));
		System.out.println("여학생 수 : " + topScoreBySex.get(false));
		System.out.println();
		
		System.out.println("4. 다중분할(성별 불합격자)");
		Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale, 
				Collectors.partitioningBy(s -> s.getScore() <= 100)));
		List<Student2> failedMaleStu = failedStuBySex.get(true).get(true);
		List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);
		
		for (Student2 s : failedMaleStu) {
			System.out.println(s);
		}
		for (Student2 s : failedFemaleStu) {
			System.out.println(s);
		}
		
	}

}
