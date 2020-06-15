package ch07;

public class FinalValueEx {

	public static void main(String[] args) {
		FinalValue f1 = new FinalValue();
//		f1.NUM = 200; // 상수라 변경 불가
		System.out.println(f1.getNUM());
		FinalValue f2 = new FinalValue(120);
		System.out.println(f2.getNUM());
	}

}
class FinalValue {
	final int NUM;		// 명시적 초기화 안함.
	
	FinalValue() {
		this(100);
	}
	FinalValue(int num) {	
		NUM = num;		// 생성자에서 초기화 한번 가능(명시적 초기화 안했기때문에)
	}
	
	public int getNUM() {
		return NUM;
	}
	
}
