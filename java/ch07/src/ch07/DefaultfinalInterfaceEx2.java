package ch07;
public class DefaultfinalInterfaceEx2 implements Interface2 {

	public static void main(String[] args) {
		DefaultfinalInterfaceEx2 t = new DefaultfinalInterfaceEx2();
		t.method();
		DefaultfinalInterfaceEx2.method2();
		Interface2.method2();
		
	}

	static void method2() {
		System.out.println("DefaultfinalInterfaceEx2 method2()");
	}
}

interface Interface2  {
	default void method() {
		System.out.println("method()");
	}
	static void method2() {
		System.out.println("method2()");
	}
}
