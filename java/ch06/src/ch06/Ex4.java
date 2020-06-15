package ch06;

/*
	Rectangle2 Ŭ���� ����
	������� : width, height, serialNo, static sno
	����޼ҵ� : 
		int area() : ����
		int length() : �ѷ�
		toString()
		
	1���簢�� : ����(10) ����(20)
	2�� : ����(15) ����(25)
	3�� : ����(20) ����(30)
	�簢���� ����, �ѷ� ����ϰ� ��ü �������հ� �ѷ� �� ���

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
		return serialNo + "���簢�� : (" + width +", "+ height + ") => ���� : " + area() + ", �ѷ� : " + length();
	}
	
	
}
