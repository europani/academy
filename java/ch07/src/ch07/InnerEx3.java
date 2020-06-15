package ch07;

public class InnerEx3 {
	public static void main(String[] args) {
		Outer3.InstanceInner ii = new Outer3().new InstanceInner();
		ii.method1();
		
	}
	
}

class Outer3 {
	int iv = 10;
	int iv2 = 20;
	
	class InstanceInner {
		int iv = 100;
		
		void method1() {
			int iv = 300;
			System.out.println("iv = " + iv);					// 300
			System.out.println("this.iv = " + this.iv);			// 100
			this.iv = 50;				// Outer3 클래스의 내부클래스(InstanceInner) 멤버변수 iv
			System.out.println("this.iv = " + this.iv);
			System.out.println("Outer3.this.iv = " + Outer3.this.iv); // Outer3 클래스의 멤버변수 iv
			System.out.println("Outer3.this.iv2 = " + Outer3.this.iv2);
		}
	}

}
