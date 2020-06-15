package ch07;

public class ComplexerEx {

	public static void main(String[] args) {
		Complexer com = new Complexer();
		System.out.println("�⺻ ��ũ�� : " + Printerable.INK);
		System.out.println("FAX��ȣ : " + Faxable.FAX_NO);
		com.print();
		com.scan();
		com.send("010-456123");
		com.receive("010-456123");
		
		System.out.println();
		if (com instanceof Complexer) {
			System.out.println("com ���������� ��ü�� Complexer ��ü��");
		}
		if (com instanceof Complexarable) {
			System.out.println("com ���������� ��ü�� Complexarable ��ü��");
			Complexarable ca = com;
			ca.print();  ca.scan();  ca.receive("02-1234");  ca.send("02-1234");
		}
		if (com instanceof Printerable) {
			System.out.println("com ���������� ��ü�� Printerable ��ü��");
			Printerable pa = com;
			System.out.println(pa.INK);
		}
		if (com instanceof Scannerable) {
			System.out.println("com ���������� ��ü�� Complexer ��ü��");
			Scannerable sa = com;
			sa.scan();
		}
		if (com instanceof Faxable) {
			System.out.println("com ���������� ��ü�� Faxable ��ü��");
			Faxable fa = com;
			System.out.println(fa.FAX_NO);
			fa.send("02-1234"); fa.receive("02-1234");
		}
	}

}

interface Printerable {
	int INK = 100;

	void print();
}

interface Scannerable {
	void scan();
}

interface Faxable {
	String FAX_NO = "010-12345";

	void send(String tel);

	void receive(String tel);
}

interface Complexarable extends Printerable, Scannerable, Faxable {
}

class Complexer implements Complexarable {
	int ink;

	Complexer() {
		this.ink = INK;
	}

	@Override
	public void print() {
		System.out.println("���̿� ����մϴ�. ���� ��ũ�� : " + --ink);
	}

	@Override
	public void scan() {
		System.out.println("�̹����� ��ĵ�մϴ�.");
	}

	@Override
	public void send(String tel) {
		System.out.println(FAX_NO + "���� " + tel + "�� FAX�߽�");
	}

	@Override
	public void receive(String tel) {
		System.out.println(tel + "���� " + FAX_NO + "�� FAX����");
	}

}
