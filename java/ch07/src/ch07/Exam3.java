package ch07;

public class Exam3 {

	public static void main(String[] args) {
		Animal[] animal = new Animal[2];
		animal[0] = new Dog();
		animal[1] = new Lion();
		for (Animal a : animal) {
			System.out.print(a.type + "=>");
			a.sound();
			a.eat();
		}
	}

}

abstract class Animal {
	String type;
	int leg;
	
	Animal(String type, int leg) {
		this.type = type;
		this.leg = leg;
	}
	
	abstract void eat();
	abstract void sound();
}

class Dog extends Animal {
	Dog() {
		super("Dog", 4);
	}

	@Override
	void eat() {
		System.out.println("������ �ִ´�� �Դ´�.");
	}

	@Override
	void sound() {
		System.out.println("�۸�");
	}
	
}

class Lion extends Animal {
	
	Lion() {
		super("Lion", 4);
	}

	@Override
	void eat() {
		System.out.println("�ʽĵ����� ��� �Դ´�.");
	}

	@Override
	void sound() {
		System.out.println("����");
	}
	
	
	
}