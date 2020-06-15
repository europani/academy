package ch14;

import java.util.*;
import java.util.function.*;

// Predicate 인터페이스

public class LambdaEx10 {
	private static List<Student> list = Arrays.asList(
			new Student("홍길동", 55, 60, "컴공"),
			new Student("김삿갓", 95, 90, "경영"),
			new Student("이몽룡", 75, 80, "심리"),
			new Student("임꺽정", 65, 70, "전자"),
			new Student("성춘향", 65, 0, "컴공")
	);

	public static void main(String[] args) {
		System.out.println("영어 점수가 60점 이상인 학생의 영어 평균 : " + avg1(s -> s.getEng()>=60));
		System.out.println("수학 점수가 60점 이상인 학생의 수학 평균 : " + avg2(s -> s.getMath()>=60));
		System.out.println("컴공과 학생의 영어 평균 : " + aveEng(s -> s.getMajor().equals("컴공")));
		System.out.print("컴공과 학생 이름 : ");
		nameList(s -> s.getMajor().equals("컴공"));
		System.out.print("컴공이 아닌 학생 이름 : ");
		nameList(s -> !s.getMajor().equals("컴공"));
		
		

	}
	private static void nameList(Predicate<Student> p) {
		for (Student s : list) {
			if (p.test(s)) {	
				System.out.print(s.getName() + ", ");
			}
		}
		System.out.println();
		
	}
	private static double aveEng(Predicate<Student> p) {
		int cnt = 0, sum = 0;
		for (Student s : list) {
			if (p.test(s)) {	
				cnt++;;
				sum += s.getEng();
			}
		}
		return (double) sum/cnt;
		
	}
	private static double avg2(Predicate<Student> p) {
		int cnt = 0, sum = 0;
		for (Student s : list) {
			if (p.test(s)) {		// p.test(s) = s.getEng()>=60 
				cnt++;;
				sum += s.getMath();
			}
		}
		return (double) sum/cnt;
	}
//	Predicate<Student> p = s -> s.getEng()>=60
	private static double avg1(Predicate<Student> p) {
		int cnt = 0, sum = 0;
		for (Student s : list) {
			if (p.test(s)) {		// p.test(s) = s.getEng()>=60 
				cnt++;;
				sum += s.getEng();
			}
		}
		return (double) sum/cnt;
		
	}

}
