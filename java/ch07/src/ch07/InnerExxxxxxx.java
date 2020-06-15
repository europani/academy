package ch07;

public class InnerExxxxxxx {

	public static void main(String[] args) {

		I i = new I() {
			@Override
			public void test() {
				System.out.println("\\\\\\\\\\\\\\");
			}
		};

		i.test();
		I i1 = new Ass();
		i1.test();
	}
}

interface I {
	void test();
}

class Ass implements I {

	@Override
	public void test() {
		System.out.println("******");
	}
}