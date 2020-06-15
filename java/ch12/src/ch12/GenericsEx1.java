package ch12;

public class GenericsEx1 {

	public static void main(String[] args) {
		Pool01 gen = new Pool01();
		gen.set("±×·»Á®");
		String name = (String) gen.get();
		System.out.println(name);
		gen.set(new Myclass01());
		Myclass01 g = (Myclass01) gen.get();
		System.out.println(g);
		
	}

}

class Myclass01 {
	@Override
	public String toString() {
		return "Myclass01";
	}
}

class Pool01 {
	private Object object;

	void set(Object object) {
		this.object = object;
	}

	public Object get() {
		return object;
	}
}
