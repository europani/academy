package ch05;
 
// command 라인에서 숫자를 입력받아 숫자의 약수를 출력

public class Exam7 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		System.out.print(num + "의 약수 : ");
		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				System.out.print(i + ", "); 
		}
		
	}

}
