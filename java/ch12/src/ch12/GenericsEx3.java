package ch12;

public class GenericsEx3 {

	public static void main(String[] args) {
		Product<Tv, String> product1 = new Product<Tv, String>();
		product1.setKind(new Tv());
		product1.setModel("½º¸¶Æ®Tv");
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		Product<Car, String> product2 = new Product<Car, String>();
		product2.setKind(new Car());
		product2.setModel("µðÁ©");
		Car car = product2.getKind();
		String carModel = product2.getModel();
	}

}

class Product<T, M> {
	private T kind;
	private M model;
	
	T getKind() {
		return this.kind;
	}
	M getModel() {
		return this.model;
	}
	
	public void setKind(T kind) {
		this.kind = kind;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
	
}

class Car{}
class Tv{}