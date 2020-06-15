package ch06;

public class MethodEx1 {

	public static void main(String[] args) {
		Method1 m1 = new Method1();
		int i1 = m1.add(10, 20);
		long i2 = m1.add(10, 20);
		double i3 = m1.add(10, 20);
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
	}

}

class Method1 {
	int add(int a, int b) {
		return a+b;
	}
	long add(long a, long b) {
		return a+b;
	}
	double add(double a, double b) {
		return a+b;
	}
}
