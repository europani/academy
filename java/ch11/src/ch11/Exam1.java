package ch11;

import java.util.*;

/*
  	홀수개의 숫자를 입력받아 숫자의 평균과 중간값 출력
  	10 40 30 60 30
  	평균값 : ...
  	중간값 : 30
*/

public class Exam1 {

	public static void main(String[] args) {
		System.out.println("홀수개의 숫자를 입력하세요");
		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			int input = sc.nextInt();
			list.add(input);
			sum += input;
			
			if (list.size() % 2 == 1) {
				System.out.println("end?(y/n)");
				String y = sc.next();
				if (y.equals("y")) {
					break;
				}
			}
		}
		Collections.sort(list);
		System.out.println(list);
		System.out.println("평균값 : " + (double) sum / list.size());
		System.out.println("중간값 : " + list.get(list.size() / 2));
	}

}
