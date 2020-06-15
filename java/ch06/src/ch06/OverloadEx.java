package ch06;

public class OverloadEx {

	public static void main(String[] args) {
		Math4 m = new Math4(); 
		System.out.println(m.add(10, 10));
		System.out.println(m.add(10L, 10));
		System.out.println(m.add(10, 10L));
		System.out.println(m.add(10L, 10L));
	}

}

class Math4 {
	int add(int a, int b) {
		System.out.print("int int 메서드 결과 : ");
		return a+b;
	}
//	int add(int x, int y) {
//		System.out.print("int int 메서드 결과 : ");
//		return x+y;
//	}
	long add(long a, int b) {
		System.out.print("long int 메서드 결과 : ");
		return a+b;
	}
	long add(int a, long b) {
		System.out.print("int long 메서드 결과 : ");
		return a+b;
	}
	long add(long a, long b) {
		System.out.print("long long 메서드 결과 : ");
		return a+b;
	}
	
}
