package ch07;

public class InnerEx1 {

	public static void main(String[] args) {
		Outer.StaticInner si = new Outer.StaticInner();
		System.out.println(si.iv);
		System.out.println(Outer.StaticInner.cv);
		System.out.println(Outer.StaticInner.MAX);
		
//		Outer.InstanceInner ii = new Outer.InstanceInner();
		Outer.InstanceInner ii = new Outer().new InstanceInner();
		
		Outer outer = new Outer();
		Outer.InstanceInner ii2 = outer.new InstanceInner();
		System.out.println(ii2.iv);
		System.out.println(ii2.MAX);
		System.out.println(Outer.InstanceInner.MAX);
		outer.method();
	}

}

class Outer {
	class InstanceInner {
		int iv = 100;
//		static int cv = 10;
		final static int MAX = 200;
	}
	
	static class StaticInner {
		int iv = 300;
		static int cv = 400;
		final static int MAX = 500;
	}
	
	void method() {
		class LocalInner {
			int iv = 600;
//			static int cv = 700;
			final static int MAX = 700;
		}
		
		LocalInner lc = new LocalInner();		// ���� ����Ŭ������ ������� �޼��� �������� ��� O
		System.out.println(lc.iv);
		System.out.println(lc.MAX);
		System.out.println(LocalInner.MAX);
	}
	
	void method2() {
//		LocalInner lc = new LocalInner();		// ���� ����Ŭ������ ���ǵ��� ���� �ٸ� �޼��忡�� ��� X
	}
}