package ch06;

public class MemberCallEx1 {

	static int cv1 = 10;
	static int cv2 = cv1;			// Ŭ��������� ȣ��
	int iv1 = 100;
	int iv2 = iv1;					// �ν��Ͻ������ ȣ��
	int iv3 = cv1;					// Ŭ������� ȣ�� (in �ν��Ͻ����)

//	static int cv3 = iv1;			// �ν��Ͻ���� ȣ�� (in Ŭ�������) --> �Ұ�(�ν��Ͻ��� �����ؾߵ�)
	static int cv3 = new MemberCallEx1().iv1;

	public static void main(String[] args) {
//		cv2 = iv1;					// main�޼ҵ�(Ŭ�������)���� �ν��Ͻ���� ���� �Ұ�
		cv2 = new MemberCallEx1().iv1;

//		iv1 = cv2;					// main�޼ҵ�(Ŭ�������)���� �ν��Ͻ���� ���� �Ұ�
		new MemberCallEx1().iv1 = cv2;

//		method1();					// main�޼ҵ�(Ŭ�������)���� �ν��Ͻ��޼ҵ� ��� �Ұ�
		new MemberCallEx1().method1();

		method2();
	}

	void method1() {
		System.out.println(cv1 + cv2);
		System.out.println(iv1 + iv2);
	}

	static void method2() {
		System.out.println(cv1 + cv2);
		
//		System.out.println(iv1 + iv2);	//Ŭ�����޼ҵ忡�� �ν��Ͻ���� ��� �Ұ�
		MemberCallEx1 m = new MemberCallEx1();
		System.out.println(m.iv1 + m.iv2);
	}

}
