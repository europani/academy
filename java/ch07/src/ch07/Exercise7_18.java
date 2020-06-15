package ch07;

public class Exercise7_18 {
	static void action(Robot r) {
		if (r instanceof DanceRobot) {
			DanceRobot dr = new DanceRobot();
			dr.dance();
		} else if (r instanceof SingRobot) {
			SingRobot sr = new SingRobot();
			sr.sing();
		} else if (r instanceof DrawRobot) {
			DrawRobot dwr = new DrawRobot();
			dwr.draw();
		}
	}

	public static void main(String[] args) {
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
		for (int i = 0; i < arr.length; i++)
			action(arr[i]);
	}

}

class Robot {
}

class DanceRobot extends Robot {
	void dance() {
		System.out.println("���� ��ϴ�.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("�뷡�� �մϴ�.");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("�׸��� �׸��ϴ�.");
	}
}
