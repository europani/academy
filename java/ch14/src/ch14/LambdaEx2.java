package ch14;

public class LambdaEx2 {

	public static void main(String[] args) {
		System.out.println("main 쓰레드 시작");
		Runnable r = () -> {
			int sum = 0;
			for (int i = 1; i <= 100; i++) {
				sum += i;
			}
			System.out.println("1~100 합1 : " + sum);
		};
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(() -> {
			int sum = 0;
			for (int i = 1; i <= 100; i++) {
				sum += i;
			}
			System.out.println("1~100 합2 : " + sum);
		});

		t1.start();
		t2.start();

	}

}

class Abc implements Runnable {

	@Override
	public void run() {
	}

}
