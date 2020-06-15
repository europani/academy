package ch05;

// command 라인에서 숫자로 이루어진 문자를 두개 받아 공약수를 구해라.
public class Exam8 {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("cmd라인에 두개의 파라미터를 입력하세요.");
			System.out.println("java ch06.Exam8");
			return;
		}
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int min = (num1 > num2)? num2 : num1;
		
		System.out.println(num1 + ", " + num2 + "의 공약수 : ");
		for (int i = 1; i <= min; i++) {
			if (num1 % i == 0 && num2 % i ==0) {
				System.out.print(i + ", ");
			}
		}
	}

}
