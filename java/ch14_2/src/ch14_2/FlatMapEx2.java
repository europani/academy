package ch14_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapEx2 {

	public static void main(String[] args) {
		List<Student10> studentList1 = Arrays.asList(
				new Student10("ȫ�浿", 10),
				new Student10("������", 20),
				new Student10("���ϵ�", 30)
				);
		List<Student10> studentList2 = Arrays.asList(
				new Student10("���ڹ�", 10),
				new Student10("�ſ��", 20),
				new Student10("���̼�", 30)
				);
		List<List<Student10>> stu = new ArrayList<List<Student10>>();
		stu.add(studentList1);
		stu.add(studentList2);
		
		stu.stream().flatMap(s -> s.stream())
//		.MapToInt(Student10 :: getScore)
		.forEach(score -> System.out.println(score));

	}

}
