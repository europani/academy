package ch05;

public class Exam4 {

	public static void main(String[] args) {
		int[] num = new int[10];

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 100 + 1);
		}

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					int tmp = 0;
					tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
				}
			}
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length-1-i; j++) {
				if (num[j + 1] < num[j]) {
					int tmp = 0;
					tmp = num[j + 1];
					num[j + 1] = num[j];
					num[j] = tmp;
				}
			}
			System.out.print(num[i] + " ");
		}
	}
}
