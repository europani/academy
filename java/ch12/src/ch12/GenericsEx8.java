package ch12;

public class GenericsEx8 {

	public static void main(String[] args) {
		Food food = new Food();
		Fruit fruit = new Fruit();
		Drink drink = new Drink();
		Apple apple = new Apple();
		Peach peach = new Peach();
		Coke coke = new Coke();
		Cider cider = new Cider();
		Pool08<? super Apple> g1 = new Pool08<Fruit>(fruit);
		System.out.println(g1.get());
		Pool08<? super Apple> g2 = new Pool08<Food>(food);
		System.out.println(g2.get());
		Pool08<? super Apple> g3 = new Pool08<Apple>(apple);
		System.out.println(g3.get());
//		Pool08<? extends Apple> g4 = new Pool08<Cider>(cider);
//		Pool08<? extends Apple> g5 = new Pool08<Drink>(drink);
		Pool08<? extends Drink> g6 = new Pool08<Drink>(drink);
		System.out.println(g6.get());
		Pool08<? extends Drink> g7 = new Pool08<Cider>(cider);
		System.out.println(g7.get());
//		Pool08<? extends Drink> g8 = new Pool08<Food>(food);
//		Pool08<? extends Drink> g9 = new Pool08<Apple>(apple);
				
	}

}

class Pool08<T> {
	T v;

	public Pool08(T n) {
		v = n;
	}

	void set(T n) {
		v = n;
	}

	T get() {
		return v;
	}
}

class Food {
	String name = "Food";

	String getMsg() {
		return name;
	}
}

class Fruit extends Food {
	String name = "Fruit";

	String getMsg() {
		return name;
	}
}

class Drink extends Food {
	String name = "Drink";

	String getMsg() {
		return name;
	}
}

class Apple extends Fruit {
	String name = "Apple";

	String getMsg() {
		return name;
	}
}

class Peach extends Fruit {
	String name = "Peach";

	String getMsg() {
		return name;
	}
}

class Coke extends Drink {
	String name = "Coke";

	String getMsg() {
		return name;
	}
}

class Cider extends Drink {
	String name = "Cider";

	String getMsg() {
		return name;
	}
}
