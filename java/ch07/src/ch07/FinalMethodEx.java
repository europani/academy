package ch07;

public class FinalMethodEx {
	final void finalMethod() {	//오버라이딩 불가 메서드
		System.out.println("finalMethod 오버라이딩 불가");
	}

}
class SubMethod extends FinalMethodEx {
	/*
	 * void finalMethod() { System.out.println("finalmethod 오버라이딩 불가"); }
	 */
}
