package ch07;

public class SingletonEx {

	public static void main(String[] args) {
//		SingleObject so = new SingleObject();
		SingleObject so1 = SingleObject.getObject(); // =obj
		SingleObject so2 = SingleObject.getObject(); // =obj
		System.out.println(so1 + ", "+ so2);			// �ּ� ���� (������� �ϳ��� �ּҸ� ������)
		
		Object o1 = new Object();
		Object o2 = new Object();
		System.out.println(o1 + ", "+ o2);				// �ּ� �ٸ�
		
		System.out.println(so1.getValue());
		System.out.println(so2.getValue());
		so1.setValue(500);
		System.out.println(so1.getValue());
		System.out.println(so2.getValue());
		if (so1 == so2) {
			System.out.println("so1�� so2�� ���� ��ü��");
		}
		
	}

}
class SingleObject {
	private static SingleObject obj = new SingleObject();	// Ŭ���� ���ο��� ��ü ����. cuz, private ������
	private SingleObject() {}
	private int value =100;
	
	public static SingleObject getObject() {				// �ܺο��� ������ �ü� �ִ� �޼���
		return obj;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
