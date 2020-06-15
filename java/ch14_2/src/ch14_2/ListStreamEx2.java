package ch14_2;

import java.util.*;

public class ListStreamEx2 {

	public static void main(String[] args) {
		List<Student10> studentList = Arrays.asList(
				new Student10("홍길동", 10),
				new Student10("김자바", 20),
				new Student10("나쌍용", 30)
		);
		
		double avg = studentList.stream()			// 오리지널 스트림
				.mapToInt(s -> s.getScore())		// 중간 처리
				.average()							// 최종 처리
				.getAsDouble();						// 언박싱(Wrapper -> 기본)
		
		System.out.println("평균 점수 : " + avg);
	}

}
