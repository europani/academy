package ch07;

public class Exam5 {

	public static void main(String[] args) {
		Animal1 a = new Dove();
		a.eat();
		if (a instanceof Flyable) {
			Flyable f = (Flyable) a;
			f.fly();
		}
		
		a = new Monkey();
		a.eat();
		if (a instanceof Flyable) {
			Flyable f = (Flyable) a;
			f.fly();
		}
	}

}

interface Flyable {
	void fly();
}

abstract class Animal1 {
	String name;

	Animal1(String name) {
		this.name = name;
	}

	abstract void eat();
}

class Dove extends Animal1 implements Flyable {

	Dove() {
		super("��ѱ�");
	}

	@Override
	void eat() {
		System.out.println(name + "�� ���� ������ ��� �Դ´�.");
	}

	@Override
	public void fly() {
		System.out.println(name + "�� ���ƴٴϴ� ���Դϴ�.");

	}

}

class Monkey extends Animal1 {

	Monkey() {
		super("������");
	}

	@Override
	void eat() {
		System.out.println(name + "�� �������� ���Ÿ� �� �Դ´�.");
	}

}