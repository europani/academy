package ch05;

import java.util.Scanner;

public class ArrayEx4 {

	public static void main(String[] args) {
		int[] binary = new int[32];
		System.out.println("2������ ��ȯȰ 10������ �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int divnum = num;
		int index = -1;
		
		while (divnum != 0) {
			index++;
			binary[index] = divnum%2;
			divnum /= 2;
		}
		
		System.out.print(num + "�� 2������ : ");
		for (int i = index; i >= 0; i--) {
			System.out.print(binary[i]);
		}
	}

}
