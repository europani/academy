package ch07;

public class DefaultfinalInterfaceEx {

	public static void main(String[] args) {
		Child1 c = new Child1();
		c.method();
		c.method2();
		MyInterface1.staticMethod();
		MyInterface2.staticMethod();
	}

}

interface MyInterface1 {
	void method();

	default void defaultMethod() {
		System.out.println("MyInterface1�� ����Ʈ�޼��� : defaultMethod()");
	}

	static void staticMethod() {
		System.out.println("MyInterface1�� ����ƽ�޼��� : staticMethod()");
	}
}

interface MyInterface2 {
	void method();

	default void defaultMethod() {
		System.out.println("MyInterface2�� ����Ʈ�޼��� : defaultMethod()");
	}

	static void staticMethod() {
		System.out.println("MyInterface2�� ����ƽ�޼��� : staticMethod()");
	}
}

class Parent1 {
	public void method2() {
		System.out.println("Parent�� ��� �޼��� : method2()");
	}
}

class Child1 extends Parent1 implements MyInterface1, MyInterface2 {

	@Override
	public void method() {
		System.out.println("Child�� �޼��� : method()");
		System.out.println("MyInterface1, MyInterface2 �� �߻�޼��� �������̵�");
	}

	@Override
	public void defaultMethod() {
		System.out.println("Child�� �޼��� : defaultMethod()");
	}

}
