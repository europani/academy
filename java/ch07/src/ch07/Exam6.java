package ch07;

public class Exam6 {

	public static void main(String[] args) {
		Tank t = new Tank();
		Marine m = new Marine();
		Dropship d = new Dropship();
		SCV s = new SCV();
		
		s.repair(t);
//		s.repair(m);
		s.repair(d);
		s.repair(s);
	}

}

interface Repairable {}

class Unit {
	int hp;
	final int MAX;
	
	Unit(int hp) {
		this.hp = hp;
		MAX = hp;
	}
}

class GroundUnit extends Unit {

	GroundUnit(int hp) {
		super(hp);
	}
}
class AirUnit extends Unit {

	AirUnit(int hp) {
		super(hp);
	}
}

class Marine extends GroundUnit {

	Marine() {
		super(40);
	}

	@Override
	public String toString() {
		return "Marine";
	}
}

class Tank extends GroundUnit implements Repairable {

	Tank() {
		super(150);
	}

	@Override
	public String toString() {
		return "Tank";
	}
}

class Dropship extends GroundUnit implements Repairable {

	Dropship() {
		super(125);
	}

	@Override
	public String toString() {
		return "Dropship";
	}
}

class SCV extends GroundUnit implements Repairable {

	SCV() {
		super(60);
	}
	
	void repair(Repairable r) {
		if (r instanceof Unit) {
			Unit u = (Unit) r;
			u.hp = u.MAX;
			System.out.println(u + " 수리 완료");
		}
	}

	@Override
	public String toString() {
		return "SCV";
	}
	
	
}
