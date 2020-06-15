package ch08;

public class Exam4 {

	public static void main(String[] args) {
		try {
			throw new MyException3();
		} catch (MyException3 e) {
			System.out.println("MyException3 抗寇贸府");
		} catch (MyException2 e) {
			System.out.println("MyException2 抗寇贸府");
		} catch (Exception e) {
			System.out.println("Exception 抗寇贸府");
		}
	}

}

class MyException2 extends Exception {}
class MyException3 extends MyException2 {}
