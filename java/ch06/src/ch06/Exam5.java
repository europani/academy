package ch06;

/*
	main 메소드에서 Animal 클래스의 객체 생성이 되도록 생성자 구형
	결과 : 원숭이:26
*/
public class Exam5 {

	public static void main(String[] args) {
		Animal a = new Animal("원숭이", 26);
		System.out.println(a);
	}

}

class Animal {
	String name;
	int age;

	Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + ":" + age;
	}

}
