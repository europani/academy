package ch06;

public class InitEx2 {
	
	public static void main(String[] args) {
		System.out.println("메인메소드 실행");
		Block b1 = new Block();
		Block b2 = new Block();
		Block b3 = new Block();
		Block b4 = new Block();
		Block b5 = new Block();
	}
}

class Block {
	
	static int cv = 5;
	int iv = 10;

	static { System.out.println("클래스 블럭 : " + cv); } // 스태틱 초기화 블럭
	{ System.out.println("인스턴스 블럭 : " + iv); } // 인스턴스 초기화 블럭

	Block() {
		System.out.println("생성자 실행");
	}
}


