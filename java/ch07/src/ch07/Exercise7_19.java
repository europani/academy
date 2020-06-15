package ch07;

public class Exercise7_19 {

	public static void main(String[] args) {
		Buyer1 b = new Buyer1();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}

}

class Buyer1 {
	int money = 1000;
	Product[] cart = new Product[3]; 
	int i = 0;

	void buy(Product p) {
		if (money > p.price) {
			money -= p.price;
			add(p);
		} else {
			return;
		}
	}

	void add(Product p) {
		if (i >= cart.length) {
			Product[] newCart = null;
			newCart = new Product[cart.length*2];
			System.arraycopy(cart, 0, newCart, 0, cart.length);
			cart = newCart;
		} 
			cart[i] = p;
			i++;
		
	}

	void summary() {
		money = 1000;
		int totalPrice = 0;
		for (int i = 0; i < cart.length; i++) {
			System.out.print(cart[i] + ", ");
			totalPrice += cart[i].price;
			money -= cart[i].price;
		}
		System.out.println("\n총가격 : " + totalPrice);
		System.out.println("남은돈 : " + money);
	}

	
	
}

class Product1 {
	int price; // 제품의 가격

	Product1(int price) {
		this.price = price;
	}
}

class Tv1 extends Product1 {
	Tv1() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

class Computer1 extends Product1 {
	Computer1() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}
}