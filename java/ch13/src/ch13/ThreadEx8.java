package ch13;

public class ThreadEx8 {
	public static void main(String[] args) throws InterruptedException {
		SumThread t1 = new SumThread(1, 100);
		SumThread t2 = new SumThread(101, 200);
		SumThread t3 = new SumThread(201, 300);
		SumThread t4 = new SumThread(301, 400);
		SumThread t5 = new SumThread(401, 500);
		t1.start(); t2.start(); t3.start(); t4.start(); t5.start();
		
		t1.join(); 	t2.join(); 	t3.join(); 	t4.join(); 	t5.join();
		System.out.println("1에서 500까지의 합 : " + (t1.sum+t2.sum+t3.sum+t4.sum+t5.sum));
	}
}

class SumThread extends Thread {
	int start;
	int end;
	int sum;
	
	public SumThread(int s, int e) {
		this.start = s;
		this.end = e;
	}
	
	@Override
	public void run() {
		for (int i = start; i <= end; i++) {
			sum +=i;
		}
		System.out.printf("%d에서 %d까지의 합 : %d%n", start, end, sum);
	}
}