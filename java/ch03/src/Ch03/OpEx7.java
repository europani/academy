package Ch03;

import java.util.Scanner;

public class OpEx7 {

	public static void main(String[] args) {
		System.out.println("점수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		
		Double score = sc.nextDouble();
		String result = (score >=60)? "합격": "불합격";
		System.out.println(score + "점은 " + result + "입니다.");
		System.out.println(score + "점은 " +((score%2==0)? "짝수" : "홀수") + "입니다." );
	
		result = (score%2==1)? "홀수" : (score > 0)? "짝수" : "0";
		System.out.println(score + "점은 " + result + "입니다.");
		
		String r;
		if (score>=60) {
			r = "합격";
		} else {
			r = "불합격";
		}
		System.out.println(r);
	}

}
