package ch07;

import package2.Modifier2;

public class ModifierEx1 {

	public static void main(String[] args) {
		Modifier m1 = new Modifier();
//		System.out.println(m1.v1);		// ���ٺҰ� (private)
//		System.out.println(m1.v2);		// ���ٺҰ� (private)
		m1.method();
		
		Modifier3 m3 = new Modifier3();
//		System.out.println("m3.v1 = " + m3.v1);
//		System.out.println("m3.v2 = " + m3.v2);
//		System.out.println("m3.v3 = " + m3.v3);
		System.out.println("m3.v4 = " + m3.v4);
//		Math m = new Math();					// �������� ���������ڰ� private�̶� ��ü���� �Ұ�.
		
	}

}
class Modifier {
	private int v1 = 100;
	private int v2 = 200;
	protected int v3 = v1;
	
	public void method() {
		System.out.println("ch07.Modifier.method() ����");
		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);
	}
}

class Modifier3 extends Modifier2{
	public void method() {
//		System.out.println("v1 = " + v1);		// v1������ ���������� : private
//		System.out.println("v2 = " + v2);		// v2������ ���������� : (default)
		System.out.println("v3 = " + v3);		// v3������ ���������� : protected
		System.out.println("v4 = " + v4);		// v4������ ���������� : public
	}
}
