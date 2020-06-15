package ch13;

public class ThreadEx3 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		System.out.println("높은 우선 순위 : " + Thread.MAX_PRIORITY);
		System.out.println("낮은 우선 순위 : " + Thread.MIN_PRIORITY);
		System.out.println("기본 우선 순위 : " + Thread.NORM_PRIORITY);
		ThreadProperty t1 = new ThreadProperty("first", 5);
		ThreadProperty t2 = new ThreadProperty("second", 1);
		ThreadProperty t3 = new ThreadProperty("third", 10);
		t1.start();
		t2.start();
		t3.start();
	}

}

class ThreadProperty extends Thread  {
	public ThreadProperty(String name, int p) {
		super(name);
		setPriority(p);
	}
	
	@Override
	public void run() {
		try {
			sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 50; i++) {
			System.out.println("***" + this);
		}
	}
}
