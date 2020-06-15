package ch05;

import java.util.Arrays;

public class ArrayEx11 {

	public static void main(String[] args) {
		int[] score1 = {90, 80, 70};
		int[] score2 = null;
		
		score2 = Arrays.copyOf(score1, 5);
		
		for (int i : score2) {
			System.out.print(i + " ");
		}
		System.out.println(Arrays.toString(score2));
	}

}
