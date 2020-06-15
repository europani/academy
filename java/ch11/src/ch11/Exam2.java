package ch11;

import java.util.*;

public class Exam2 {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		set.add(new Student(1, "이자바", "컴공"));
		set.add(new Student(2, "김자바", "경영"));
		set.add(new Student(2, "최자바", "수학"));
		set.add(new Student(1, "이자바", "경제"));			// 중복
		set.add(new Student(3, "공자바", "체육"));
		
		System.out.println("등록 학생수 : " + set.size());
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
