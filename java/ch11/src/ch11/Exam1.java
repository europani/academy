package ch11;

import java.util.*;

/*
  	Ȧ������ ���ڸ� �Է¹޾� ������ ��հ� �߰��� ���
  	10 40 30 60 30
  	��հ� : ...
  	�߰��� : 30
*/

public class Exam1 {

	public static void main(String[] args) {
		System.out.println("Ȧ������ ���ڸ� �Է��ϼ���");
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
		System.out.println("��հ� : " + (double) sum / list.size());
		System.out.println("�߰��� : " + list.get(list.size() / 2));
	}

}
