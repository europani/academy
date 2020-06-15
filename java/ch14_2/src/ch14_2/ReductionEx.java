package ch14_2;

import java.util.Arrays;
import java.util.List;

public class ReductionEx {

	public static void main(String[] args) {
		List<Student11> studentList = Arrays.asList(
				new Student11("È«±æµ¿", 92),
				new Student11("½Å¿ë±Ç", 95),
				new Student11("±èÀÚ¹Ù", 88)
				);
		int sum1 = studentList.stream()
//				.mapToInt((t) -> t.getScore())
				.mapToInt(Student11 :: getScore)
				.sum();
		int sum2 = studentList.stream()
				.map(Student11::getScore).reduce((a,b) -> a+b).get();
		int sum3 = studentList.stream()
				.map(Student11::getScore).reduce(0, (a,b) -> a+b);
		System.out.println("sum1 : " + sum1);
		System.out.println("sum2 : " + sum2);
		System.out.println("sum3 : " + sum3);
	}

}

class Student11 {
	private String name;
	private int score;
	
	public Student11(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	
	
	
}