package ch06;

/*	width, height 변수
	Rectangle 클래스
	접근제한자 default, 모든 멤버 : 인스턴스
	멤버메서드로는 넓이를 print하는 area(), 둘레를 print하는 length()
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
		System.out.println("높이 : " + re1.height + ", 길이 : " + re1.width );
		re1.area();
		re1.length();
		
		System.out.print("re2 \t");
		System.out.println("높이 : " + re2.height + ", 길이 : " + re2.width );
		re2.area();
		re2.length();
 	}

}

class Rectangle {
	int width;
	int height;
	
	void area() {
		System.out.println("넓이 : " + width * height);
	}
	void length() {
		System.out.println("둘레 : " + 2*(width + height));
	}
}
