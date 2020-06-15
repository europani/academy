package ch14_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ListStreamEx3 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "신용권", "김자바", "람다식", "박병렬");
		
		Stream<String> stream = list.stream();
		stream.forEach(ListStreamEx3 :: print);
		System.out.println();
		
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(ListStreamEx3 :: print);
		

	}
	
	static void print(String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}

}
