package ch07;

public class InstanceofEx {

	public static void main(String[] args) {
		Parent4 p = new Child4();
		if (p instanceof Child4) {
			System.out.println("p 참조변수 객체는 Child4 이다.");
			Child4 c = (Child4) p;
			System.out.println(c.x);
			c.method();
		}
		if (p instanceof Parent4) {
			System.out.println("p 참조변수 객체는 Parent4 이다.");
		}
		if (p instanceof Object) {
			System.out.println("p 참조변수 객체는 Object 이다.");
			Object o = p;
			System.out.println(p.x);
//			System.out.println(o.x);		//x는 Ojbect 클래스의 멤버가 아니다.
		}
	}
}

class Parent4 {
	int x;
}

class Child4 extends Parent4 {
	void method() {
		System.out.println("child method");
	}
}
