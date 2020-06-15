package ch07;

public class InnerEx2 {

	public static void main(String[] args) {
		Outer2 out = new Outer2();
		out.method(1);
		Outer2.InstanceInner i2 = out.new InstanceInner();
		System.out.println(i2.iiv);
		System.out.println(i2.iiv2);
		
		Outer2.StaticInner i3 = new Outer2.StaticInner();
		System.out.println(i3.siv);
		System.out.println(Outer2.StaticInner.scv);
	}

}

class Outer2 {
	private int outeriv = 10;		// 인스턴스 변수(외부)
	private static int outercv = 20; // 스태틱 변수(외부)
	class InstanceInner {			// 인스턴스 내부클래스 
		int iiv = outeriv;
		int iiv2 = outercv;
	}
	static class StaticInner {		// 스태틱 내부클래스
		int siv = new Outer2().outeriv;
		static int scv = outercv;
	}
	static StaticInner cv = new StaticInner();						// 스태틱 스태틱
	InstanceInner iv = new InstanceInner();							// 인스턴스 스태틱
	static InstanceInner cv2 = new Outer2().new InstanceInner();	// 스태틱 인스턴스
	static StaticInner iv2 = new StaticInner();						// 스태틱 스태틱
	
	
	void method(final int pv) {				//지역내부클래스에서 사용되는 메서드의 지역변수는 final여야함.
		int i = 0;
//		pv++;			//변경불가 (cuz, final)
		class LocalInner {			// 지역 내부클래스
			int liv = outeriv;				
			int liv2 = outercv;				
			void method() {					
//				i = 100;					//지역내부클래스에 속한 메서드 안에서 지역변수 변경 X(final로 여겨짐)
//				pv++;	//변경불가 (cuz, final)
				System.out.println("i = " + i);
				System.out.println("pv = " + pv);
				System.out.println(liv + ", " + liv2);
				System.out.println(outeriv + ", " + outercv);
			}
		}
		LocalInner li = new LocalInner();
		li.method();
	}
	
}