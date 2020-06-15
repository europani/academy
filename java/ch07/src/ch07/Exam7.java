package ch07;

public class Exam7 {

	public static void main(String[] args) {
		RemoteControl rc = new Televison();
		rc.turnOn();
		rc.setVolume(10);
		rc.turnOff();
		
		rc = new Audio1();
		rc.turnOn();
		rc.setVolume(20);
		rc.setMute(false);
		rc.turnOff();
		
		RemoteControl.changeBattery();
	}

}

interface RemoteControl {
	void turnOn();
	void turnOff();
	void setVolume(int volume);

	default void setMute(boolean state) {
		if (state) {
			System.out.println("���� ó���մϴ�.");
		} else {
			System.out.println("������ �����մϴ�.");
		}
	}

	static void changeBattery() {
		System.out.println("�������� ��ü�մϴ�.");
	}
}

class Televison implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("TV�� �մϴ�.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("TV������ " + volume + "���� �����մϴ�.");
	}

}

class Audio1 implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("������� �մϴ�.");

	}

	@Override
	public void turnOff() {
		System.out.println("������� ���ϴ�.");

	}

	@Override
	public void setVolume(int volume) {
		System.out.println("����������� " + volume + "���� �����մϴ�.");

	}

}
