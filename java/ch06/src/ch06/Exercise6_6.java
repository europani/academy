package ch06;

public class Exercise6_6 {

	public static void main(String[] args) {
		System.out.println(getDistance(1, 1, 2, 2));
		
		Mypoint mp = new Mypoint(1, 1);
		System.out.println(mp.getDistnace2());
	}
	
	static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
	}
	
	
	

}

class Mypoint {
	int x;
	int y;
	
	
	Mypoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double getDistnace2() {
		return Math.sqrt(Math.pow(2-x, 2)+Math.pow(2-y, 2));
	}
}
