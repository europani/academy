package ch06;

/*
	main �޼ҵ忡�� Animal Ŭ������ ��ü ������ �ǵ��� ������ ����
	��� : ������:26
*/
public class Exam5 {

	public static void main(String[] args) {
		Animal a = new Animal("������", 26);
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
