package ch06;

public class ConstructorEx1 {

	public static void main(String[] args) {
		Number1 n1 = new Number1();
		n1.num = 10;
		Number2 n2 = new Number2(20);
		System.out.println("Number1 클래스의 num = " + n1.num);
		System.out.println("Number2 클래스의 num = " + n2.num);
	}

}

class Number1 {
	int num;
}
class Number2 {
	int num;
	
	Number2(int x) {
		num = x;
	}
}
