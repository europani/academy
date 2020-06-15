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
	private int outeriv = 10;		// �ν��Ͻ� ����(�ܺ�)
	private static int outercv = 20; // ����ƽ ����(�ܺ�)
	class InstanceInner {			// �ν��Ͻ� ����Ŭ���� 
		int iiv = outeriv;
		int iiv2 = outercv;
	}
	static class StaticInner {		// ����ƽ ����Ŭ����
		int siv = new Outer2().outeriv;
		static int scv = outercv;
	}
	static StaticInner cv = new StaticInner();						// ����ƽ ����ƽ
	InstanceInner iv = new InstanceInner();							// �ν��Ͻ� ����ƽ
	static InstanceInner cv2 = new Outer2().new InstanceInner();	// ����ƽ �ν��Ͻ�
	static StaticInner iv2 = new StaticInner();						// ����ƽ ����ƽ
	
	
	void method(final int pv) {				//��������Ŭ�������� ���Ǵ� �޼����� ���������� final������.
		int i = 0;
//		pv++;			//����Ұ� (cuz, final)
		class LocalInner {			// ���� ����Ŭ����
			int liv = outeriv;				
			int liv2 = outercv;				
			void method() {					
//				i = 100;					//��������Ŭ������ ���� �޼��� �ȿ��� �������� ���� X(final�� ������)
//				pv++;	//����Ұ� (cuz, final)
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