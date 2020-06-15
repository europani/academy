package ch14;

@FunctionalInterface
interface LambdaInterface1 {
	void method();
}

public class LambdaEx1 {

	public static void main(String[] args) {
		LambdaInterface1 fi = new LambdaInterface1() {

			@Override
			public void method() {
				System.out.println("기존방식으로 코딩");
			}
		};
		fi.method();

		fi = () -> {
			System.out.println("method call1");
		};
		
		execute(fi);		// fi.method();
		execute(() -> System.out.println("method call1"));

		System.out.println("====================");
		fi = () -> {
			System.out.println("method call2");
		};
		fi.method();

		fi = () -> {
			System.out.println("method call3");
		};
		fi.method();

		fi = () -> System.out.println("method call4");
		fi.method();
		execute(() -> System.out.println("method call5"));

	}

	static void execute(LambdaInterface1 f) {
		f.method();
	}

}
