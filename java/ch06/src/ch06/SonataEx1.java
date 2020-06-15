package ch06;

public class SonataEx1 {

	public static void main(String[] args) {
		System.out.println("자동차 크기 : " + Sonata.width + ", " + Sonata.height);

		Sonata car1 = new Sonata();
		car1.color = "white";
		car1.number = 1234;
		System.out.println("car1 : " + car1); // car1.toString() 실행

		Sonata car2 = new Sonata();
		car2.color = "black";
		car2.number = 2345;
		System.out.println("car2 : " + car2);

		car1.height = 100;
		car2.width = 100;

		
		System.out.println(car1.height + ", " + car1.width);
		System.out.println(Sonata.height + ", " + Sonata.width);
		

	}

}

class Sonata {
	String color;
	int number;
	static int width = 300;
	static int height = 200;

	public String toString() {
		return color + " : " + number + " (" + width + ", " + height + ")";
	}

}
