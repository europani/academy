package ch14;

public class Exam1 {

	public static void main(String[] args) {
		LambdaEx01 f = i -> {
			int sum = 0;
			for (int j = 1; j <= i; j++) {
				sum += j;
			}
			System.out.println(sum);
		};

		f.method(10);
		f.method(100);
	}

}

@FunctionalInterface
interface LambdaEx01 {
	void method(int i);
}
