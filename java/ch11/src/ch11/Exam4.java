package ch11;

import java.util.*;

public class Exam4 {

	public static void main(String[] args) {
		System.out.println("Lotto ¹øÈ£ ======");
		Set<Integer> ball = new TreeSet<Integer>();
		while (ball.size() < 6) {
			ball.add((int) ((Math.random ()*45)+1));
		}
		System.out.println(ball);
		
	}

}
