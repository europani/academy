package ch05;

import java.util.Arrays;

public class ArrayEx3 {

	public static void main(String[] args) {
		int[] balls = new int[45];
		int[] lotto = new int[6];
		int tmp = 0;
		
		
		for (int i = 0; i < balls.length; i++) {
			balls[i] = i+1;
		}
		
		for (int i = 0; i < 1000; i++) {
			int a = (int)((Math.random()*45));
			int b = (int)((Math.random()*45));
			
			tmp = balls[a];
			balls[a] = balls[b];
			balls[b] = tmp;
		}
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = balls[i];
		}
		
		// sort(선택정렬) - 앞에서부터
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i+1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
		// sort(버블정렬) - 뒤에서부터
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < lotto.length-1-i; j++) {
				if (lotto[j] > lotto[j+1]) {
					tmp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = tmp;
				}
			}
		}
		for (int i : lotto) {
			System.out.print(i + " ");
		}
		
		//Array 내장함수 이용
		Arrays.sort(lotto);
		for(int i : lotto) {
			System.out.print(i + " ");
		}
		
	}

}
