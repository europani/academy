package ch12;

public class asdf {

	public static void main(String[] args) {
		int result1 = Util00.sum("10", "20");
		System.out.println(result1);
		
		Pool00<Double> p1 = new Pool00<Double>(20.0);
		Double value = p1.get();
		System.out.println(value);
	}

}

class Pool00<T extends Double> {
	T v;
	
	Pool00(T n) {
		v = n;
	}
	void set(T n) {
		v = n;
	}
	T get( ) {
		return v;
	}
}

class Util00 {
	
	public static <T extends String> int sum(T t1, T t2) {
		String v1 = t1;
		String v2 = t2;
		return Integer.parseInt(v1) + Integer.parseInt(v2);
				
	}
}
