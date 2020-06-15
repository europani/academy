package ch13;

public class ThreadEx6 {

	public static void main(String[] args) {
		Printer ptr = new Printer();
//		Thread t1 = new PrintThread3(ptr, 'A');
//		Thread t2 = new PrintThread3(ptr, 'B');
//		Thread t3 = new PrintThread3(ptr, 'C');
		Thread t1 = new PrintThread3(new Printer(), 'A');
		Thread t2 = new PrintThread3(new Printer(), 'B');
		Thread t3 = new PrintThread3(new Printer(), 'C');
		t1.start();
		t2.start();
		t3.start();
		
	}

}
class Printer {
	public synchronized void printChar(char ch) {	// 동기화 메서드
		for (int i = 0; i < 80; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}

class PrintThread3 extends Thread {
	Printer ptr;
	char ch;
	
	public PrintThread3(Printer ptr, char ch) {
		this.ptr = ptr;
		this.ch = ch;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			ptr.printChar(ch);
		}
	}
}