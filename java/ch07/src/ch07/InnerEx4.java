package ch07;

public class InnerEx4 {

	public static void main(String[] args) {
		I1 i = new I1() {	// 익명 클래스
			int iv = 100;
			
			@Override
			public void test() {
				System.out.println("iv = " + iv);
				System.out.println("this.iv = " + this.iv);
				System.out.println("I 내부클래스의 test 메서드");
			}
		};
		i.test();
		
//		System.out.println(i.iv);			// iv멤버는 I1 인터페이스의 멤버가 아니므로 접근불가
		int iv = 100;						// 지역변수(메인메서드)
//		iv++;								// 익명 내부클래스는 지역내부 클래스임. 지역변수(iv)는 상수화가 필요=>수정X
		
		Abs a = new Abs() {	// 익명 클래스

			@Override
			void test() {
				System.out.println("iv = " + iv);
				System.out.println("Abs 내부 클래스의 test 메서드");
			}
			
		};
		a.test();
		
	
	}

}

interface I1 {
	void test();
}

abstract class Abs {
	abstract void test();
}
