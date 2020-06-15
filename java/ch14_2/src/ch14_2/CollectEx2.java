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
				new Student2("���ڹ�", true,  1, 1, 300),	
				new Student2("������", false, 1, 1, 250),	
				new Student2("���ڹ�", true,  1, 1, 200),	
				new Student2("������", false, 1, 2, 150),	
				new Student2("���ڹ�", true,  1, 2, 100),	
				new Student2("������", false, 1, 2,  50),	
				new Student2("Ȳ����", false, 1, 3, 100),	
				new Student2("������", false, 1, 3, 150),	
				new Student2("���ڹ�", true,  1, 3, 200),	

				new Student2("���ڹ�", true,  2, 1, 300),	
				new Student2("������", false, 2, 1, 250),	
				new Student2("���ڹ�", true,  2, 1, 200),	
				new Student2("������", false, 2, 2, 150),	
				new Student2("���ڹ�", true,  2, 2, 100),	
				new Student2("������", false, 2, 2,  50),	
				new Student2("Ȳ����", false, 2, 3, 100),	
				new Student2("������", false, 2, 3, 150),	
				new Student2("���ڹ�", true,  2, 3, 200)	
			};
		
		System.out.println("1. �ܼ�����(����)");
		Map<Boolean, List<Student2>> stuBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale));
		
		List<Student2> maleStudent = stuBySex.get(true);
		List<Student2> femaleStudent = stuBySex.get(false);
		System.out.println("����");
		for (Student2 s : maleStudent) {
			System.out.println(s);
		}
		System.out.println("����");
		for (Student2 s : femaleStudent) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("2. �ܼ����� + ���(���� �л���)");
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale, Collectors.counting()));
		System.out.println("���л� �� : " + stuNumBySex.get(true));
		System.out.println("���л� �� : " + stuNumBySex.get(false));
		System.out.println();
		
		System.out.println("3. �ܼ����� + ���(���� 1��)");
		Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student2::isMale, 
				Collectors.maxBy(Comparator.comparingInt(Student2::getScore))));
		System.out.println("���л� �� : " + topScoreBySex.get(true));
		System.out.println("���л� �� : " + topScoreBySex.get(false));
		System.out.println();
		
		System.out.println("4. ���ߺ���(���� ���հ���)");
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
