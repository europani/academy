package ch09;

public class CloneEx1 {

	public static void main(String[] args) {
		Point original = new Point(3, 5);
		Point copy = (Point) original.clone();
		System.out.print(original);
		System.out.println(" ["+original.hashCode()+"]");
		System.out.print(copy);
		System.out.println(" ["+copy.hashCode()+"]");
		System.out.println(original == copy);
	}

}

class Point implements Cloneable {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	protected Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}
	
	
	
}
