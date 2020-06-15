package ch14;

public class LambdaEx4 {

	public static void main(String[] args) {
		LambdaInterface4 f4 = (x,y) -> {
			return x*y;
		};
		System.out.println("두수의 곱 : " + f4.method(2, 5));
		
		f4 = (x,y) -> x+y;
		System.out.println("두수의 합 : " + f4.method(2, 5));
		f4 = (x,y) -> x/y;
		System.out.println("두수의 몫 : " + f4.method(2, 5));
		f4 = (x,y) -> x%y;
		System.out.println("두수의 나머지 : " + f4.method(2, 5));
		f4 = (x,y) -> sum(x,y);
		System.out.println("두수의 합 : " + f4.method(2, 5));
		f4 = (x,y) -> (x>y)? x : y;
		System.out.println("두수 중 큰수 : " + f4.method(2, 5));
		f4 = (x,y) -> (x<y)? x : y;
		System.out.println("두수 중 작은수 : " + f4.method(2, 5));
	}

	public static int sum(int x, int y) {
		return x+y;
	}

}
@FunctionalInterface
interface LambdaInterface4 {
	int method(int x, int y);
}