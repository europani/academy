package ch06;
/*
	Circle Ŭ���� ����
	1.�������
	������(r), x��ǥ(x), y��ǥ(y), ���ǹ�ȣ(no)
	���ǹ�ȣ�������� static count
	
	2.������ : new Circle(r, x, y), new Circle(x, y), new Circle(r)
	3.����޼���
	double area() : ���� ����
	double length() : ���� �ѷ�
	void move(int a, int b) : x,y��ǥ�� x+a, y+b�� �̵�
	void scale(double m) : �������� m�� Ȯ��/���
	String toString() : 
		1���� : ������ : 10, ��ǥ:(10, 10), ����:314.xxx, �ѷ�:xxx.xxx	
	
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
		return String.format("%d���� => ������ : %d, ��ǥ : (%d, %d), ����: %.3f, �ѷ�: %.3f", no, r, x, y, area(), length());
//		return no + "���� => ������ : " + r + ", ��ǥ: (" + x + ", " + y + "), ����: " + area() + ", �ѷ�: " + length();
	}
	
	
}
