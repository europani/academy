package ch08;

public class Exam4 {

	public static void main(String[] args) {
		try {
			throw new MyException3();
		} catch (MyException3 e) {
			System.out.println("MyException3 ����ó��");
		} catch (MyException2 e) {
			System.out.println("MyException2 ����ó��");
		} catch (Exception e) {
			System.out.println("Exception ����ó��");
		}
	}

}

class MyException2 extends Exception {}
class MyException3 extends MyException2 {}
