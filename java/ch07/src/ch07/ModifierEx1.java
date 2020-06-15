package ch07;

import package2.Modifier2;

public class ModifierEx1 {

	public static void main(String[] args) {
		Modifier m1 = new Modifier();
//		System.out.println(m1.v1);		// 접근불가 (private)
//		System.out.println(m1.v2);		// 접근불가 (private)
		m1.method();
		
		Modifier3 m3 = new Modifier3();
//		System.out.println("m3.v1 = " + m3.v1);
//		System.out.println("m3.v2 = " + m3.v2);
//		System.out.println("m3.v3 = " + m3.v3);
		System.out.println("m3.v4 = " + m3.v4);
//		Math m = new Math();					// 생성자의 접근제어자가 private이라 객체생성 불가.
		
	}

}
class Modifier {
	private int v1 = 100;
	private int v2 = 200;
	protected int v3 = v1;
	
	public void method() {
		System.out.println("ch07.Modifier.method() 실행");
		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);
	}
}

class Modifier3 extends Modifier2{
	public void method() {
//		System.out.println("v1 = " + v1);		// v1변수의 접근제어자 : private
//		System.out.println("v2 = " + v2);		// v2변수의 접근제어자 : (default)
		System.out.println("v3 = " + v3);		// v3변수의 접근제어자 : protected
		System.out.println("v4 = " + v4);		// v4변수의 접근제어자 : public
	}
}
