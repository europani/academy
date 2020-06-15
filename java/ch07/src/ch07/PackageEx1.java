package ch07;

import java.util.Date;

import package2.Pack2;

public class PackageEx1 {

	public static void main(String[] args) {
		Pack1 p1 = new Pack1();
		p1.method();
		Pack2 p2 = new Pack2();
		p2.method();
		Date d = new Date();
	}

}

class Pack1 {
	void method() {
		System.out.println("ch07.Pack1.method() »£√‚µ ");
	}
}
