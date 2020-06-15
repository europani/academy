package ch06;
/*
	Rectangle2 클래스 정의
	멤버변수 : width, height, serialNo, static sno
	멤버메소드 : 
		int area() : 면적
		int length() : 둘레
		toString()
		
	1번사각형 : 가로(10) 세로(20)
	2번 : 가로(15) 세로(25)
	3번 : 가로(20) 세로(30)
	사각형의 면적, 둘레 출력하고 전체 면적의합과 둘레 합 출력
	
*/

public class Exam4 {

	public static void main(String[] args) {
		Rectangle2[] rArr = new Rectangle2[3];
		int totalArea = 0;
		int totalLength = 0;
		for (int i = 0; i < rArr.length; i++) {
			rArr[i] = new Rectangle2();
			rArr[i].width = 10 + i * 5;
			rArr[i].height = 20 + i * 5;
			rArr[i].serialNo = ++Rectangle2.sno;
			System.out.println(rArr[i]);
			
			totalArea += rArr[i].area();
			totalLength += rArr[i].length();
		
		}
		System.out.println("전체 사각형의 면적의 합 : " + totalArea);
		System.out.println("전체 사각형의 둘레의 합 : " + totalLength);

	}
}

class Rectangle2 {
	int width;
	int height;
	int serialNo;
	static int sno;

	int area() {
		return width * height;
	}

	int length() {
		return 2 * (width + height);
	}

	@Override
	public String toString() {
		return serialNo + "번사각형 : (" + width +", "+ height + ") => 면적 : " + area() + ", 둘레 : " + length();
	}

}
