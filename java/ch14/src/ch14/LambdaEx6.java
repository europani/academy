package ch14;

import java.util.function.*;

// Consumer 인터페이스

public class LambdaEx6 {

	public static void main(String[] args) {
		Consumer<String> c1 = (t) -> System.out.println(t+8);		// Consumer<T> c = new Consumer() { void accept(T t) {sysout(t+8); }};
		c1.accept("Java");
		BiConsumer<String, String> c2 = (t, u) -> System.out.println(t+u);
		c2.accept("Java", "8.0이후");
		DoubleConsumer c3 = d -> System.out.println("Java" + d);
		c3.accept(8.0);
		ObjIntConsumer<String> c4 = (t, i) -> System.out.println(t+i);
		c4.accept("Java", 8);
		IntConsumer c5 = x -> {
			int sum = 0;
			for (int i = 1; i <= x; i++) {
				sum += i;
			}
			System.out.println("1~" + x + "까지의 합 : " + sum);
		};
		c5.accept(10);
		c5.accept(100);
	}

}
