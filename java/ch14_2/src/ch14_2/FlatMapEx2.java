package ch14_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapEx2 {

	public static void main(String[] args) {
		List<Student10> studentList1 = Arrays.asList(
				new Student10("홍길동", 10),
				new Student10("강나라", 20),
				new Student10("장일동", 30)
				);
		List<Student10> studentList2 = Arrays.asList(
				new Student10("나자바", 10),
				new Student10("신용권", 20),
				new Student10("유미선", 30)
				);
		List<List<Student10>> stu = new ArrayList<List<Student10>>();
		stu.add(studentList1);
		stu.add(studentList2);
		
		stu.stream().flatMap(s -> s.stream())
//		.MapToInt(Student10 :: getScore)
		.forEach(score -> System.out.println(score));

	}

}
