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
		System.out.println("MyInterface1의 디폴트메서드 : defaultMethod()");
	}

	static void staticMethod() {
		System.out.println("MyInterface1의 스태틱메서드 : staticMethod()");
	}
}

interface MyInterface2 {
	void method();

	default void defaultMethod() {
		System.out.println("MyInterface2의 디폴트메서드 : defaultMethod()");
	}

	static void staticMethod() {
		System.out.println("MyInterface2의 스태틱메서드 : staticMethod()");
	}
}

class Parent1 {
	public void method2() {
		System.out.println("Parent의 멤버 메서드 : method2()");
	}
}

class Child1 extends Parent1 implements MyInterface1, MyInterface2 {

	@Override
	public void method() {
		System.out.println("Child의 메서드 : method()");
		System.out.println("MyInterface1, MyInterface2 의 추상메서드 오버라이딩");
	}

	@Override
	public void defaultMethod() {
		System.out.println("Child의 메서드 : defaultMethod()");
	}

}
