package ch13;

public class ThreadEx5 {

	public static void main(String[] args) {
		Thread t1 = new PrintThread('A');
		Thread t2 = new PrintThread('B');
		Thread t3 = new PrintThread('C');
		t1.start();
		t2.start();
		t3.start();
	}

}

class PrintThread extends Thread {
	char ch;
	
	public PrintThread(char ch) {
		this.ch = ch;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 80; j++) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
}
