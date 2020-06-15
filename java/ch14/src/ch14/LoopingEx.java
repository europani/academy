package ch14;

import java.util.Arrays;

public class LoopingEx {

	public static void main(String[] args) {
		int[] intArr = {1, 2, 3, 4, 5};
		System.out.println("[peek()�� �������� ȣ���� ���]");
		Arrays.stream(intArr).filter(a -> a%2 ==0).peek(n -> System.out.println(n)); // ���� X

		System.out.println("[����ó�� �޼��带 �������� ȣ���� ���]");
		int total = Arrays.stream(intArr).filter(a -> a%2 ==0).peek(n -> System.out.println(n))
				.sum();
		System.out.println("���� : " + total);
		
		System.out.println("[forEach()�� �������� ȣ���� ���]");
		Arrays.stream(intArr).filter(a -> a%2 ==0).forEach(a -> System.out.println(a));
		
		
	}

}
