package ch09;

import java.util.Random;

public class RandomEx1 {

	public static void main(String[] args) {
		Random rand = new Random();
		rand.setSeed(1);
		Random rand2 = new Random();
		rand2.setSeed(System.currentTimeMillis());
		
		System.out.println("rand==>");
		for (int i = 0; i <5; i++) {
			System.out.println(i + ":" + rand.nextInt(100));	// 0~99 int³­¼ö
		}
		System.out.println();
		
		System.out.println("rand2==>");
		for (int i = 0; i <5; i++) {
			System.out.println(i + ":" + rand2.nextInt(100));
		}
		
	}

}
