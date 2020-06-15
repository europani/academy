package ch07;

public class InnerEx4 {

	public static void main(String[] args) {
		I1 i = new I1() {	// �͸� Ŭ����
			int iv = 100;
			
			@Override
			public void test() {
				System.out.println("iv = " + iv);
				System.out.println("this.iv = " + this.iv);
				System.out.println("I ����Ŭ������ test �޼���");
			}
		};
		i.test();
		
//		System.out.println(i.iv);			// iv����� I1 �������̽��� ����� �ƴϹǷ� ���ٺҰ�
		int iv = 100;						// ��������(���θ޼���)
//		iv++;								// �͸� ����Ŭ������ �������� Ŭ������. ��������(iv)�� ���ȭ�� �ʿ�=>����X
		
		Abs a = new Abs() {	// �͸� Ŭ����

			@Override
			void test() {
				System.out.println("iv = " + iv);
				System.out.println("Abs ���� Ŭ������ test �޼���");
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
