package ch09;

public class TostringEx1 {

	public static void main(String[] args) {
		Animal a = new Animal("È£¶ûÀÌ", 20);
		System.out.println(a);
	}

}

class Animal {
	int age;
	String name;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@" + System.identityHashCode(this);
//		return name + ", " + age;
	}
	
	
}
