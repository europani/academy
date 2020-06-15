package ch04;

public class Exam7 {

	public static void main(String[] args) {
		int sum1 = 0;
		int sum2 = 0;
		
		for (int i = 1; i <= 100; i++) {
			if (i%2==0 || i%3==0) {
				sum1 += i;
			} else
				sum2 += i;	
		}
		System.out.println("2 or 3의 배수 들의 합 : " + sum1);
		System.out.println("2 or 3의 배수 가 아닌 것들의 합 : " + sum2);
	}

}
