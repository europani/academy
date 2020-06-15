package ch05;

// 1~10 랜덤수 10개 저장하고 배열에 저장된 수만큼 * 출력
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
