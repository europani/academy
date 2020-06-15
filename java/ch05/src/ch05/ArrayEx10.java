package ch05;

public class ArrayEx10 {

	public static void main(String[] args) {
		int[] score1 = {90, 80, 70};
		int[] score2 = new int[5];
		
		System.arraycopy(score1, 0, score2, 0, score1.length);
		for (int i : score2) {
			System.out.print(i + " ");
		}
	}

}
