package ch07;

public class ShapeEx1 {

	public static void main(String[] args) {
		Shape2[] shapes = new Shape2[2];
		shapes[0] = new Circle2(10);
		shapes[1] = new Rectangle2(5, 5);
		for (Shape2 s : shapes) {
			System.out.println(s);
		}
	}

}

abstract class Shape2 {
	String type;

	Shape2(String type) {
		this.type = type;
	}

	abstract double area();
	abstract double length();
}

class Circle2 extends Shape2 {
	int r;

	Circle2(int r) {
		super("원");
		this.r = r;
	}

	@Override
	double area() {
		return Math.PI * r * r;
	}

	@Override
	double length() {
		return Math.PI * r * 2;
	}

	@Override
	public String toString() {
		return "Circle [r=" + r + ", type=" + type + ", 넓이:" + area() + ", 둘레:" + length() + "]";
	}

}

class Rectangle2 extends Shape2 {
	int width, height;

	Rectangle2(int width, int height) {
		super("사각형");
		this.width = width;
		this.height = height;
	}

	@Override
	double area() {
		return width * height;
	}

	@Override
	double length() {
		return 2 * (width + height);
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", type=" + type + ", 넓이:" + area() + ", 둘레:"
				+ length() + "]";
	}

}
