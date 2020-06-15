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
			System.out.println("무음 처리합니다.");
		} else {
			System.out.println("무음을 해제합니다.");
		}
	}

	static void changeBattery() {
		System.out.println("건전지를 교체합니다.");
	}
}

class Televison implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("TV볼륨을 " + volume + "으로 설정합니다.");
	}

}

class Audio1 implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다.");

	}

	@Override
	public void setVolume(int volume) {
		System.out.println("오디오볼륨을 " + volume + "으로 설정합니다.");

	}

}
