package ch12;

public class GenericsEx5 {

	public static void main(String[] args) {
		int result1 = Util05.compare(10, 20);
		int result2 = Util05.compare(4.5, 3);
		System.out.println(result1);
		System.out.println(result2);
		
		Pool05<Integer> p1 = new Pool05<Integer>(20);
		Pool05<Double> p2 = new Pool05<Double>(20.0);
		Pool05<Byte> p3 = new Pool05<Byte>((byte) 1);
//		Pool05<String> p4 = new Pool05<String>("s");
		
		int value = p1.get();
		System.out.println(value);
		System.out.println(p2.get());
	}

}

class Pool05<T extends Number> {
	T v;
	
	Pool05(T n) {
		v = n;
	}
	void set(T n) {
		v = n;
	}
	T get( ) {
		return v;
	}
}

class Util05 {
	
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
				
	}
}
