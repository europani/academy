package ch05;

// 1~10 ������ 10�� �����ϰ� �迭�� ����� ����ŭ * ���
public class Exam2 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
			
		}
		for (int i : arr) {
			System.out.print(i + ":");
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
			}
		} 
			


}
