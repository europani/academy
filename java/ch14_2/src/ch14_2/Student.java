package ch14_2;

public class Student implements Comparable<Student>{
	String name;
	int ban;
	int eng;
	int math;
	int kor;
	int score;
	
	public Student(String name, int ban, int eng, int math, int kor) {
		this.name = name;
		this.ban = ban;
		this.eng = eng;
		this.math = math;
		this.kor = kor;
		this.score = eng+math+kor;
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getKor() {
		return kor;
	}

	
	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + ban + ", " + eng + ", " + math + ", " + kor + "]";
	}

	@Override
	public int compareTo(Student o) {		// 총점 내림차순
		return (o.eng+o.math+o.kor) - (eng+math+kor);
	}
	
	

}
