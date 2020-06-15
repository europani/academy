package ch06;

public class MethodEx2 {

	public static void main(String[] args) {
		Method2 m = new Method2();
		m.a = 10;
		m.b = 20;
		System.out.println(m.add1());
		System.out.println(m.add2(100, 200));
		System.out.println(Method2.add2(100, 200));
	}

}

class Method2 {
	int a, b;
	int add1() {
		return a+b;
	}
	
	static int add2(int a, int b) {
		return a+b;
	}
	
}
