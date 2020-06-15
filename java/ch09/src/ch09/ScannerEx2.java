package ch09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("data2.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sum = 0;
		int cnt = 0;
		
		while (sc.hasNextInt()) {
			sum += sc.nextInt();
			cnt++;
		}
		System.out.println(sum);
		System.out.println("average = " + (double)sum/cnt);
	}

}
