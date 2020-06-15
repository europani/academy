package ch08;

public class AutoCloseEx {

	public static void main(String[] args) {
		try (AutocloseableUse cr = new AutocloseableUse()) {
			System.out.println("process");
		}
		System.out.println();
	
	}

}

class AutocloseableUse implements AutoCloseable {
	
	public void close() {
		System.out.println("close() »£√‚");
	}
}
