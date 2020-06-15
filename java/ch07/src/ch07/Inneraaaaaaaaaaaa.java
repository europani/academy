package ch07;

public class Inneraaaaaaaaaaaa {

	public static void main(String[] args) {
		Outer5.StaticInner si = new Outer5.StaticInner();
		System.out.println(si.si);
		System.out.println(si.si2);
		System.out.println(si.si3);
		System.out.println(si.si4);
		System.out.println(si.si5);
		System.out.println();
		
		Outer5.InstanceInner ii = new Outer5().new InstanceInner();
		System.out.println(ii.ii);
		System.out.println(ii.ii3);
		System.out.println(ii.ii4);
		System.out.println(ii.ii5);
		System.out.println();
		
		Outer5 oi = new Outer5();
		oi.method();
	}

}

class Outer5 {
	int outeriv = 10;
	static int outercv = 20;

	class InstanceInner {
		int ii = 30;
//		static int ii2 = 40;
		final static int ii3 = 50;
		int ii4 = outeriv;
		int ii5 = outercv;
		
	}

	static class StaticInner {
		int si = 60;
		static int si2 = 70;
		final static int si3 = 80;
		int si4 = new Outer5().outeriv;
		int si5 = outercv;
	}

	void method() {
		int i = 1;

		class LocalInner {
			int li = 70;
//			static int li2 = 80;
			final static int li3 = 90;
			int li4 = outeriv;
			int li5 = outercv;
		}
	
		LocalInner li = new LocalInner();
		System.out.println(li.li);
		System.out.println(li.li3);
		System.out.println(li.li4);
		System.out.println(li.li5);
	}
	
	
}
