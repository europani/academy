package ch13;

public class ThreadEx2 {

	public static void main(String[] args) {
		System.out.println("main 쓰레드 시작");
		Runnable r = new Runnable1();
		Thread t1 = new Thread(r, "first");
		Thread t2 = new Thread(r, "second");
		t1.start();
		t2.start();
	}
}

class Runnable1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i + "=" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
