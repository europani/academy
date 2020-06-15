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
		super("비둘기");
	}

	@Override
	void eat() {
		System.out.println(name + "은 작은 벌레를 잡아 먹는다.");
	}

	@Override
	public void fly() {
		System.out.println(name + "은 날아다니는 새입니다.");

	}

}

class Monkey extends Animal1 {

	Monkey() {
		super("원승이");
	}

	@Override
	void eat() {
		System.out.println(name + "은 나무에서 열매를 따 먹는다.");
	}

}