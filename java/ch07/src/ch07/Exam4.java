package ch07;

public class Exam4 {

	public static void main(String[] args) {
		Apple apple = new Apple(1000, 10.5);
		System.out.println("��� ���� : " + apple.price);
		System.out.println("��� �絵 : " + apple.brix);
		Peach peach = new Peach(1000, 13.5);
		Coke coke = new Coke(500, 500);
		Cider cider = new Cider(1500, 1000);
		Biscuit biscuit = new Biscuit(10000, 500);
		Cookie cookie = new Cookie(500, 5000);
		
		Buyer2 b = new Buyer2();
		b.buy(apple);		b.buy(peach);
		b.buy(coke);		b.buy(cider);
		b.buy(biscuit);		b.buy(cookie);
		System.out.println("�� �ܾ� : " + b.money);
		System.out.println("�� ����Ʈ : " + b.point);
		System.out.println();
		b.summary();
	}

}

class Food {
	int price, point;

	Food(int price) {
		this.price = price;
		point = (int) (price * 0.1);
	}
}

class Fruit extends Food {
	double brix;

	Fruit(int price, double brix) {
		super(price);
		this.brix = brix;
	}

}

class Drink extends Food {
	int ml;

	Drink(int price, int ml) {
		super(price);
		this.ml = ml;
	}
}

class Snack extends Food {
	int gram;

	Snack(int price, int gram) {
		super(price);
		this.gram = gram;
	}
}

class Apple extends Fruit {
	Apple(int price, double brix) {
		super(price, brix);
	}

	@Override
	public String toString() {
		return "Apple";
	}

}

class Peach extends Fruit {
	public Peach(int price, double brix) {
		super(price, brix);
	}

	@Override
	public String toString() {
		return "Peach";
	}

}

class Coke extends Drink {
	Coke(int price, int ml) {
		super(price, ml);
		this.ml = ml;
	}

	@Override
	public String toString() {
		return "Coke";
	}

}

class Cider extends Drink {
	Cider(int price, int ml) {
		super(price, ml);
	}

	@Override
	public String toString() {
		return "Cider";
	}

}

class Biscuit extends Snack {
	Biscuit(int price, int gram) {
		super(price, gram);
	}

	@Override
	public String toString() {
		return "Biscuit";
	}

}

class Cookie extends Snack {
	Cookie(int price, int gram) {
		super(price, gram);
	}

	@Override
	public String toString() {
		return "Cookie";
	}

}

class Buyer2 {
	int money = 10000;
	int point;
	Food[] cart = new Food[20];
	int cnt;

	void buy(Food f) {
		if (money - f.price < 0) {
			System.out.println(f+ "���Ž� �ܾ׺���");
			return;
		} else {
			money -= f.price;
			point += f.point;
			System.out.println(f + "���� - " + f.price);
			cart[cnt++] = f;
		}
	}

	void summary() {
		int total = 0;
		int gotPoint = 0;
		
		int fTotal = 0;		String fList = "";		int fcnt = 0;
		int dTotal = 0;		String dList = "";		int dcnt = 0;
		int sTotal = 0;		String sList = "";		int scnt = 0;
		
		String list = "";
		for (int i = 0; i < cart.length; i++) {
			if (cart[i] == null) {
				break;
			} else {
				list += cart[i] +  ", ";
				total += cart[i].price;
				gotPoint += cart[i].point;
				
				if (cart[i] instanceof Fruit) {
					fTotal += cart[i].price; 
					fList += cart[i] + ", ";
					fcnt++;
				}
				
				else if (cart[i] instanceof Drink) {
					dTotal += cart[i].price; 
					dList += cart[i] + ", ";
					dcnt++;
				}
				
				else {
					sTotal += cart[i].price; 
					sList += cart[i] + ", ";
					scnt++;
				}
			}
		}
		System.out.println("���Ÿ���Ʈ");
		System.out.println("[" + list + "]");
		System.out.println("�Ѱ��� : " + total + ", ��������Ʈ : " + gotPoint);
		
		System.out.println("Fruit �ѱݾ� : " + fTotal + ", ���ŰǼ� : " + fcnt + ", ��� : " + fList);
		System.out.println("Drink �ѱݾ� : " + dTotal + ", ���ŰǼ� : " + dcnt + ", ��� : " + dList);
		System.out.println("Snack �ѱݾ� : " + sTotal + ", ���ŰǼ� : " + scnt + ", ��� : " + sList);
		
		
	}

}