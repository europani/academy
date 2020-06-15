package ch06;
/*
	Circle 클래스 구현
	1.멤버변수
	반지름(r), x좌표(x), y좌표(y), 원의번호(no)
	원의번호생성변수 static count
	
	2.생성자 : new Circle(r, x, y), new Circle(x, y), new Circle(r)
	3.멤버메서드
	double area() : 원의 넓이
	double length() : 원의 둘레
	void move(int a, int b) : x,y좌표를 x+a, y+b로 이동
	void scale(double m) : 반지름을 m배 확대/축소
	String toString() : 
		1번원 : 반지름 : 10, 좌표:(10, 10), 넓이:314.xxx, 둘레:xxx.xxx	
	
*/

public class Exam6 {

	public static void main(String[] args) {
		Circle[] carr = new Circle[3];
		carr[0] = new Circle(10, 10, 10);
		carr[1] = new Circle(20, 20);
		carr[2] = new Circle(100);
		for (Circle c : carr) {
			System.out.println(c);
			c.move(10, 10);
			System.out.println(c);
			c.scale(3);
			System.out.println(c);
		
		}
	}

}

class Circle {
	int r, x, y, no;
	static int count;
	
	Circle(int r){
		this(r, 0, 0);
		
	}
	Circle(int x, int y) {
		this(1, x, y);
	}
	Circle(int r, int x, int y) {
		this.r = r;
		this.x = x;
		this.y = y;
		no = ++count;
	}
	
	double area() {
		return Math.PI*r*r;
	}
	double length() {
		return 2*r*Math.PI;
	}
	void move(int a, int b) {
		x += a;
		y += b;
	}
	void scale(double m) {
		r *= m;
	}
	@Override
	public String toString() {
		return String.format("%d번원 => 반지름 : %d, 좌표 : (%d, %d), 넓이: %.3f, 둘레: %.3f", no, r, x, y, area(), length());
//		return no + "번원 => 반지름 : " + r + ", 좌표: (" + x + ", " + y + "), 넓이: " + area() + ", 둘레: " + length();
	}
	
	
}
