package ch07;

public class FinalMethodEx {
	final void finalMethod() {	//�������̵� �Ұ� �޼���
		System.out.println("finalMethod �������̵� �Ұ�");
	}

}
class SubMethod extends FinalMethodEx {
	/*
	 * void finalMethod() { System.out.println("finalmethod �������̵� �Ұ�"); }
	 */
}
