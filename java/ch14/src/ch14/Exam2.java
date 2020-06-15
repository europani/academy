package ch14;

public class Exam2 {
	static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public static void main(String[] args) {
		System.out.println("두 수의 합 : " + calc((x, y) -> x + y, 5, 2));
		System.out.println("두 수의 곱 : " + calc((x, y) -> x * y, 5, 2));
		System.out.println("arr 배열 중 가장 큰수 : " + calc((x, y) -> (x>y)? x : y));
		System.out.println("arr 배열 중 가장 작은수 : " + calc((x, y) -> (x<y)? x : y));
		
		LambdaEx02 f = (x,y) -> (x>y)? x : y;	
		System.out.println("arr 배열 중 가장 큰수 : " + calc(f));
	}

	static int calc(LambdaEx02 f, int x, int y) {
		return f.method(x, y);
	}

	static int calc(LambdaEx02 f) {
		int result = arr[0];
		for (int i : arr) {
			result = f.method(result, i);
		}
		return result;
	}

}

@FunctionalInterface
interface LambdaEx02 {
	int method(int x, int y);
}
