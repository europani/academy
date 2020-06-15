package ch11;

import java.util.*;

public class Exam2 {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		set.add(new Student(1, "���ڹ�", "�İ�"));
		set.add(new Student(2, "���ڹ�", "�濵"));
		set.add(new Student(2, "���ڹ�", "����"));
		set.add(new Student(1, "���ڹ�", "����"));			// �ߺ�
		set.add(new Student(3, "���ڹ�", "ü��"));
		
		System.out.println("��� �л��� : " + set.size());
		System.out.println(set);
	}

}

class Student {
	int studno;
	String name;
	String major;
	
	public Student(int studno, String name, String major) {
		this.studno = studno;
		this.name = name;
		this.major = major;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student s = (Student) obj;
			return name.equals(s.name) && studno == s.studno;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return (name+ studno).hashCode();
	}

	@Override
	public String toString() {
		return "(" + studno + ", " + name + ", " + major + ")";
	}
	
	
}
