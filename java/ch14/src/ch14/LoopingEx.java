package ch14;

import java.util.Arrays;

public class LoopingEx {

	public static void main(String[] args) {
		int[] intArr = {1, 2, 3, 4, 5};
		System.out.println("[peek()를 마지막에 호출한 경우]");
		Arrays.stream(intArr).filter(a -> a%2 ==0).peek(n -> System.out.println(n)); // 실행 X

		System.out.println("[최종처리 메서드를 마지막에 호출한 경우]");
		int total = Arrays.stream(intArr).filter(a -> a%2 ==0).peek(n -> System.out.println(n))
				.sum();
		System.out.println("총합 : " + total);
		
		System.out.println("[forEach()를 마지막에 호출한 경우]");
		Arrays.stream(intArr).filter(a -> a%2 ==0).forEach(a -> System.out.println(a));
		
		
	}

}
