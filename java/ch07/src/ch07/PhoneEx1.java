package ch07;

public class PhoneEx1 {

	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();
		System.out.println(sp.toString());
		sp.power = true;
		sp.send();
		sp.receive();
		sp.setApp("���̹�");
	}

}

class Phone extends Object {

	boolean power;
	int number;

	void power() {
		power = !power;
	}

	void send() {
		if (power) {
			System.out.println("��ȭ�ɱ�");
		}

	}
	void receive() {
		if (power) {
			System.out.println("��ȭ�ޱ�");
		}
	}

}

class SmartPhone extends Phone {
	void setApp(String name) {
		if (power) {
			System.out.println(name + " ��ġ��~");
		}
	}
}
