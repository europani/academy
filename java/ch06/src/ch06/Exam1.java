package ch06;

/*	width, height ����
	Rectangle Ŭ����
	���������� default, ��� ��� : �ν��Ͻ�
	����޼���δ� ���̸� print�ϴ� area(), �ѷ��� print�ϴ� length()
*/

public class Exam1 {

	public static void main(String[] args) {
		Rectangle re1 = new Rectangle();
		re1.width = 10;
		re1.height = 5;
		
		Rectangle re2 = new Rectangle();
		re2.width = 30;
		re2.height = 20;
		
		System.out.print("re1 \t");
		System.out.println("���� : " + re1.height + ", ���� : " + re1.width );
		re1.area();
		re1.length();
		
		System.out.print("re2 \t");
		System.out.println("���� : " + re2.height + ", ���� : " + re2.width );
		re2.area();
		re2.length();
 	}

}

class Rectangle {
	int width;
	int height;
	
	void area() {
		System.out.println("���� : " + width * height);
	}
	void length() {
		System.out.println("�ѷ� : " + 2*(width + height));
	}
}
