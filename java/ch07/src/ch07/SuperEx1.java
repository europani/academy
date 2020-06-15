package ch07;

public class SuperEx1 {

	public static void main(String[] args) {
		Child2 ch = new Child2();
		ch.method();
	}

}
class Parent {
	int x = 10;
	
	Parent(int x) {
		this.x  = x;
	}
}

class Child2 extends Parent {
	int x = 20;
	
	Child2() {
		super(100);
	}
	
	void method() {
		int x = 30;
		
		System.out.println(x);			// 30
		System.out.println(this.x);		// 20
		System.out.println(super.x);	// 100
	}
}
