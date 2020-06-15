package Ch03;

import java.util.Scanner;

public class Exam7 {

	public static void main(String[] args) {
		
		System.out.println("점수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		System.out.println((score>=90)? "A학점" : (score>=80)? "B학점" : (score>=70)? "C학점" : (score>=60)? "D학점" : "F학점");
	}

}
