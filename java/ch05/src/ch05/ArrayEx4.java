package ch05;

import java.util.Scanner;

public class ArrayEx4 {

	public static void main(String[] args) {
		int[] binary = new int[32];
		System.out.println("2진수로 변환활 10진수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int divnum = num;
		int index = -1;
		
		while (divnum != 0) {
			index++;
			binary[index] = divnum%2;
			divnum /= 2;
		}
		
		System.out.print(num + "의 2진수는 : ");
		for (int i = index; i >= 0; i--) {
			System.out.print(binary[i]);
		}
	}

}
