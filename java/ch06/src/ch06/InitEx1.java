package ch06;

public class InitEx1 {

	static int cv;
	int iv;

	InitEx1() {
		System.out.println("5. 생성자 호출");
	}
	
	static {	//클래스 초기화블럭
		cv = (int) (Math.random()*100);
		System.out.println("1. 클래스 초기화 블럭");
		// iv = (int) (Math.random()*100);
	}
	{			//인스턴스 초기화블럭
		iv = (int) (Math.random()*100);
		System.out.println("4. 인스턴스 초기화 블럭");
	}
	
	public static void main(String[] args) {
		System.out.println("2. main메소드 실행");
		System.out.println("3-1. main init1 객체 생성");
		InitEx1 init1 = new InitEx1();
		System.out.println("3-2. main init2 객체 생성");
		InitEx1 init2 = new InitEx1();
		
	}

}
