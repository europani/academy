package ch14;

import java.util.*;
import java.util.function.*;

// Predicate �������̽�

public class LambdaEx10 {
	private static List<Student> list = Arrays.asList(
			new Student("ȫ�浿", 55, 60, "�İ�"),
			new Student("���", 95, 90, "�濵"),
			new Student("�̸���", 75, 80, "�ɸ�"),
			new Student("�Ӳ���", 65, 70, "����"),
			new Student("������", 65, 0, "�İ�")
	);

	public static void main(String[] args) {
		System.out.println("���� ������ 60�� �̻��� �л��� ���� ��� : " + avg1(s -> s.getEng()>=60));
		System.out.println("���� ������ 60�� �̻��� �л��� ���� ��� : " + avg2(s -> s.getMath()>=60));
		System.out.println("�İ��� �л��� ���� ��� : " + aveEng(s -> s.getMajor().equals("�İ�")));
		System.out.print("�İ��� �л� �̸� : ");
		nameList(s -> s.getMajor().equals("�İ�"));
		System.out.print("�İ��� �ƴ� �л� �̸� : ");
		nameList(s -> !s.getMajor().equals("�İ�"));
		
		

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
