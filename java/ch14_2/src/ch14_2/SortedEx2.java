package ch14_2;

import java.util.Arrays;
import java.util.List;

public class SortedEx2 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("ȫ�浿", 1, 89, 56, 66),
				new Student("���", 1, 85, 60, 80),
				new Student("�̸���", 2, 90, 78, 95),
				new Student("�Ӳ���", 3, 60, 56, 88));
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println("���� �������");
		list.stream().sorted((s1, s2) -> s2.getEng()-s1.getEng()).forEach(System.out::println);
		System.out.println("���� �������");
		list.stream().sorted((s1, s2) -> s2.getMath()-s1.getMath()).forEach(System.out::println);
		System.out.println("���� �������");
		list.stream().sorted((s1, s2) -> s2.getScore()-s1.getScore()).forEach(System.out::println);
		
	}

}
