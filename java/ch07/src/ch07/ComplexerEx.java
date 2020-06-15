package ch07;

public class ComplexerEx {

	public static void main(String[] args) {
		Complexer com = new Complexer();
		System.out.println("기본 잉크량 : " + Printerable.INK);
		System.out.println("FAX번호 : " + Faxable.FAX_NO);
		com.print();
		com.scan();
		com.send("010-456123");
		com.receive("010-456123");
		
		System.out.println();
		if (com instanceof Complexer) {
			System.out.println("com 참조변수의 객체는 Complexer 객체임");
		}
		if (com instanceof Complexarable) {
			System.out.println("com 참조변수의 객체는 Complexarable 객체임");
			Complexarable ca = com;
			ca.print();  ca.scan();  ca.receive("02-1234");  ca.send("02-1234");
		}
		if (com instanceof Printerable) {
			System.out.println("com 참조변수의 객체는 Printerable 객체임");
			Printerable pa = com;
			System.out.println(pa.INK);
		}
		if (com instanceof Scannerable) {
			System.out.println("com 참조변수의 객체는 Complexer 객체임");
			Scannerable sa = com;
			sa.scan();
		}
		if (com instanceof Faxable) {
			System.out.println("com 참조변수의 객체는 Faxable 객체임");
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
		System.out.println("종이에 출력합니다. 남은 잉크량 : " + --ink);
	}

	@Override
	public void scan() {
		System.out.println("이미지를 스캔합니다.");
	}

	@Override
	public void send(String tel) {
		System.out.println(FAX_NO + "에서 " + tel + "로 FAX발신");
	}

	@Override
	public void receive(String tel) {
		System.out.println(tel + "에서 " + FAX_NO + "로 FAX수신");
	}

}
