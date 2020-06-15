package ch09;

public class ClassEx1 {

	public static void main(String[] args) {
		Sample s = new Sample();
		s.num = 99;
		System.out.println(s);
		
		try {
			Class<?> c = Class.forName("ch09.Sample");
			Sample e = (Sample) c.newInstance();
			e.num = 10;
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}

class Sample {
	int num;

	@Override
	public String toString() {
		return num + "";
	}
	
}
