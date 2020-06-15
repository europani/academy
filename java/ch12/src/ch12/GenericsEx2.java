package ch12;

public class GenericsEx2 {

	public static void main(String[] args) {
		Pool02<String> box1 = new Pool02<String>();
		box1.set("hello");
		String str = box1.get();
		System.out.println(str);
		Pool02<Integer> box2 = new Pool02<Integer>();		// Generic 지정 생략 -> Object 타입
		box2.set(6);
		int value = box2.get();
		System.out.println(value);
		
	}

}

class Pool02<T> {
	private T t;

	void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}