package ch13;

public class ThreadEx4 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new DaemonThread();
		Thread t2 = new DaemonThread();
		t1.setDaemon(true);
		t2.setDaemon(true);
		t1.start();
		t2.start();
		Thread.sleep(2000);
		System.out.println("main 쓰레드 종료");
	}

}

class DaemonThread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println(getName());
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
