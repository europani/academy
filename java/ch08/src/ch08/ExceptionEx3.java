package ch08;

	public class ExceptionEx3 {
	
		public static void main(String[] args) {
			try {
				System.out.print(1);
				System.out.print(2);
				System.out.print(3/0);
				System.out.print(4);
			} catch (Exception e) {
				System.out.print(5);
				return;
			} finally {
				System.out.print(6);
			}
			System.out.print(7);
		}	
	}
