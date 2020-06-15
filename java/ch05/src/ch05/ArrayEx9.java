package ch05;

public class ArrayEx9 {

	public static void main(String[] args) {
		int[] score1 = {90, 80, 70};
		int[] score2 = new int[5];
		
		for (int i = 0; i < score1.length; i++) {
			score2[i] = score1[i];
			System.out.print(score2[i] + " ");
		}
		System.out.println();
	
		for (int i : score2) {
			System.out.print(i + " ");
		}
	}

}
