package ch13;

public class ThreadEx7 {

	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread son = new Thread(atm, "SON");
		Thread daughter = new Thread(atm, "DAUGHTER");
		son.start();
		daughter.start();
	}

}

class ATM implements Runnable {
	private int money = 100000;

	@Override
	public void run() {

			while (true) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (money <= 0) {
					break;
				}
				withdraw();
			}
	}

	synchronized void withdraw() {
		if (money <= 0) {
			return;
		}
		money -= 10000;
		System.out.println(Thread.currentThread().getName() + "Ãâ±Ý. ÀÜ¾× : " + money);

	}
}
