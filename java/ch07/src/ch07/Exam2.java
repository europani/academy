package ch07;

public class Exam2 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		SmartPhone1 sp = new SmartPhone1();

		b.buy(tv);
		b.buy(com);
		b.buy(sp);
		System.out.println("������ �ܾ� : " + b.money);
		System.out.println("������ ��������Ʈ : " + b.point);
		System.out.println("====== ���� ��ǰ ���� ======");
		b.summary();
	}

}

class Product {
	int price, point;

	Product(int price) {
		this.price = price;
		point = (int) (price * 0.1);
	}
}

class Tv extends Product {
	public Tv() {
		super(100);
	}

	@Override
	public String toString() {
		return "Tv";
	}

}

class Computer extends Product {
	public Computer() {
		super(200);
	}

	@Override
	public String toString() {
		return "Computer";
	}
}

class SmartPhone1 extends Product {
	public SmartPhone1() {
		super(150);
	}

	@Override
	public String toString() {
		return "Smartphone";
	}
}

class Buyer {
	int money = 500;
	int point;
	Product[] cart = new Product[3];
	int cnt;

	void buy(Product p) {
		money -= p.price;
		point += p.point;
		cart[cnt++] = p;
		System.out.println(p + " ������");
	}

	void summary() {
		int total = 0;
		String list = "";
		for (Product p : cart) {
			if (p == null) {
				break;
			}
			System.out.print(p + " - ");
			System.out.println("���� : " + p.price + ", ����Ʈ : " + p.point);
			total += p.price;
			list += p + ", ";
		}
		System.out.println("�Ѱ��� : " + total);
		System.out.println("��� : " + list);
	}
}
