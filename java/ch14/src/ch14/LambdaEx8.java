package ch14;

import java.util.function.*;
// Function 인터페이스
// 주로 매개값을 리턴값 으로 매핑(타입변환)할 경우 사용

public class LambdaEx8 {
	private static Student[] list = {
			new Student("홍길동", 100, 90, "경영"),
			new Student("홍길순", 80, 50, "컴공")
	};

	public static void main(String[] args) {
		System.out.print("학생의 이름 : ");
		printString(s -> s.getName());
		System.out.print("학생의 전공 : ");
		printString(s -> s.getMajor());
		System.out.println("==================");
		Function<Student, String> f2 = s -> s.getName();
		printString(f2);
		printString(new Function<Student, String>() {

			@Override
			public String apply(Student s) {
				return s.getName();
			}
		});
		
		System.out.println("==================");
		System.out.print("영어점수 : ");
		printInt(s -> s.getEng());
		System.out.print("수학점수 : ");
		printInt(s -> s.getMath());
		System.out.print("영어점수 총점 : ");
		printTot(s -> s.getEng());
		System.out.print("수학점수 총점 : ");
		printTot(s -> s.getMath());
		System.out.print("영어점수 평균 : ");
		printAvg(s -> s.getEng());
		System.out.print("영어수학 평균 : ");
		printAvg(s -> s.getMath());
	}
	
	private static void printAvg(ToDoubleFunction<Student> f) {
		double sum = 0;
		for (Student s : list) {
			sum +=f.applyAsDouble(s);
		}
		System.out.println(sum/list.length);
	}
	
	private static void printTot(ToIntFunction<Student> f) {
		int sum = 0;
		for (Student s : list) {
			sum +=f.applyAsInt(s);
		}
		System.out.println(sum);
	}
	
	
//	int applyAsInt(Student s)  { return s.getMath(); }
	private static void printInt(ToIntFunction<Student> f) {
		for (Student s : list) {
			System.out.print(f.applyAsInt(s) + ",");
		}
		System.out.println();
	}
	
	private static void printString(Function<Student, String> f) {
		for (Student s : list) {
			System.out.print(f.apply(s) + ",");
		}
		System.out.println();
	}
	
	
	

}

class Student {
	private String name;
	private int eng;
	private int math;
	private String major;

	public Student(String name, int eng, int math, String major) {
		this.name = name;
		this.eng = eng;
		this.math = math;
		this.major = major;
	}

	public String getName() {
		return name;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public String getMajor() {
		return major;
	}

}
