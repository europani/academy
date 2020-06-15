package ch09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerEx3 {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("score.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int cnt = 0;
		int totalSum = 0;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();		//  홍길동, 4.5, 3.8, 4.2
			Scanner sc2 = new Scanner(line).useDelimiter(",");
			double sum = 0;
			int i = 0;
			String name = sc2.next();			// 홍길동
			System.out.print(name.trim() + " : ");

			while (sc2.hasNextDouble()) {
				double score = sc2.nextDouble();	// 4.5
				sum += score;
				System.out.print(score + ", ");
				i++;
			}
			System.out.println("sum = " + sum + ", avg = " + (int)(sum/i*100)/100.0);
			totalSum += sum;
			cnt++;
		}
		System.out.println("인원수 : " + cnt);
		System.out.println("합계 : " + (double)totalSum);
	}

}
