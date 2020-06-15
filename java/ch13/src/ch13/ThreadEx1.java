package ch13;

public class ThreadEx1 {

	public static void main(String[] args) {
		System.out.println("main 쓰레드 시작");
		Thread1 t1 = new Thread1("First");
		Thread1 t2 = new Thread1("Second");
		t1.start();
		t2.start();
		
		System.out.println("main 쓰레드 종료");
	}
}

class Thread1 extends Thread {
	
	public Thread1(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i + "=" + getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
