package ch06;

public class ConstructorEx2 {

	public static void main(String[] args) {
		Car c1 = new Car("blue", 1234);
		Car c2 = new Car("red");
		Car c3 = new Car(1234);
		Car c4 = new Car(c3);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		
				
	}

}

class Car {
	String color;
	int number;

	Car(String c, int n) {
		color = c; number = n;
	}
	Car(String c) {
		color = c; number = 1;
	}
	Car(int n) {
		color = "white"; number = n;
	}
	Car(Car c) {
		color = c.color; number = c.number;
	}
	
	public String toString() {
		return color + ", " + number;
	}
}
