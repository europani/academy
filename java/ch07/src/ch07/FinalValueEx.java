package ch07;

public class FinalValueEx {

	public static void main(String[] args) {
		FinalValue f1 = new FinalValue();
//		f1.NUM = 200; // ����� ���� �Ұ�
		System.out.println(f1.getNUM());
		FinalValue f2 = new FinalValue(120);
		System.out.println(f2.getNUM());
	}

}
class FinalValue {
	final int NUM;		// ����� �ʱ�ȭ ����.
	
	FinalValue() {
		this(100);
	}
	FinalValue(int num) {	
		NUM = num;		// �����ڿ��� �ʱ�ȭ �ѹ� ����(����� �ʱ�ȭ ���߱⶧����)
	}
	
	public int getNUM() {
		return NUM;
	}
	
}
