package ch14;

import java.util.function.*;
// Function �������̽�
// �ַ� �Ű����� ���ϰ� ���� ����(Ÿ�Ժ�ȯ)�� ��� ���

public class LambdaEx8 {
	private static Student[] list = {
			new Student("ȫ�浿", 100, 90, "�濵"),
			new Student("ȫ���", 80, 50, "�İ�")
	};

	public static void main(String[] args) {
		System.out.print("�л��� �̸� : ");
		printString(s -> s.getName());
		System.out.print("�л��� ���� : ");
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
		System.out.print("�������� : ");
		printInt(s -> s.getEng());
		System.out.print("�������� : ");
		printInt(s -> s.getMath());
		System.out.print("�������� ���� : ");
		printTot(s -> s.getEng());
		System.out.print("�������� ���� : ");
		printTot(s -> s.getMath());
		System.out.print("�������� ��� : ");
		printAvg(s -> s.getEng());
		System.out.print("������� ��� : ");
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
