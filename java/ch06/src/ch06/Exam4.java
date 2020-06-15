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
		System.out.println("��ü �簢���� ������ �� : " + totalArea);
		System.out.println("��ü �簢���� �ѷ��� �� : " + totalLength);

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
		return serialNo + "���簢�� : (" + width +", "+ height + ") => ���� : " + area() + ", �ѷ� : " + length();
	}

}
