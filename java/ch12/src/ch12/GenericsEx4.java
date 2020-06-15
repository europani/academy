package ch12;

public class GenericsEx4 {

	public static void main(String[] args) {
		Pool04<Integer> box1 = Util04.staticMethod(100);
		int intValue = box1.get();
		System.out.println(intValue);

		Util04 u = new Util04();
		Pool04<String> box2 = u.instanceMethod1("홍길동");
		String stringValue = box2.get();
		System.out.println(stringValue);

		System.out.println(u.instanceMethod2("김자바"));
		System.out.println(u.instanceMethod2(new Mycar()));

	}

}

class Pool04<T> {
	private T t;

	T get() {
		return t;
	}

	void set(T t) {
		this.t = t;
	}
}

class Util04 {		// 지네릭 메서드 구현
	public static <T> Pool04<T> staticMethod(T t) {
		Pool04<T> box = new Pool04<T>();
		box.set(t);
		return box;

	}

	public <T> Pool04<T> instanceMethod1(T t) {
		Pool04<T> box = new Pool04<T>();
		box.set(t);
		return box;
	}

	public <T> String instanceMethod2(T t) {
		return t.toString();

	}
}

class Mycar {
	@Override
	public String toString() {
		return "Mycar";
	}
}
