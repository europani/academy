package ch14_2;

import java.util.*;
import java.util.stream.Stream;

public class ListStreamEx1 {

	public static void main(String[] args) {
		List<Student10> list = Arrays.asList(
				new Student10("홍길동", 90),
				new Student10("신용권", 92)
		);
		
		Stream<Student10> stream = list.stream();
		stream.forEach(s -> {
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + "-" + score);
		});
		
	}

}

class Student10 {
	String name;
	int score;
	
	public Student10(String name, int score) {
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
