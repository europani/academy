package ch08;

import java.io.IOException;

public class ExceptionEx8 {

	public static void main(String[] args) {
		Parent p = new Parent();
		try {
			p.method(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Parent {
	void method(int i) throws Exception {
		System.out.println(i);
	}
}

class Child extends Parent  {
	@Override
	void method(int i) throws IOException {
		System.out.println("4");
		try {
			throw new IOException();
		} catch (Exception e) {}
	}
}
