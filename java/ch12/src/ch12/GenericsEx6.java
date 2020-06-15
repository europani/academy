package ch12;

public class GenericsEx6 {

	public static void main(String[] args) {
		Generic1<String> t = new Generic1<String>();
		String[] ss = {"월매", "춘향", "향단"};
		t.set(ss);
		t.print();
		for (String s : t.get()) {
			System.out.println(s.trim());
		}
		System.out.println();
		
		Integer[] ii = {10, 20, 30};
		Generic1<Integer> t2 = new Generic1<Integer>();
		t2.set(ii);
		t2.print();
		for (Integer s : t2.get()) {
			System.out.println(s/10);
		}
		
	}

}

class Generic1<T> {
	T[] v;
	
	void set(T[] n) {
		v= n;
	}
	T[] get() {
		return v;
	}
	void print() {
		for (T s : v) {
			System.out.println(s+ ", ");
		}
		System.out.println();
	}
}
