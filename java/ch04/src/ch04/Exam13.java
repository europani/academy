package ch04;

import java.util.Scanner;

public class Exam13 {

	public static void main(String[] args) {
		System.out.println("¼ıÀÚ¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int tmp = num;
		int result = 0;
		
		while (tmp != 0) {
			result *= 10;
			result += tmp%10;
			tmp = tmp/10;
		}
		if (num == result) {
			System.out.println("ÁÂ¿ì´ëÄª¼ö");
		} else {
			System.out.println("ÁÂ¿ì´ëÄª¼ö°¡ ¾Æ´Ô");
		}
		
	}

}
