package ch14;

import java.util.function.*;

// Supplier 인터페이스

public class LambdaEx7 {

	public static void main(String[] args) {
		
//		Supplier<String> s1 = new Supplier() {
//			String get() {
//				return "java";
//		};
		
		Supplier<String> s1 = () -> "java";
		System.out.println(s1.get());
		
		IntSupplier s2 = () -> (int) (Math.random()*6 +1);
		System.out.println(s2.getAsInt());
		
	}

}
