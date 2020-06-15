package ch05;

//command 라인에서 숫자를 입력받아 소수인지 판별하시오.

public class Exam12 {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("cmd라인에  숫자를 입력해주세요.");
			return;
		}
		int num = Integer.parseInt(args[0]);
		int cnt = 0;
		
		for (int i = 1; i <= num; i++) {
			if (num % i==0) {
				cnt++;
			}
		}
		if (cnt == 2) {
			System.out.println(num + "은 소수입니다.");
		} else {
			System.out.println(num + "은 소수가 아닙니다.");
		}

		
	}
}
