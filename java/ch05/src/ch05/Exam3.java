package ch05;

//1~10 중 중복되지 않는 3자리 숫자를 임의로 생성.
public class Exam3 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] num = new int[3];
		
		for (int i = 0; i < 500; i++) {			// 셔플
			int a = (int) (Math.random()*9);
			int b = (int) (Math.random()*9);
			
			int tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
			
		}
		
		for (int i = 0; i < num.length; i++) {
			num[i] = arr[i];
			System.out.println(num[i]);
		}
	}

}
