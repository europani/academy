package ch06;

public class Exercise6_3 {

	public static void main(String[] args) {
		Student s = new Student();
		Student s2 = new Student("È«±æµ¿",1,1,100,60,76);
		s.name = "È«±æµ¿";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("ÀÌ¸§ : " + s.name);
		System.out.println("ÃÑÁ¡ : " + s.getTotal());
		System.out.printf("Æò±Õ : %.1f", s.getAverage());
		
		s2.info();
	}
}

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return (float)(getTotal())/3;
	}
	
	void info() {
		System.out.printf("\n%s,%d,%d,%d,%d,%d,%d,%.1f",name, ban, no, kor, eng, math, getTotal(), getAverage());
	}
	
	Student(){}
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
}
