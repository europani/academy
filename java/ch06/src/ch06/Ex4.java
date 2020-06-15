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

public class Ex4 {

	public static void main(String[] args) {
		Rectangle21[] rArr = new Rectangle21[3];
		int totalLength=0;
		int totalArea=0;
		for (int i = 0; i < rArr.length; i++) {
			rArr[i] = new Rectangle21();
			rArr[i].width = 10+5*i;
			rArr[i].height = 20+5*i;
			rArr[i].serialNo = ++Rectangle21.sno;
			System.out.println(rArr[i]);
		
			totalArea += rArr[i].area();
			totalLength += rArr[i].length();
		}
		System.out.println(totalArea);
		System.out.println(totalLength);

	}

}

class Rectangle21 {
	int width, height, serialNo;
	static int sno;
	
	int area() {
		return width * height;
	}
	int length() {
		return 2*(width + height);
	}
	@Override
	public String toString() {
		return serialNo + "번사각형 : (" + width +", "+ height + ") => 면적 : " + area() + ", 둘레 : " + length();
	}
	
	
}
