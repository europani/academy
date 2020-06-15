package ch07;

public class AbstractEx1 {

	public static void main(String[] args) {
		Abs1 a1 = new Normal();
		System.out.println(a1.getA());
//		System.out.println(a1.getB());
		System.out.println();
		
		Abs2 a2 = (Abs2) a1; 	// Abs2 a2 = new Normal();
		System.out.println(a2.getA());
		System.out.println(a2.getB());
		System.out.println();
		
		Normal n = (Normal) a2;	// Normal n = new Normal();
		System.out.println(n.getA());
		System.out.println(n.getB());
	}

}

abstract class Abs1 {
	int a = 10;
	protected abstract int getA();
}
abstract class Abs2 extends Abs1 {
	int b = 20;
	protected abstract int getB();
}

class Normal extends Abs2 {

	@Override
	protected int getB() {
		return b;
	}

	@Override
	protected int getA() {
		return a;
	}
	
}
