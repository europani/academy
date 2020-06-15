package ch07;

public class InstanceofEx {

	public static void main(String[] args) {
		Parent4 p = new Child4();
		if (p instanceof Child4) {
			System.out.println("p �������� ��ü�� Child4 �̴�.");
			Child4 c = (Child4) p;
			System.out.println(c.x);
			c.method();
		}
		if (p instanceof Parent4) {
			System.out.println("p �������� ��ü�� Parent4 �̴�.");
		}
		if (p instanceof Object) {
			System.out.println("p �������� ��ü�� Object �̴�.");
			Object o = p;
			System.out.println(p.x);
//			System.out.println(o.x);		//x�� Ojbect Ŭ������ ����� �ƴϴ�.
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
